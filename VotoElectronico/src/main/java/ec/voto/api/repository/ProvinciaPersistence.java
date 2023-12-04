package ec.voto.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.voto.api.domain.Provincia;

public interface ProvinciaPersistence extends JpaRepository<Provincia, Long> {

}
