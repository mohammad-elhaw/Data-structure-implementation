public interface Tree<T> {
    public void insert(T data);
    public void traverse();
    public T getRoot();
    public void delete(T data);
    public T getMax();
    public T getMin();
}
