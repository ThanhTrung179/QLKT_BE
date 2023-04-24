package datn.qlkt.service.Impl;

import datn.qlkt.dto.dtos.EntryFilter;
import datn.qlkt.dto.request.EntryForm;
import datn.qlkt.model.Entry;
import datn.qlkt.model.Product;
import datn.qlkt.model.WareHouse;
import datn.qlkt.repository.EntryRepository;
import datn.qlkt.repository.ProductRepository;
import datn.qlkt.service.EntryService;
import datn.qlkt.service.WareHouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service

public class EntryServiceImpl implements EntryService {
    @Autowired
    EntryRepository entryRepository;

    @Autowired
    WareHouseServiceImpl wareHouseService;

    @Autowired
    ProductRepository productRepository;
    @Override
    public Entry save(EntryForm entryForm) throws Exception {
        Entry entry = new Entry();
        entry.setNote(entryForm.getNote());
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
        LocalDateTime now = LocalDateTime.now();
        int minute = now.getMinute();
        int hour = now.getHour();
        entry.setIdEntry("NK_" + formattedDate +hour+minute);
        WareHouse wareHouse = new WareHouse();
        Set<Product> products = new HashSet<>();
        Product product = productRepository.findByProductName(entryForm.getWareHouseForm().getProduct()).orElseThrow(
                ()-> new RuntimeException("Không tìm được Sản phẩm"));
        products.add(product);
        wareHouse.setProduct(products);
        wareHouse.setExpiry(entryForm.getWareHouseForm().getExpiry());
        wareHouse.setManufactureDate(entryForm.getWareHouseForm().getManufacture_date());
        wareHouse.setQuantity(entryForm.getWareHouseForm().getQuantity());
        wareHouse.setIs_active(1);
        entry.setWareHouse(wareHouse);
        wareHouseService.save(wareHouse);
        return entryRepository.save(entry);
    }

    @Override
    public Page<?> searchEntry(EntryFilter entryFilter) throws Exception {
        log.info("--------- search eNTRY  -----------");
        Pageable pageable = PageRequest.of(entryFilter.page(), entryFilter.size());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date startDate = dateFormat.parse(entryFilter.startDate());
        Date endDate = dateFormat.parse(entryFilter.endDate());
        var resut = entryRepository.getAllEntryList(pageable,entryFilter.nameProduct(), entryFilter.idEntry(), entryFilter.nameProducer(), startDate, endDate);
        return resut;
    }
}
