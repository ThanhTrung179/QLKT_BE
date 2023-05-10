package datn.qlkt.dto.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class EntryDto {
    private Long id;
    private String idEntry;
    private Date inTime;
    private String note;
    private Integer isActive;
    private Long moneyTotal;
    private String creator;
    private List<WareHouseDto> wareHouse;

    public EntryDto() {
    }

    public EntryDto(Long id, String idEntry, Date inTime, String note, List<WareHouseDto> wareHouse, Long moneyTotal, String creator, Integer isActive) {
        this.id = id;
        this.idEntry = idEntry;
        this.inTime = inTime;
        this.note = note;
        this.wareHouse = wareHouse;
        this.moneyTotal = moneyTotal;
        this.creator = creator;
        this.isActive = isActive;
    }
}
