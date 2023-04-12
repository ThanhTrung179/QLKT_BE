package datn.qlkt.page;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class Ipage<T> {
    private long totalElements;
    private T records;

    private Ipage(long totalElements, T obj) {
        this.records = obj;
        this.totalElements = totalElements;
    }

    public static <T> Ipage<T> response(long totalElements, T obj) {
        return new Ipage<>(totalElements, obj);
    }

    public T getRecords() {
        return records;
    }
}
