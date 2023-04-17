package datn.qlkt.service;

import datn.qlkt.model.Producer;
import datn.qlkt.model.Product_producer;
import datn.qlkt.model.Role;
import datn.qlkt.model.RoleName;

import java.util.Optional;

public interface ProducerService {
    Optional<Producer> findByName(String name);

    public Producer save(Producer producer);


    Producer[] getAllProducer();
}
