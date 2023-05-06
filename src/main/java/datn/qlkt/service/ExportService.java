package datn.qlkt.service;

import datn.qlkt.dto.request.EntryForm;
import datn.qlkt.model.Entry;
import datn.qlkt.model.Export;

public interface ExportService {
    void save(EntryForm entryForm) throws Exception;
}
