package datn.qlkt.controller;

import datn.qlkt.dto.dtos.EntryFilter;
import datn.qlkt.dto.dtos.ExportFilter;
import datn.qlkt.dto.request.EntryForm;
import datn.qlkt.entities.ErrorCode;
import datn.qlkt.entities.MyResponse;
import datn.qlkt.service.Impl.ExportServiceImpl;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Log4j2
@RestController
@RequestMapping("/export")
public class ExportController {

    @Autowired
    ExportServiceImpl exportService;


    @PostMapping("/created")
    public MyResponse<?> save(@Valid @RequestBody EntryForm entryForm) throws Exception {
        try {
            exportService.save(entryForm);
            return MyResponse.response(ErrorCode.CREATED_OK.getCode(), ErrorCode.CREATED_OK.getMsgError());
        }
        catch (Exception ex) {
            log.info(ex);
            return MyResponse.response(ErrorCode.CREATED_FAIL.getCode(), ErrorCode.CREATED_FAIL.getMsgError());
        }
    }

    @GetMapping("/search")
    public MyResponse<?> search(ExportFilter exportFilter) throws Exception {
        var list = exportService.searchExport(exportFilter);
        return MyResponse.response(list);

    }

    @GetMapping("/find/{id}")
    public MyResponse<?> findbyid(@PathVariable Long id) throws Exception {
        var warehouser = exportService.findById(id);
        return MyResponse.response(warehouser);
    }
}
