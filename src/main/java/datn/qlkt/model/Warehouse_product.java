package datn.qlkt.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "warehouse_product")
public class Warehouse_product {
    private Long warehouser_id;
    @Id
    private Long product_id;
}
