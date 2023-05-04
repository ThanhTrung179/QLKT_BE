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
    private List<WareHouseForm> wareHouseForm;

    public EntryForm() {
    }

    public EntryForm(String note, WareHouseForm wareHouseForm) {
        this.note = note;
        this.wareHouseForm = (List<WareHouseForm>) wareHouseForm;
    }
}
