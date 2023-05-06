package datn.qlkt.controller;

import datn.qlkt.dto.dtos.EntryFilter;
import datn.qlkt.dto.request.EntryForm;
import datn.qlkt.dto.request.WareHouseForm;
import datn.qlkt.entities.ErrorCode;
import datn.qlkt.entities.MyResponse;
import datn.qlkt.model.Entry;
import datn.qlkt.model.Product;
import datn.qlkt.model.WareHouse;
import datn.qlkt.service.EntryService;
import datn.qlkt.service.Impl.EntryServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Log4j2
@RestController
@RequestMapping("/entry")
public class EntryController {
    @Autowired
    EntryServiceImpl entryService;

    @PostMapping("/created")
    public MyResponse<?> save(@Valid @RequestBody EntryForm entryForm) throws Exception {
        try {
            entryService.save(entryForm);
            return MyResponse.response(ErrorCode.CREATED_OK.getCode(), ErrorCode.CREATED_OK.getMsgError());
        }
        catch (Exception ex) {
            log.info(ex);
            return MyResponse.response(ErrorCode.CREATED_FAIL.getCode(), ErrorCode.CREATED_FAIL.getMsgError());
        }
    }

    @GetMapping("/search")
    public MyResponse<?> search(EntryFilter entryFilter) throws Exception {
            var list = entryService.searchEntry(entryFilter);
            return MyResponse.response(list);

    }

    @GetMapping("/find/{id}")
    public MyResponse<?> findbyid(@PathVariable Long id) throws Exception {
        var warehouser = entryService.findById(id);
        return MyResponse.response(warehouser);
    }

//    @PutMapping("/approve/{id}")
//    public MyResponse<?> approveEntry(@PathVariable Long id) throws Exception {
//
//    }
}
