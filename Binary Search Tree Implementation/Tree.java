public interface Tree<T> {
    public void traverse();
    public void insert(T data);
    public void delete(T data);
    public T getMax();
    public T getMin();

}
