package com.example.avic.services;
import com.example.avic.domaine.vo.DemandeFichepaieVo;
import java.util.List;
public interface IDemandeFichepaieService {
DemandeFichepaieVo getById(Long id);
List<DemandeFichepaieVo> getAll();
void save(DemandeFichepaieVo demandeFichepaie);
void update(Long id,DemandeFichepaieVo demandeFichepaie);
void delete(Long id);
}
