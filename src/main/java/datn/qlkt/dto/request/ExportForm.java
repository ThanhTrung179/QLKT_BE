package datn.qlkt.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ExportForm {
    private String note;
    private List<WareHouseForm> wareHouseForm;

    public ExportForm() {
    }

    public ExportForm(String note, WareHouseForm wareHouseForm) {
        this.note = note;
        this.wareHouseForm = (List<WareHouseForm>) wareHouseForm;
    }

}
