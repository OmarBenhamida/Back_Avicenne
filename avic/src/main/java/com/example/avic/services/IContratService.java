package com.example.avic.services;
import com.example.avic.domaine.vo.ContratVo;
import java.util.List;
public interface IContratService {
ContratVo getById(Long id);
List<ContratVo> getAll();
void save(ContratVo contrat);
void update(Long id,ContratVo contrat);
void delete(Long id);
}
