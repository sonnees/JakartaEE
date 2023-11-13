package vn.edu.iuh.fit.backend.mapping;

import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.backend.dto.Statistic2Field;
import vn.edu.iuh.fit.backend.dto.Statistic2Field_Money;

import java.util.List;

@AllArgsConstructor
@Component
public class Statistic2Field_MoneyMap {
    public List<Statistic2Field_Money> to(List<Object[]> objects){
        return objects.stream().map(i->{
            return new Statistic2Field_Money(
                    i[0].toString(),
                    Long.parseLong(Math.round(Double.parseDouble(i[1].toString()))+"")
            );
        }).toList();
    }
}
