package example.org.service;

import example.org.model.PrimaryKey;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class BaseService<T, S, R> {
    protected abstract Map<S, Object> getMap();

    protected abstract boolean checkDependency(R obj);

    public List<T> getList(Map<String, String> kwargs) {
        return (List<T>) new ArrayList<Object>(this.getMap().values()).stream().filter(obj -> {
            boolean flag = true;
            for (Map.Entry<String, String> entry : kwargs.entrySet()) {
                if (entry.getValue() == null)
                    continue;
                try {
                    Method method = obj.getClass().getMethod(
                            "get" + entry.getKey().substring(0, 1).toUpperCase()
                                    + entry.getKey().substring(1).toLowerCase());
                    flag = method.invoke(obj).toString().equals(entry.getValue());
                    if (!flag)
                        break;
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ignored) {
                }
            }

            return flag;
        }).collect(Collectors.toList());
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
        return (T) this.getMap().get(pk);
    }

    public S generatePk() {
        Long pk = new Random().nextLong();
        if (pk < 0)
            pk = -pk;
        return (S) pk;
    }

    protected T putItem(S key, T obj) {
        this.getMap().put(key, obj);
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

    public T delete(S pk) {
        return (T) this.getMap().remove(pk);
    }
}
