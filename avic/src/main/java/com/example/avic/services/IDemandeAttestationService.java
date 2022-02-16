package com.example.avic.services;
import com.example.avic.domaine.vo.DemandeAttestationVo;
import java.util.List;
public interface IDemandeAttestationService {
DemandeAttestationVo getById(Long id);
List<DemandeAttestationVo> getAll();
void save(DemandeAttestationVo demandeAttestation);
void update(Long id,DemandeAttestationVo demandeAttestation);
void delete(Long id);
}
