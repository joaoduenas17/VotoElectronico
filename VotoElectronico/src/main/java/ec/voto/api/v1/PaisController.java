package ec.voto.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.voto.api.dto.ApiResponseDTO;
import ec.voto.api.dto.PaisDTO;
import ec.voto.api.service.PaisService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = { "/api/v1.0/pais" })
public class PaisController {

	@Autowired
	PaisService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listar() {
		List<PaisDTO> list = service.findAll(new PaisDTO());
		ApiResponseDTO<List<PaisDTO>> response = new ApiResponseDTO<>(true, list);
		return (new ResponseEntity<Object>(response, HttpStatus.OK));
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> guardar(@RequestBody PaisDTO PaisDTO) {
		PaisDTO PaisDTOResult = service.save(PaisDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, PaisDTOResult), HttpStatus.CREATED);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody PaisDTO PaisDTO) {
		PaisDTO resultDTO = service.update(PaisDTO);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, resultDTO), HttpStatus.CREATED);
	}

	@GetMapping(value = "{codigo}/archivo/codigo", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorCodigo(@Valid @PathVariable("codigo") String codigo) {
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.buscarPorCodigo(codigo)), HttpStatus.OK);
	}

	@GetMapping(value = "{id}/archivo/id", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") long id) {
		PaisDTO dto = new PaisDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.find(dto)), HttpStatus.OK);
	}

}
