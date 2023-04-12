package datn.qlkt.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class MyResponse<T> {

    private String errorCode = "200";
    private String message = "Ok";
    private T data;

    MyResponse(T obj) {
        this.data = obj;
    }

    MyResponse(T obj, String message) {
        this.data = obj;
        this.message = message;
    }

    MyResponse(String errorCode, String message, T obj) {
        this.data = obj;
        this.message = message;
        this.errorCode = errorCode;
    }


    MyResponse(String errorCode) {
        this.errorCode = errorCode;
    }

    public static MyResponse<Object> response(Object dRes) {

        return new MyResponse<>(dRes);
    }

    public static MyResponse<Object> response(String errorCode, String message) {
        return new MyResponse<>(errorCode, message, null);
    }
}
