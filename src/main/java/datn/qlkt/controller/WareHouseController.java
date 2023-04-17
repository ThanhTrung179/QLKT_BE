package datn.qlkt.controller;

import datn.qlkt.dto.dtos.WareHouseFilter;
import datn.qlkt.entities.MyResponse;
import datn.qlkt.service.Impl.WareHouseServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/warehouse")
public class WareHouseController {
    @Autowired
    WareHouseServiceImpl wareHouseService;

    @GetMapping("/search")
    public MyResponse<?> searchWareHouse(WareHouseFilter wareHouseFilter) throws Exception {
        var page = wareHouseService.searchWareHouse(wareHouseFilter);
        return MyResponse.response(page);
    }
}
