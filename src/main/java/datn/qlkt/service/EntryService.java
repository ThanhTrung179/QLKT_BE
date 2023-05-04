package datn.qlkt.service;

import datn.qlkt.dto.dto.EntryDto;
import datn.qlkt.dto.dtos.EntryFilter;
import datn.qlkt.dto.dtos.ProductFilter;
import datn.qlkt.dto.request.EntryForm;
import datn.qlkt.model.Entry;
import org.springframework.data.domain.Page;

public interface EntryService {

    Entry save(EntryForm entryForm) throws Exception;

    Page<EntryDto> searchEntry(EntryFilter entryFilter) throws Exception;
}
