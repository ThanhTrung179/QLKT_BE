package datn.qlkt.entities;

public class ErrorCode {
    public static final String OK = "200";
    public static final ObjectError SERVER_ERROR = new ObjectError("EX001", "Lỗi Server không hoạt động");
    public static final ObjectError VALID_OBJ = new ObjectError("EX002", "Lỗi valid dữ liệu");
    public static final ObjectError CREATED_FAIL = new ObjectError("EX003", "Lỗi Created fail");
    public static final ObjectError UPDATED_FAIL = new ObjectError("EX004", "Lỗi Update faile");
    public static final ObjectError NOT_FOUND_OBJECT = new ObjectError("EX005", "Không tìm thấy dữ liệu");
    public static final ObjectError SELECT_FAIL = new ObjectError("EX006", "Đã có lỗi trong quá trình xử lý, vui lòng thực hiện vào lúc khác!");
    public static final ObjectError DELETED_FAIL = new ObjectError("EX007", "Không thể xóa đối tượng được chọn!");


    public static final ObjectError CREATED_OK = new ObjectError("200", "Thêm mới thành công!");
    public static final ObjectError UPDATED_OK = new ObjectError("200", "Cập nhật thành công!");
    public static final ObjectError DELETED_OK = new ObjectError("200", "Delete thành công");
}
