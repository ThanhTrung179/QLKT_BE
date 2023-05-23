package datn.qlkt.entities;

import datn.qlkt.dto.dto.EntryDto;
import datn.qlkt.dto.dto.ExportDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
public class SaleExport {
    private Page<ExportDto> exportDto;
    private Long totalAmount;
}
