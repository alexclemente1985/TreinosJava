package br.com.treinaweb.springboot.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.treinaweb.springboot.entidades.Instituicao;
import java.util.List;

public interface RepositorioInstituicao extends JpaRepository<Instituicao, Long>{
	
	List<Instituicao> findByNomeContaining(String nome);
	
}
