package datn.qlkt.service.Impl;

import datn.qlkt.dto.dto.EntryDto;
import datn.qlkt.dto.dtos.EntryFilter;
import datn.qlkt.dto.request.EntryForm;
import datn.qlkt.dto.request.WareHouseForm;
import datn.qlkt.model.Entry;
import datn.qlkt.model.Product;
import datn.qlkt.model.WareHouse;
import datn.qlkt.repository.EntryRepository;
import datn.qlkt.repository.ProductRepository;
import datn.qlkt.service.EntryService;
import datn.qlkt.service.WareHouseService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
        entryRepository.save(entry);
        for(WareHouseForm wareHouseForm: entryForm.getWareHouseForm()){
            WareHouse wareHouse = new WareHouse();
            Set<Product> products = new HashSet<>();
            Product product = productRepository.findByProductName(wareHouseForm.getProduct()).orElseThrow(
                    ()-> new RuntimeException("Không tìm được Sản phẩm"));
            products.add(product);
            wareHouse.setProduct(products);
            wareHouse.setExpiry(wareHouseForm.getExpiry());
            wareHouse.setManufactureDate(wareHouseForm.getManufacture_date());
            wareHouse.setQuantity(wareHouseForm.getQuantity());
            wareHouse.setIs_active(1);
            wareHouse.setEntry(entry);
            wareHouseService.save(wareHouse);
        }
        return entry;
    }

    @Override
    public Page<EntryDto> searchEntry(EntryFilter entryFilter) throws Exception {
        ModelMapper modelMapper = new ModelMapper();

        log.info("--------- search eNTRY  -----------");
        Pageable pageable = PageRequest.of(entryFilter.page(), entryFilter.size());
        Page<Entry> entries;
        if(entryFilter.startDate() != null || entryFilter.endDate() != null) {
            entries = entryRepository.getAllEntryListNotDate(pageable, entryFilter.nameProduct(), entryFilter.idEntry(), entryFilter.nameProducer());

        }
        else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = dateFormat.parse(entryFilter.startDate());
            Date endDate = dateFormat.parse(entryFilter.endDate());
             entries = entryRepository.getAllEntryList(pageable, entryFilter.nameProduct(), entryFilter.idEntry(), entryFilter.nameProducer(), startDate, endDate);
        }

        return entries.map(entry -> modelMapper.map(entry, EntryDto.class));
    }
}
