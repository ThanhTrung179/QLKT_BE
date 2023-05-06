package datn.qlkt.service;

import datn.qlkt.dto.dto.EntryDto;
import datn.qlkt.dto.dto.ExportDto;
import datn.qlkt.dto.dtos.EntryFilter;
import datn.qlkt.dto.dtos.ExportFilter;
import datn.qlkt.dto.request.EntryForm;
import datn.qlkt.model.Entry;
import datn.qlkt.model.Export;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ExportService {
    void save(EntryForm entryForm) throws Exception;

    Page<ExportDto> searchExport(ExportFilter exportFilter) throws Exception;

    Optional<ExportDto> findById(Long id);
}
