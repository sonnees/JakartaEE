package vn.edu.iuh.fit.backend.mapping;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.backend.dto.ProductDTO;
import vn.edu.iuh.fit.backend.enums.ProductStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Component
public class ProductDTOMap {
    ProductStatusMap productStatusMap;
    public Page<ProductDTO> toProductDTOS(Page<Object[]> objects){
        return
                new PageImpl<>(objects.stream().map(o->{
                    String replace = o[8].toString().replace(" ", "T");
                    return new ProductDTO(
                            o[0].toString(),
                        Long.parseLong(o[1].toString()),
                            o[2].toString(),
                            o[3].toString(),
                            o[4].toString(),
                            productStatusMap.toProductStatus(o[5].toString()),
                            o[6].toString(),
                            Double.parseDouble( o[7].toString()),
                            LocalDateTime.parse(replace)
                    );
        }).toList());
    }
}
