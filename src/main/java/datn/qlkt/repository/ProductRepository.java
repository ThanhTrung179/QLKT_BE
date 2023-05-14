package datn.qlkt.repository;

import datn.qlkt.model.Producer;
import datn.qlkt.model.Product;
import datn.qlkt.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT p FROM Product p left join Product_producer pp ON pp.product_id = p.id LEFT JOIN Producer pe ON pp.producer_id = pe.id where p.isActive = 1" +
            "And (:productName IS NULL OR p.productName like %:productName%) " +
            "And (:productId IS NULL OR p.productId like %:productId%) "+
            "And (:producers IS NULL OR pe.producerName like %:producers%) "
    )
    Page<Product> getAllProductList(Pageable pageable, String productName, String productId, String producers);

    Optional<Product> findByProductName(String productName);

    @Query(value = "SELECT COUNT(p) FROM Product p LEFT JOIN Warehouse_product wp ON p.id = wp.product_id LEFT JOIN WareHouse w ON  wp.warehouser_id = w.id where p.id = :id AND w.quantityfix > 1")
    Long countProductWareHouse(Long id);
}
