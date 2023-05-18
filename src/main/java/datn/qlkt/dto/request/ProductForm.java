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
    private String price;
    private String medicinesUseFor;
    private String sideEffects;
    private String dosage;
    private String useMedicine;

    public ProductForm(){

    };

    public ProductForm(String productId, String productName, String concentration, String ingredients, String regulations, String producer, String price, String medicinesUseFor,String sideEffects, String dosage,String useMedicine) {
        this.productId = productId;
        this.productName = productName;
        this.concentration = concentration;
        this.ingredients = ingredients;
        this.regulations = regulations;
        this.producer = producer;
        this.price = price;
        this.medicinesUseFor = medicinesUseFor;
        this.sideEffects = sideEffects;
        this.dosage = dosage;
         this.useMedicine = useMedicine;
    }
}
