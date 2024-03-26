package datn.qlkt.repository;

import datn.qlkt.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProducerRespository extends JpaRepository<Producer, Long> {
    Optional<Producer> findByProducerName(String producerName);

    Optional<Producer> findByAddress(String address);

    @Query(value = "SELECT p from Producer p where p.is_active = 1 " +
            "AND (:producerName IS NULL OR p.producerName like %:producerName%) " +
            "AND (:idProducer IS NULL OR p.idProducer like %:idProducer%) ")
    Page<Producer> getAllProducer(Pageable pageable, String producerName, String idProducer);
}
