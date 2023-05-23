package datn.qlkt.service;

import datn.qlkt.dto.dto.EntryDto;
import datn.qlkt.dto.dtos.EntryFilter;
import datn.qlkt.dto.dtos.SaleEntryFilter;
import datn.qlkt.dto.request.EntryForm;
import datn.qlkt.entities.SaleEntry;
import datn.qlkt.model.Entry;
import org.springframework.data.domain.Page;

import java.text.ParseException;
import java.util.Optional;

public interface EntryService {

    Entry save(EntryForm entryForm) throws Exception;

    Optional<EntryDto> findById(Long id) ;

    Page<EntryDto> searchEntry(EntryFilter entryFilter) throws Exception;

    void approveEntry(Integer isActive, Long id) throws Exception;

    SaleEntry saleEntry(SaleEntryFilter saleEntryFilter) throws ParseException;
}
