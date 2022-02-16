package com.example.avic.services.implementations;
import com.example.avic.dao.PostRepository;
import com.example.avic.domaine.converter.PostConverter;
import com.example.avic.domaine.vo.PostVo;
import com.example.avic.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.example.avic.model.Post;
@Service("postService")
public class PostServiceImpl implements IPostService {
@Autowired
private PostRepository postRepository;
@Override
public PostVo getById(Long id){
boolean trouve =postRepository.existsById(id);
if (!trouve)
return null;
return PostConverter.toVo(postRepository.getById(id));
}
@Override
public List<PostVo> getAll(){
List<Post> list = postRepository.findAll();
return PostConverter.toVoList(list);
}
@Override
public void save(PostVo post){
postRepository.save(PostConverter.toBo(post));
}
@Override
public void update(Long id,PostVo post){
post.setId(id);
postRepository.save(PostConverter.toBo(post));
}
@Override
public void delete(Long id){
postRepository.deleteById(id);
}

    @Override
    public List<PostVo> findByLibelle(String libelle) {
        List<Post> list = postRepository.findByLibelle(libelle);
        return PostConverter.toVoList(list);
    }
}
