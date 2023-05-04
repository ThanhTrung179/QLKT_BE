package datn.qlkt.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Table(name = "ware_house")
public class WareHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "warehouse_product",
            joinColumns = @JoinColumn(name = "warehouser_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    Set<Product> product = new HashSet<>();
    private Date expiry;
    private Date manufactureDate;
    private Date intime = new Date();
    private Integer is_active;
    private Integer quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entry_id")
    private Entry entry;


    public WareHouse(Long id, Set<Product> product, Date expiry, Date manufactureDate, Date intime, Integer is_active, Integer quantity, Entry entry) {
        this.id = id;
        this.product = product;
        this.expiry = expiry;
        this.manufactureDate = manufactureDate;
        this.intime = intime;
        this.is_active = is_active;
        this.quantity = quantity;
        this.entry = entry;
    }

    public WareHouse() {
    }

    public WareHouse (
             Date expiry,
             Date manufactureDate,
             Integer is_active,
             Integer quantity
    ) {
        this.expiry = expiry;
        this.manufactureDate = manufactureDate;
        this.is_active = is_active;
        this.quantity = quantity;
    }

}
