package exercise3;

public interface Field<T> extends Comparable<T> {
    T add(T a);
    T sub(T a);
    T mul(T a);
    T div(T a);
}
