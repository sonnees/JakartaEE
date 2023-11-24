package vn.edu.iuh.fit.singleton;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.dto.PostDTO;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Getter
public class PostsSingleton {
    private List<PostDTO> postDTOS;

    public void setPostDTOS(List<PostDTO> postDTOS) {
        this.postDTOS.addAll(postDTOS);
    }
    public void reSet() {
        this.postDTOS = new ArrayList<>();
    }
}
