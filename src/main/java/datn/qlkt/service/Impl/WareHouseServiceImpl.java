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

import java.util.Optional;

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
        Pageable pageable = PageRequest.of(wareHouseFilter.page(), wareHouseFilter.size());
        var result = wareHouseRepository.getAllWareHouseList(pageable, wareHouseFilter.productId(), wareHouseFilter.productName(), wareHouseFilter.isActive());
        return result;
    }

    @Override
    public WareHouse updateWareHouse(WareHouse wareHouse, Long id) throws Exception {
        return null;
    }

    @Override
    public WareHouse save(WareHouse wareHouse) throws Exception {
        return null;
    }
}
