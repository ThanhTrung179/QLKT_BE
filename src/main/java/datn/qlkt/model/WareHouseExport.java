package datn.qlkt.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Table(name = "ware_house_export")
public class WareHouseExport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "warehouseexport_product",
            joinColumns = @JoinColumn(name = "warehouserexport_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    Set<Product> product = new HashSet<>();
    private Date expiry;
    private Date manufactureDate;
    private Date intime = new Date();
    private Integer is_active;
    private Integer quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "export_id")
    private Export export;
    private Long id_wareHouse;
}
