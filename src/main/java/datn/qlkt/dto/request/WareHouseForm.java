package datn.qlkt.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WareHouseForm {

    private Date expiry;
    private Date manufacture_date;
    private Integer is_active;
    private String product;

    public WareHouseForm() {
    }

    public WareHouseForm(Date expiry, Date manufacture_date, Integer is_active, String product) {
        this.expiry = expiry;
        this.manufacture_date = manufacture_date;
        this.is_active = is_active;
        this.product = product;
    }
}
