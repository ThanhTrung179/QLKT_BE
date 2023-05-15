package datn.qlkt.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ExportForm {
    private String note;
    private Long moneyTotal;
    private String creator;
    private List<WareHouseForm> wareHouseForm;

    public ExportForm() {
    }

    public ExportForm(String note, WareHouseForm wareHouseForm, Long moneyTotal, String creator) {
        this.note = note;
        this.moneyTotal = moneyTotal;
        this.creator = creator;
        this.wareHouseForm = (List<WareHouseForm>) wareHouseForm;
    }

}
