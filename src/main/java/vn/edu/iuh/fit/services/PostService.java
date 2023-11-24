package vn.edu.iuh.fit.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.dto.PostDTO;
import vn.edu.iuh.fit.mapping.PostDTOMapping;
import vn.edu.iuh.fit.repositories.PostRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    PostRepository postRepository;
    PostDTOMapping postDTOMapping;
    public List<PostDTO> getAllDTO(Pageable pageable){
        Page<Object[]> all = postRepository.getAllDTO(pageable);
        return postDTOMapping.to(all);
    }

    public List<PostDTO> getByID(Long id){
        List<Object[]> all = postRepository.getByID(id);
        return postDTOMapping.to(all);
    }
}
