package datn.qlkt.service;

import datn.qlkt.dto.dto.ExportDto;
import datn.qlkt.dto.dtos.ExportFilter;
import datn.qlkt.dto.dtos.SaleEntryFilter;
import datn.qlkt.dto.dtos.SaleExportFilter;
import datn.qlkt.dto.request.EntryForm;
import datn.qlkt.entities.SaleExport;
import org.springframework.data.domain.Page;

import java.text.ParseException;
import java.util.Optional;

public interface ExportService {
    void save(EntryForm entryForm) throws Exception;

    Page<ExportDto> searchExport(ExportFilter exportFilter) throws Exception;

    Optional<ExportDto> findById(Long id);

    void approveExport(Long id,Integer isActive) throws Exception;

    SaleExport saleExport(SaleExportFilter saleExportFilter) throws ParseException;
}
