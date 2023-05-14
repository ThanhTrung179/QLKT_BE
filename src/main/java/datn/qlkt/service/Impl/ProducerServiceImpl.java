package datn.qlkt.service.Impl;

import datn.qlkt.dto.dtos.ProducerFilter;
import datn.qlkt.model.Producer;
import datn.qlkt.model.Product;
import datn.qlkt.model.Product_producer;
import datn.qlkt.repository.ProducerRespository;
import datn.qlkt.repository.ProductRepository;
import datn.qlkt.service.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    ProducerRespository producerRespository;
    @Override
    public Optional<Producer> findByName(String producerName) {
        return producerRespository.findByProducerName(producerName);
    }

    public Producer save(Producer producer) {
        producer.setIs_active(1);
        return  producerRespository.save(producer);
    }

    @Override
    public Page<?> searchProduct(ProducerFilter producerFilter) throws Exception {
        log.info("--------- search product  -----------");
        Pageable pageable = PageRequest.of(producerFilter.page(), producerFilter.size());
        var result = producerRespository.getAllProducer(pageable, producerFilter.producerName(), producerFilter.idProducer());
        return result;
    }

    public Producer[] getAllProducer() {
        List<Producer> producerList = producerRespository.findAll();
        Producer[] array = producerList.toArray(new Producer[0]);
        return array;
    }



}
