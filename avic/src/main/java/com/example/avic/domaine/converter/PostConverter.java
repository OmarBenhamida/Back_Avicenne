package com.example.avic.domaine.converter;

import com.example.avic.domaine.vo.PostVo;
import com.example.avic.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostConverter {
    public static PostVo toVo(Post bo) {
        if (bo == null)
            return null;
        PostVo vo = new PostVo();
        vo.setId(bo.getId());
        vo.setLibelle(bo.getLibelle());
        vo.setService(bo.getService());
        vo.setSalairehoraire(bo.getSalairehoraire());
        return vo;
    }

    public static Post toBo(PostVo vo) {
        if (vo == null)
            return null;
        Post bo = new Post();
        bo.setId(vo.getId());
        bo.setLibelle(vo.getLibelle());
        bo.setService(vo.getService());
        bo.setSalairehoraire(vo.getSalairehoraire());
        return bo;
    }

    public static List<PostVo> toVoList(List<Post> boList) {
        if (boList == null || boList.isEmpty())
            return null;
        List<PostVo> voList = new ArrayList<>();
        for (Post post : boList) {
            voList.add(toVo(post));
        }
        return voList;
    }

    public static List<Post> toBoList(List<PostVo> voList) {
        if (voList == null || voList.isEmpty())
            return null;
        List<Post> boList = new ArrayList<>();
        for (PostVo postVo : voList) {
            boList.add(toBo(postVo));
        }
        return boList;
    }
}
