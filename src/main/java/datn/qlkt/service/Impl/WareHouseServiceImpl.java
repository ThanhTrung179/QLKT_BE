package datn.qlkt.service.Impl;

import datn.qlkt.dto.dtos.ProductFilter;
import datn.qlkt.dto.dtos.WareHouseFilter;
import datn.qlkt.model.Product;
import datn.qlkt.model.WareHouse;
import datn.qlkt.repository.WareHouseRepository;
import datn.qlkt.service.WareHouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class WareHouseServiceImpl implements WareHouseService {
    @Autowired
    WareHouseRepository wareHouseRepository;

    @Override
    public Optional<WareHouse> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Page<?> searchWareHouse(WareHouseFilter wareHouseFilter) throws Exception {
        log.info("--------- search  -----------");
        var test = wareHouseFilter.isActive();
        List<Integer> numberList = Arrays.stream(test.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Pageable pageable = PageRequest.of(wareHouseFilter.page(), wareHouseFilter.size());
        var result = wareHouseRepository.getAllWareHouseList(pageable, wareHouseFilter.productId(), wareHouseFilter.productName(), numberList);
        return result;
    }

    @Override
    public WareHouse updateWareHouse(WareHouse wareHouse, Long id) throws Exception {
        log.info("--------update warehouse---------");
        Optional<WareHouse> optionalWareHouse = wareHouseRepository.findById(id);
        if(!optionalWareHouse.isPresent()) {
            throw new Exception("warehouse không được update");
        }
        WareHouse wareHouse1 = new WareHouse();
        wareHouse1.setIs_active(wareHouse.getIs_active());
        wareHouse1.setProduct(wareHouse.getProduct());
        wareHouse1.setExpiry(wareHouse.getExpiry());
        wareHouse1.setManufactureDate(wareHouse.getManufactureDate());
        return wareHouseRepository.save(wareHouse1);
    }

    @Override
    public WareHouse save(WareHouse wareHouse) throws Exception {
        return wareHouseRepository.save(wareHouse);
    }
}
