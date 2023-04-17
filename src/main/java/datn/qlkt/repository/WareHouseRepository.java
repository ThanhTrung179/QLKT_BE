package datn.qlkt.repository;

import datn.qlkt.model.Product;
import datn.qlkt.model.WareHouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WareHouseRepository extends JpaRepository<WareHouse, Long> {

    @Query(value = "SELECT w FROM WareHouse w left join Warehouse_product wp ON wp.warehouser_id = w.id LEFT JOIN Product p ON wp.product_id = p.id where (w.is_active = :isActive)" +
            "And (:productName IS NULL OR p.productName like %:productName%) " +
            "And (:productId IS NULL OR p.productId like %:productId%) "
    )
    Page<Product> getAllWareHouseList(Pageable pageable, String productName, String productId, Integer isActive);
}
