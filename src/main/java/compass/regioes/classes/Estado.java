package compass.regioes.classes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String regiao;
	private int populacao;
	private String capital;
	private int area;
	
	
	public Estado() {	
	}
	


	public Estado(String nome, String regiao, int populacao, String capital, int area) {
				
		if (regiao.equalsIgnoreCase("Sul") || regiao.equalsIgnoreCase("Sudeste") || regiao.equalsIgnoreCase("Centro-Oeste")
				|| regiao.equalsIgnoreCase("Norte") || regiao.equalsIgnoreCase("Nordeste")){
			this.nome = nome;
			this.regiao = regiao;
			this.populacao = populacao;
			this.capital = capital;
			this.area = area;
			} else {throw new IllegalArgumentException("Regiao Invalida");
			}}
		
	



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	
}
	



