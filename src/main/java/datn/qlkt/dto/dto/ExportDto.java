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
    private List<WareHouseExportDto> wareHouseExport;
    private Long moneyTotal;
    private String creator;
    private Integer is_active;

    public ExportDto() {
    }

    public ExportDto(Long id, String idExport, Date inTime, String note, List<WareHouseExportDto> wareHouseExport, Long moneyTotal, String creator, Integer is_active) {
        this.id = id;
        this.idExport = idExport;
        this.inTime = inTime;
        this.note = note;
        this.wareHouseExport = wareHouseExport;
        this.moneyTotal = moneyTotal;
        this.creator = creator;
        this.is_active = is_active;
    }
}
