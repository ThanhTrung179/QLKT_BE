package datn.qlkt.dto.request;


import datn.qlkt.model.WareHouse;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class EntryForm {

    private String note;
    private Long moneyTotal;
    private String creator;
    private List<WareHouseForm> wareHouseForm;

    public EntryForm() {
    }

    public EntryForm(String note, WareHouseForm wareHouseForm, String creator, Long moneyTotal) {
        this.note = note;
        this.creator = creator;
        this.moneyTotal =moneyTotal;
        this.wareHouseForm = (List<WareHouseForm>) wareHouseForm;
    }
}
