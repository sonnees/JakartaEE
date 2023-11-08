package vn.edu.iuh.fit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import vn.edu.iuh.fit.backend.dto.ProductDTO;
import vn.edu.iuh.fit.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.backend.services.ProductService;

@SpringBootTest
public class TestProductService {
    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;

    @Test
    void getProduct(){
        Pageable pageable = PageRequest.of(0, 10, Sort.by("name"));
        Page<ProductDTO> product = productService.getProduct(pageable);
        product.forEach(i-> System.out.println(i.getName()));
        Assertions.assertNotNull(product);
    }

    @Test
    void more(){
        int size = productRepository.findAll().size()%10==0?productRepository.findAll().size()/10:productRepository.findAll().size()/10+1;
        System.out.println(size);
    }
}
