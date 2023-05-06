package datn.qlkt.service;

import datn.qlkt.dto.dto.WareHouseDto;
import datn.qlkt.dto.dtos.ProductFilter;
import datn.qlkt.dto.dtos.WareHouseFilter;
import datn.qlkt.model.Product;
import datn.qlkt.model.WareHouse;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface WareHouseService {

    Optional<WareHouse> findById(Long id) ;

    Page<WareHouseDto> searchWareHouse(WareHouseFilter wareHouseFilter) throws Exception;

     WareHouse updateWareHouse(WareHouse wareHouse , Long id) throws Exception;

     WareHouse save(WareHouse wareHouse) throws Exception;


}
