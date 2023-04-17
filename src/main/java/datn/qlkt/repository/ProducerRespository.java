package datn.qlkt.repository;

import datn.qlkt.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProducerRespository extends JpaRepository<Producer, Long> {
    Optional<Producer> findByProducerName(String producerName);
}
