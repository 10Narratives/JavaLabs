package lab3.comparator;

import java.util.function.Function;

public interface Comparator<T> {
    int compare(T obj1, T obj2);

    default Comparator<T> reversed() {
        return (obj1, obj2) -> this.compare(obj2, obj1);
    }

    static <T extends Comparable<T>> Comparator<T> naturalOrder() {
        return Comparable::compareTo;
    }

    static <T extends Comparable<T>> Comparator<T> reverseOrder() {
        return (o1, o2) -> o2.compareTo(o1);
    }

    default Comparator<T> thenComparing(Comparator<T> other) {
        return (o1, o2) -> {
            int result = this.compare(o1, o2);
            return (result != 0) ? result : other.compare(o1, o2);
        };
    }

    static <T, U extends Comparable<U>> Comparator<T> comparing(Function<T, U> keyExtractor) {
        return (o1, o2) -> keyExtractor.apply(o1).compareTo(keyExtractor.apply(o2));
    }
}

