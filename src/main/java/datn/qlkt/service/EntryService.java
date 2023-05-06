package datn.qlkt.service;

import datn.qlkt.dto.dto.EntryDto;
import datn.qlkt.dto.dtos.EntryFilter;
import datn.qlkt.dto.dtos.ProductFilter;
import datn.qlkt.dto.request.EntryForm;
import datn.qlkt.model.Entry;
import datn.qlkt.model.Product;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface EntryService {

    Entry save(EntryForm entryForm) throws Exception;

    Optional<EntryDto> findById(Long id) ;

    Page<EntryDto> searchEntry(EntryFilter entryFilter) throws Exception;

    void approveEntry(Long id) throws Exception;
}
