package datn.qlkt.service;

import datn.qlkt.model.WareHouse;
import datn.qlkt.model.WareHouseExport;

public interface WareHouseExportService {
    WareHouseExport save(WareHouseExport wareHouse) throws Exception;
}
