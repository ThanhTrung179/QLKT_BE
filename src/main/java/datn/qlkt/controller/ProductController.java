package datn.qlkt.controller;

import datn.qlkt.dto.dtos.ProductFilter;
import datn.qlkt.dto.dtos.UserFilter;
import datn.qlkt.dto.request.ProductForm;
import datn.qlkt.entities.ErrorCode;
import datn.qlkt.entities.MyResponse;
import datn.qlkt.model.Producer;
import datn.qlkt.model.Product;
import datn.qlkt.model.Product_producer;
import datn.qlkt.repository.ProducerRespository;
import datn.qlkt.service.Impl.ProducerServiceImpl;
import datn.qlkt.service.Impl.ProductServiceImpl;
import datn.qlkt.service.ProducerService;
import datn.qlkt.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Log4j2
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    @Autowired
    ProducerServiceImpl producerService;

    @Autowired
    ProducerRespository producerRespository;


    @GetMapping("/search")
    public MyResponse<?> searchProduct(ProductFilter productFilter) throws Exception {
        var page = productService.searchProduct(productFilter);
        return MyResponse.response(page);
    }

    @PostMapping("/save")
    public MyResponse<?> saveProduct(@Valid @RequestBody ProductForm productform) throws Exception {
        try {
            Product product = new Product(productform.getProduct_id(),productform.getProduct_name(), productform.getConcentration(), productform.getIngredients(), productform.getRegulations());
            Set<Producer> producers = new HashSet<>();
            Producer producer = producerService.findByName(productform.getProducer()).orElseThrow(
                    ()-> new RuntimeException("Không tìm được NCC"));
            producers.add(producer);
            product.setProducers(producers);
            productService.save(product);
            return MyResponse.response(ErrorCode.CREATED_OK.getCode(), ErrorCode.CREATED_OK.getMsgError());
        }
        catch (Exception ex) {
            log.info(ex);
            return MyResponse.response(ErrorCode.CREATED_FAIL.getCode(), ErrorCode.CREATED_FAIL.getMsgError());
        }
    }

    @PutMapping("/update/{id}")
    public MyResponse<?> updateProduct(@RequestBody Product product, Long id) throws Exception {
        try {
            productService.updateProduct(product, id);
            return MyResponse.response(ErrorCode.UPDATED_OK.getCode(), ErrorCode.UPDATED_OK.getMsgError());
        }catch (Exception ex) {
            return MyResponse.response(ErrorCode.UPDATED_FAIL.getCode(),ErrorCode.UPDATED_FAIL.getMsgError());

        }
    }
}
