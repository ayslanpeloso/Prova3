package compass.regioes.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import compass.regioes.classes.Estado;

public class EstadoDto {
	
	private Long id;
	private String nome;
	private String regiao;
	private int populacao;
	private String capital;
	private int area;
	
	public EstadoDto(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
		this.regiao = estado.getRegiao();
		this.populacao = estado.getPopulacao();
		this.capital = estado.getCapital();
		this.area = estado.getArea();
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getRegiao() {
		return regiao;
	}
	public int getPopulacao() {
		return populacao;
	}
	public String getCapital() {
		return capital;
	}
	public int getArea() {
		return area;
	}

	public static Page<EstadoDto> converter(Page<Estado> estados) {
		return estados.map(EstadoDto::new);
	}

}
