package datn.qlkt.dto.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class ExportDto {
    private Long id;
    private String idExport;
    private Date inTime;
    private String note;
    private List<WareHouseDto> wareHouse;

    public ExportDto() {
    }

    public ExportDto(Long id, String idExport, Date inTime, String note, List<WareHouseDto> wareHouse) {
        this.id = id;
        this.idExport = idExport;
        this.inTime = inTime;
        this.note = note;
        this.wareHouse = wareHouse;
    }
}
