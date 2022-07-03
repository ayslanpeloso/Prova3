package compass.regioes.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import compass.regioes.classes.Estado;
import compass.regioes.controller.dto.EstadoDto;
import compass.regioes.controller.form.AtualizacaoEstadoForm;
import compass.regioes.controller.form.EstadoForm;
import compass.regioes.repository.EstadoRepository;

@RestController
@RequestMapping("/api/states")
public class EstadosController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@GetMapping
	public Page<EstadoDto> lista(@RequestParam(required = false) String regiao, 
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		
		if (regiao == null) {
			Page<Estado> estados = estadoRepository.findAll(paginacao);
			return EstadoDto.converter(estados);
		} else {
			Page<Estado> estados = estadoRepository.findByRegiao(regiao, paginacao);
			return EstadoDto.converter(estados);
			
		}
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<EstadoDto> cadastrar(@RequestBody @Valid EstadoForm form, UriComponentsBuilder uriBuilder) {
		Estado estado = form.converter();
		estadoRepository.save(estado);
		
		URI uri = uriBuilder.path("/api/states/{id}").buildAndExpand(estado.getId()).toUri();
		return ResponseEntity.created(uri).body(new EstadoDto(estado));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EstadoDto> detalhar(@PathVariable Long id) {
		Optional<Estado> estado = estadoRepository.findById(id);
		if (estado.isPresent()) {
		return ResponseEntity.ok(new EstadoDto(estado.get()));
	}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EstadoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoEstadoForm form){
		Optional<Estado> optional = estadoRepository.findById(id);
		if (optional.isPresent()) {
			Estado estado = form.atualizar(id, estadoRepository);
			return ResponseEntity.ok(new EstadoDto(estado));
	}
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional	
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Estado> optional = estadoRepository.findById(id);
		if (optional.isPresent()) {
			estadoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}

