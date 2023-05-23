package datn.qlkt.entities;

import datn.qlkt.dto.dto.EntryDto;
import datn.qlkt.model.Entry;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
public class SaleEntry {

    private Page<EntryDto> entryDto;
    private Long totalAmount;
}
