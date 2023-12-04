package ec.voto.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.voto.api.domain.Pais;

public interface PaisPersistence extends JpaRepository<Pais, Long> {

	Optional<Pais> findByCodigo(String codigo);
}
