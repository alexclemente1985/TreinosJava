package br.com.tw.alex.springmvc.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import br.com.tw.alex.springmvc.entities.Album;
import br.com.tw.alex.springmvc.repositories.AlbunsRepository;

@Controller
@RequestMapping("/albuns")
public class AlbunsController {
	
	@Autowired
	private AlbunsRepository repository;
	
	@RequestMapping(value="/listar",method=RequestMethod.GET)
	public String listar(Model model) {
		List<Album> albuns = repository.findAll();
		model.addAttribute("albuns", albuns);
		return "album.listar.tiles";
	}
	
	@RequestMapping(value = "/adicionar",method = RequestMethod.GET)
	public String adicionar(Model model) {
		model.addAttribute("album", new Album());
				
		//return "/albuns/adicionar";
		return "album.adicionar.tiles";
	}
	
	@RequestMapping(value="/adicionar", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("album") @Valid Album album,BindingResult result) {//, Model model) {
		if(result.hasErrors()) {
			//return "albuns/adicionar";
			return "album.adicionar.tiles";
		}
		//model.addAttribute("album", album);
		//return "/albuns/exibir";
		repository.save(album);
		//return "album.exibir.tiles";
		return "redirect:/albuns/listar";
	}
	
	@RequestMapping(value="/alterar/{id}", method=RequestMethod.GET)
	public String alterar(@PathVariable(value="id") Long id, Model model) {
		Optional<Album> mdfAlbum = repository.findById(id);
		model.addAttribute("album", mdfAlbum);
		return "album.alterar.tiles";
	}
	
	@RequestMapping(value="/alterar", method=RequestMethod.POST)
	public String alterar(@ModelAttribute("album") @Valid Album album, BindingResult result) {
		if(result.hasErrors()) {
			return "album.alterar.tiles";
		}
		repository.save(album);
		return "redirect:/albuns/listar";
	}
	
	@RequestMapping(value="/excluir/{id}", method=RequestMethod.GET)
	public String excluir(@PathVariable(value="id") Long id) {
		repository.deleteById(id);
		return "redirect:/albuns/listar";
	}
	
}
