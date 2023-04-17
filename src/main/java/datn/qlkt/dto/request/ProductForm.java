package datn.qlkt.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ProductForm {
    private String product_id;
    private String product_name;
    private String concentration;
    private  String ingredients;
    private  String regulations;
    private String producer;

    public ProductForm(){

    };

    public ProductForm(String product_id, String product_name, String concentration, String ingredients, String regulations, String producer) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.concentration = concentration;
        this.ingredients = ingredients;
        this.regulations = regulations;
        this.producer = producer;
    }
}
