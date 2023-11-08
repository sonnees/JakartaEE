package vn.edu.iuh.fit.backend.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.dto.ProductDTO;
import vn.edu.iuh.fit.backend.mapping.ProductDTOMap;
import vn.edu.iuh.fit.backend.repositories.ProductRepository;

@Service
@AllArgsConstructor
public class ProductService {
    ProductRepository productRepository;
    ProductDTOMap productDTOMap;
    public Page<ProductDTO> getProduct(Pageable pageable){
        Page<Object[]> products = productRepository.getProduct(pageable);
        return productDTOMap.toProductDTOS(products);
    }
}
