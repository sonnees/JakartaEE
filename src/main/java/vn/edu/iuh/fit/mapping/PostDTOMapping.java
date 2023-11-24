package vn.edu.iuh.fit.mapping;

import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.dto.PostDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
public class PostDTOMapping {

    public List<PostDTO> to(Page<Object[]> objects ){
        return objects.stream().map(
                        o->{
                            return new PostDTO(
                                    Long.parseLong(o[0].toString()),
                                    o[1].toString(),
                                    o[2].toString(),
                                    LocalDate.parse(o[3].toString()),
                                    Long.parseLong(o[4].toString()),
                                    o[5].toString()
                            );
                        }

        ).toList();
    }

    public List<PostDTO> to(List<Object[]> objects ){
        return objects.stream().map(
                o->{
                    return new PostDTO(
                            Long.parseLong(o[0].toString()),
                            o[1].toString(),
                            o[2].toString(),
                            LocalDate.parse(o[3].toString()),
                            Long.parseLong(o[4].toString()),
                            o[5].toString()
                    );
                }

        ).toList();
    }


}
