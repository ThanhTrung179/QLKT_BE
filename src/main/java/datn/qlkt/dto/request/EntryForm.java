package datn.qlkt.dto.request;


import datn.qlkt.model.WareHouse;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EntryForm {

    private String note;
    private WareHouseForm wareHouseForm;

    public EntryForm() {
    }

    public EntryForm(String note, WareHouseForm wareHouseForm) {
        this.note = note;
        this.wareHouseForm = wareHouseForm;
    }
}
