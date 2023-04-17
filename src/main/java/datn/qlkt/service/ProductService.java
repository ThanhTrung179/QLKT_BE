package datn.qlkt.service;

import datn.qlkt.dto.dtos.ProductFilter;
import datn.qlkt.dto.dtos.UserFilter;
import datn.qlkt.dto.request.ProductForm;
import datn.qlkt.model.Product;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ProductService {

    Optional<Product> findById(Long id) ;

    Page<?> searchProduct(ProductFilter productFilter) throws Exception;

    public Product updateProduct(Product product , Long id) throws Exception;

    public Product save(Product product) throws Exception;
}
