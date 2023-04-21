package datn.qlkt.repository;

import datn.qlkt.model.Product;
import datn.qlkt.model.WareHouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.List;

@Repository
public interface WareHouseRepository extends JpaRepository<WareHouse, Long> {


    @Query(value = "SELECT w FROM WareHouse w left join Warehouse_product wp ON wp.warehouser_id = w.id LEFT JOIN Product p ON wp.product_id = p.id where " +
            "(:productName IS NULL OR p.productName like %:productName%) " +
            "And (:productId IS NULL OR p.productId like %:productId%) " +
            "And w.is_active in (:isActive)"
    )


    Page<WareHouse> getAllWareHouseList(Pageable pageable, String productName, String productId, List<String> isActive);
}
