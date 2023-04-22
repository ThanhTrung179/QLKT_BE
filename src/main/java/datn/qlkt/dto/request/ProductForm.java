package datn.qlkt.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ProductForm {
    private String productId;
    private String productName;
    private String concentration;
    private  String ingredients;
    private  String regulations;
    private String producer;

    public ProductForm(){

    };

    public ProductForm(String productId, String productName, String concentration, String ingredients, String regulations, String producer) {
        this.productId = productId;
        this.productName = productName;
        this.concentration = concentration;
        this.ingredients = ingredients;
        this.regulations = regulations;
        this.producer = producer;
    }
}
