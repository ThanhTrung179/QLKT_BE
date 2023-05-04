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
    private List<WareHouseDto> wareHouse;

    public EntryDto() {
    }

    public EntryDto(Long id, String idEntry, Date inTime, String note, List<WareHouseDto> wareHouse) {
        this.id = id;
        this.idEntry = idEntry;
        this.inTime = inTime;
        this.note = note;
        this.wareHouse = wareHouse;
    }
}
