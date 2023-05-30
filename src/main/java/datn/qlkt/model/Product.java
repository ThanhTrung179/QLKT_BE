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

    private String productId;
    @NotBlank

    private String productName;
    @NotBlank

    private String concentration; //ham luong thuoc
    @NotBlank

    private String ingredients; //hoat chat
    @NotBlank

    private String regulations; //quy cach
    private String price; //don gia

    private String medicinesUseFor; //su dung cho

    private String sideEffects; //tac dung phu

    private String dosage; //lieu dung

    private String useMedicine; //cach dung

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "product_producer",
            joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "producer_id"))
    Set<Producer> producers = new HashSet<>();
    @CreatedDate
    private Date inTime = new Date();
    private Integer isActive;

    public Product(Long id, String productId, String productName, String concentration, String ingredients, String regulations, Set<Producer> producers, Date inTime, Integer isActive, String price, String medicinesUseFor, String sideEffects,String dosage, String useMedicine) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.concentration = concentration;
        this.ingredients = ingredients;
        this.regulations = regulations;
        this.producers = producers;
        this.inTime = inTime;
        this.price = price;
        this.isActive = isActive;
        this.medicinesUseFor = medicinesUseFor;
        this.sideEffects = sideEffects;
        this.dosage = dosage;
        this.useMedicine = useMedicine;
    }

    public Product (
            @NotBlank
            String productId,
            @NotBlank
            String productName,
    @NotBlank
     String concentration, //ham luong thuoc
    @NotBlank
     String ingredients, //hoat chat
    @NotBlank
     String regulations,
            String price,
            String medicinesUseFor,
            String sideEffects,
            String dosage,
            String useMedicine
    ) {
        this.productId = productId;
        this.productName = productName;
        this.concentration = concentration;
        this.ingredients = ingredients;
        this.regulations = regulations;
        this.price = price;
        this.medicinesUseFor = medicinesUseFor;
        this.sideEffects = sideEffects;
        this.dosage = dosage;
        this.useMedicine = useMedicine;
    }

    public Product() {

    }


}
