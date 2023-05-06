package datn.qlkt.service.Impl;

import datn.qlkt.model.WareHouseExport;
import datn.qlkt.repository.WareHouseExportRepository;
import datn.qlkt.service.WareHouseExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WareHouseExportServiceImpl implements WareHouseExportService {
    @Autowired
    WareHouseExportRepository wareHouseExportRepository;

    @Override
    public WareHouseExport save(WareHouseExport wareHouseExport) throws Exception {

        wareHouseExport.setIs_active(1);
        return wareHouseExportRepository.save(wareHouseExport);
    }
}
