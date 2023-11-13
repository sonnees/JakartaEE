package vn.edu.iuh.fit.backend.mapping;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.backend.dto.Statistic2Field;

import java.util.List;

@AllArgsConstructor
@Component
public class Statistic2FieldMap {
    public List<Statistic2Field> to(List<Object[]> objects){
        return objects.stream().map(i->{
            return new Statistic2Field(
                    i[0].toString(),
                    Integer.parseInt(i[1].toString())
            );
        }).toList();
    }
}
