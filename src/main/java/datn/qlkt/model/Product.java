package datn.qlkt.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
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
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    @Size(min = 3, max = 50)
    private String productId;
    @NotBlank
    @Size(min = 3, max = 50)
    private String productName;
    @NotBlank
    @Size(min = 3, max = 50)
    private String concentration; //ham luong thuoc
    @NotBlank
    @Size(min = 3, max = 500)
    private String ingredients; //hoat chat
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "product_producer",
            joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "producer_id"))
    Set<Producer> producers = new HashSet<>();
    @CreatedDate
    private Date inTime = new Date();
    private Integer isActive;
}
