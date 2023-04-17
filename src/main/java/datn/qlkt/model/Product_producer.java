package datn.qlkt.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_producer")
public class Product_producer {
    private Long product_id;
    @Id
    private Long producer_id;



}
