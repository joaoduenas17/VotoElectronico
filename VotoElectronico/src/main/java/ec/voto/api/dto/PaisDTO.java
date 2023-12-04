package ec.voto.api.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class PaisDTO {

	private Long id;

	private String codigo;

	private String nombre;

	private String gentilicio;

}
