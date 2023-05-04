package datn.qlkt.dto.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String productId;
    private String productName;
    private String concentration;
    private String ingredients;
    private String regulations;
    private Set<ProducerDto> producers;
    private Date inTime;
    private Integer isActive;

    public ProductDto() {
    }

    public ProductDto(Long id, String productId, String productName, String concentration, String ingredients, String regulations, Set<ProducerDto> producers, Date inTime, Integer isActive) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.concentration = concentration;
        this.ingredients = ingredients;
        this.regulations = regulations;
        this.producers = producers;
        this.inTime = inTime;
        this.isActive = isActive;
    }
}
