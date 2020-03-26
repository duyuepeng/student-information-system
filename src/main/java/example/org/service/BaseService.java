package example.org.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import example.org.model.PrimaryKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class BaseService<T, S, R> {

    protected abstract boolean checkDependency(R obj);

    protected Class<T> mainClass;
    protected DynamoDBMapper mapper;

    public List<T> getList(Map<String, String> kwargs) {
        Map<String, AttributeValue> eav = new HashMap<>();
        Map<String, String> ean = new HashMap<>();
        for (String key : kwargs.keySet()) {
            if (kwargs.get(key) == null)
                continue;
            ean.put("#" + key, key);
            try {
                eav.put(":" + key, new AttributeValue().withN(String.valueOf(Long.parseLong(kwargs.get(key)))));
            } catch (NumberFormatException ignore) {
                eav.put(":" + key, new AttributeValue().withS(kwargs.get(key)));
            }
        }

        if (eav.size() <= 0)
            return mapper.scan(this.mainClass, new DynamoDBScanExpression());

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression(eav.keySet().stream().map(key -> key.replaceFirst(":", "#") + " = " + key).collect(Collectors.joining(" and ")))
                .withExpressionAttributeValues(eav).withExpressionAttributeNames(ean);

        return mapper.scan(this.mainClass, scanExpression);
    }

    protected T setBasicInfo(R basic, T all) {
        return (T) basic;
    }

    public T update(R obj, S pk) {
        T oldObject = (T) this.get(pk);
        if (oldObject == null)
            return null;
        this.checkDependency(obj);
        T objUpdated = this.setBasicInfo((R) obj, (T) oldObject);
        return this.putItem(pk, objUpdated);
    }

    public T get(S pk) {
        return mapper.load(this.mainClass, pk);
    }

    public S generatePk() {
        Long pk = new Random().nextLong();
        if (pk < 0)
            pk = -pk;
        return (S) pk;
    }

    protected T putItem(S key, T obj) {
        mapper.save(obj);
        return obj;
    }

    protected T create(R obj) {
        return (T) obj;
    }

    public T add(R obj) {
        S pk = this.generatePk();
        T newObj = this.create(obj);
        this.checkDependency(obj);
        ((PrimaryKey) newObj).pk(pk);
        newObj = this.setBasicInfo(obj, newObj);
        return this.putItem(pk, (T) newObj);
    }

    protected void deleteDependencies(T obj) {

    }

    public T delete(S pk) {
        T obj = this.get(pk);
        if (obj == null)
            return null;
        this.deleteDependencies(obj);
        this.mapper.delete(obj);
        return obj;
    }
}
