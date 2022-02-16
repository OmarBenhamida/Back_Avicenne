package com.example.avic.services;
import com.example.avic.domaine.vo.DemandeCongeVo;
import java.util.List;
public interface IDemandeCongeService {
DemandeCongeVo getById(Long id);
List<DemandeCongeVo> getAll();
void save(DemandeCongeVo demandeConge);
void update(Long id,DemandeCongeVo demandeConge);
void delete(Long id);
}
