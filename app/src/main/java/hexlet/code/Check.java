package hexlet.code;
@FunctionalInterface
public interface Check<T> {
    boolean test(T t);
}
