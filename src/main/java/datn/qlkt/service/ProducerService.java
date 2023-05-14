package datn.qlkt.service;

import datn.qlkt.dto.dtos.ProducerFilter;
import datn.qlkt.dto.dtos.ProductFilter;
import datn.qlkt.model.Producer;
import datn.qlkt.model.Product_producer;
import datn.qlkt.model.Role;
import datn.qlkt.model.RoleName;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ProducerService {
    Optional<Producer> findByName(String name);

    public Producer save(Producer producer);

    Page<?> searchProducer(ProducerFilter producerFilter) throws Exception;

    Producer[] getAllProducer();
}
