package datn.qlkt.repository;

import datn.qlkt.model.Entry;
import datn.qlkt.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {

    @Query(value = "SELECT e FROM Entry e left join WareHouse w ON w.id = e.wareHouse.id LEFT JOIN " +
            "Warehouse_product wp ON w.id = wp.warehouser_id LEFT JOIN " +
            "Product p on wp.product_id = p.id LEFT JOIN Product_producer pp ON pp.product_id = p.id left join Producer pe ON pp.producer_id = pe.id where " +
            "(:idEntry IS NULL OR e.idEntry like %:idEntry%) " +
            "And (:nameProduct IS NULL OR p.productName like %:nameProduct%) "+
            "And (:nameProducer IS NULL OR pe.producerName like %:nameProducer%) "+
            "And (:startDate IS NULL OR :endDate IS NULL OR e.inTime between :startDate and :endDate ) "
    )
    Page<Entry> getAllEntryList(Pageable pageable, String nameProduct, String idEntry, String nameProducer, Date startDate, Date endDate);

    @Query(value = "SELECT e FROM Entry e left join WareHouse w ON w.id = e.wareHouse.id LEFT JOIN " +
            "Warehouse_product wp ON w.id = wp.warehouser_id LEFT JOIN " +
            "Product p on wp.product_id = p.id LEFT JOIN Product_producer pp ON pp.product_id = p.id left join Producer pe ON pp.producer_id = pe.id where " +
            "(:idEntry IS NULL OR e.idEntry like %:idEntry%) " +
            "And (:nameProduct IS NULL OR p.productName like %:nameProduct%) "+
            "And (:nameProducer IS NULL OR pe.producerName like %:nameProducer%) "
    )
    Page<Entry> getAllEntryListNotDate(Pageable pageable, String nameProduct, String idEntry, String nameProducer);
}
