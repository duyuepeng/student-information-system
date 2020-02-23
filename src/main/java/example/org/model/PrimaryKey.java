package example.org.model;

public interface PrimaryKey<T, S> {
    public void changePk(T obj);

    public T retrievePk();

    public S pk(T obj);
}
