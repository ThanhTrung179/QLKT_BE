package datn.qlkt.controller;

import datn.qlkt.entities.MyResponse;
import datn.qlkt.service.Impl.ProducerServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    ProducerServiceImpl producerService;


    @GetMapping("/list-producer")
    public MyResponse<?> listProducer() throws Exception{
       var list = producerService.getAllProducer();
        return MyResponse.response(list);
    }
}
