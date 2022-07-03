package compass.regioes.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import compass.regioes.classes.Estado;
import compass.regioes.repository.EstadoRepository;

public class AtualizacaoEstadoForm {
	
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String regiao;
	
	@NotNull
	private int populacao;
	
	@NotNull @NotEmpty
	private String capital;
	
	@NotNull
	private int area;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public int getPopulacao() {
		return populacao;
	}

	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public Estado atualizar(Long id, EstadoRepository estadoRepository) {
		Estado estado = estadoRepository.getOne(id);
		
		if (regiao.equalsIgnoreCase("Sul") || regiao.equalsIgnoreCase("Sudeste") || regiao.equalsIgnoreCase("Centro-Oeste")
			|| regiao.equalsIgnoreCase("Norte") || regiao.equalsIgnoreCase("Nordeste")){
		estado.setNome(this.nome);
		estado.setRegiao(this.regiao);
		estado.setPopulacao(this.populacao);
		estado.setCapital(this.capital);
		estado.setArea(this.area);
		} else {throw new IllegalArgumentException("Regiao Invalida");
		}
		
		
		return estado;
	}
	
}
