package ec.voto.api.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import ec.voto.api.domain.Candidato;

public interface CandidatoPersistence extends JpaRepository<Candidato, Long> {



}
