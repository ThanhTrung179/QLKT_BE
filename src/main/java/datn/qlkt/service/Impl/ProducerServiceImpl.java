package datn.qlkt.service.Impl;

import datn.qlkt.model.Producer;
import datn.qlkt.model.Product;
import datn.qlkt.model.Product_producer;
import datn.qlkt.repository.ProducerRespository;
import datn.qlkt.repository.ProductRepository;
import datn.qlkt.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Producer[] getAllProducer() {
        List<Producer> producerList = producerRespository.findAll();
        Producer[] array = producerList.toArray(new Producer[0]);
        return array;
    }


}
