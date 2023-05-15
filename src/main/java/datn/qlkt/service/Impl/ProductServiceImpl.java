package datn.qlkt.service.Impl;

import datn.qlkt.dto.dtos.ProductFilter;
import datn.qlkt.dto.dtos.UserFilter;
import datn.qlkt.dto.request.ProductForm;
import datn.qlkt.model.Producer;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProducerServiceImpl producerService;
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Page<?> searchProduct(ProductFilter productFilter) throws Exception {
        log.info("--------- search product  -----------");
        Pageable pageable = PageRequest.of(productFilter.page(), productFilter.size());
        var result = productRepository.getAllProductList(pageable, productFilter.productId(), productFilter.productName(), productFilter.producers());
        return result;
    }

    @Override
    public Product updateProduct(ProductForm productForm, Long id) throws Exception {
        log.info("--------update user---------");
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(!optionalProduct.isPresent()) {
            throw new Exception("Product không được update");
        }
        Product product1 = optionalProduct.get();
        product1.setProductId(productForm.getProductId());
        product1.setProductName(productForm.getProductName());
        product1.setConcentration(productForm.getConcentration());
        product1.setIngredients(productForm.getIngredients());
        product1.setRegulations(productForm.getRegulations());
        Set<Producer> producers = new HashSet<>();
        Producer producer = producerService.findByName(productForm.getProducer()).orElseThrow(
                ()-> new RuntimeException("Không tìm được NCC"));
        producers.add(producer);
        product1.setProducers(producers);
        return productRepository.save(product1);
    }

    @Override
    public Product save(Product product) throws Exception {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);


        product.setIsActive(1);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) throws Exception {
        var count = productRepository.countProductWareHouse(id);
        if(count > 0) {
            throw new Exception("Đã tồn tại trong kho");
        }else {
            productRepository.deleteById(id);
        }
    }

}
