package compass.regioes.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import compass.regioes.classes.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{

	Page<Estado> findByRegiao(String regiao, Pageable paginacao);

}
