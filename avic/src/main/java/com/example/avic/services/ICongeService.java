package com.example.avic.services;
import com.example.avic.domaine.vo.CongeVo;
import java.util.List;
public interface ICongeService {
CongeVo getById(Long id);
List<CongeVo> getAll();
void save(CongeVo conge);
void update(Long id,CongeVo conge);
void delete(Long id);
}
