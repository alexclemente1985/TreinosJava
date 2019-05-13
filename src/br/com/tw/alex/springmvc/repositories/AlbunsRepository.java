package br.com.tw.alex.springmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tw.alex.springmvc.entities.Album;

public interface AlbunsRepository extends JpaRepository<Album, Long>{

	
	//Album findOne(Long id);
		
}
