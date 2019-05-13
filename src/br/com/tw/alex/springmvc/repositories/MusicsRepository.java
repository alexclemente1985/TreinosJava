package br.com.tw.alex.springmvc.repositories;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tw.alex.springmvc.entities.Music;

public interface MusicsRepository extends JpaRepository<Music, Long> {
	//Music findById(Long id);

	Music getOne(Long id);
}
