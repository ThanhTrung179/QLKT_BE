package datn.qlkt.service.Impl;

import datn.qlkt.dto.dtos.ProductFilter;
import datn.qlkt.dto.dtos.UserFilter;
import datn.qlkt.dto.request.ProductForm;
import datn.qlkt.model.Product;
import datn.qlkt.model.Product_producer;
import datn.qlkt.model.User;
import datn.qlkt.repository.ProductRepository;
import datn.qlkt.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Page<?> searchProduct(ProductFilter productFilter) throws Exception {
        log.info("--------- search  -----------");
        Pageable pageable = PageRequest.of(productFilter.page(), productFilter.size());
        var result = productRepository.getAllProductList(pageable, productFilter.productId(), productFilter.productName(), productFilter.producers());
        return result;
    }

    @Override
    public Product updateProduct(Product product, Long id) throws Exception {
        log.info("--------update user---------");
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(!optionalProduct.isPresent()) {
            throw new Exception("Product không được update");
        }
        Product product1 = new Product();
        product1.setProductId(product.getProductId());
        product1.setProductName(product.getProductName());
        product1.setConcentration(product.getConcentration());
        product1.setIngredients(product.getIngredients());
        product1.setRegulations(product.getRegulations());
        return productRepository.save(product1);
    }

    @Override
    public Product save(Product product) throws Exception {
        return productRepository.save(product);
    }

}
