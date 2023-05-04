package datn.qlkt.dto.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProducerDto {
    private Long id;
    private String producerName;
    private String address;
    private String information;
    private Integer isActive;

    public ProducerDto() {
    }

    public ProducerDto(Long id, String producerName, String address, String information, Integer isActive) {
        this.id = id;
        this.producerName = producerName;
        this.address = address;
        this.information = information;
        this.isActive = isActive;
    }
}
