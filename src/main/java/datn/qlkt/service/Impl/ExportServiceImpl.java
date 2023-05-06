package datn.qlkt.service.Impl;

import datn.qlkt.dto.request.EntryForm;
import datn.qlkt.dto.request.WareHouseForm;
import datn.qlkt.model.Export;
import datn.qlkt.model.Product;
import datn.qlkt.model.WareHouseExport;
import datn.qlkt.repository.*;
import datn.qlkt.service.ExportService;
import datn.qlkt.service.WareHouseExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
@Service
public class ExportServiceImpl implements ExportService {

    @Autowired
    ExportRepository exportRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    WareHouseExportServiceImpl wareHouseExportService;

    @Autowired
    WareHouseRepository wareHouseRepository;
    @Override
    @Transactional
    public void save(EntryForm entryForm) throws Exception {
        Export export = new Export();
        export.setNote(entryForm.getNote());
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
        LocalDateTime now = LocalDateTime.now();
        int minute = now.getMinute();
        int hour = now.getHour();
        export.setIdExport("PXK_" + formattedDate +hour+minute);
        exportRepository.save(export);
        for(WareHouseForm wareHouseForm: entryForm.getWareHouseForm()){
            WareHouseExport wareHouseExport = new WareHouseExport();
            Set<Product> products = new HashSet<>();
            Product product = productRepository.findByProductName(wareHouseForm.getProduct()).orElseThrow(
                    ()-> new RuntimeException("Không tìm được Sản phẩm"));
            products.add(product);
            wareHouseExport.setProduct(products);
            wareHouseExport.setExpiry(wareHouseForm.getExpiry());
            wareHouseExport.setManufactureDate(wareHouseForm.getManufacture_date());
            wareHouseExport.setQuantity(wareHouseForm.getQuantity());
            var opt = wareHouseRepository.findById(wareHouseForm.getId());
            if (!opt.isPresent()) {
                throw new Exception("Sản phẩm không có trong kho");
            }
            if(wareHouseForm.getQuantity() > opt.get().getQuantity()){
                throw new Exception("Số lượng không đủ");
            }
            var remaining = opt.get().getQuantity() - wareHouseForm.getQuantity();
            if(remaining == 0 ) {
                wareHouseRepository.updateExportWareHouseifClean(remaining, wareHouseForm.getId());
            }else {
                wareHouseRepository.updateExportWareHouse(remaining, wareHouseForm.getId());
            }
            wareHouseExport.setIs_active(1);
            wareHouseExport.setExport(export);
            wareHouseExportService.save(wareHouseExport);
        }
    }
}
