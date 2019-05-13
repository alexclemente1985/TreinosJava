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

import br.com.tw.alex.springmvc.entities.Music;
import br.com.tw.alex.springmvc.repositories.AlbunsRepository;
import br.com.tw.alex.springmvc.repositories.MusicsRepository;

@Controller
@RequestMapping("/musics")
public class MusicsController {
	@Autowired
	private AlbunsRepository albunsRepo;
	@Autowired
	private MusicsRepository musicsRepo;
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(Model model) {
		List<Music> musics = musicsRepo.findAll();
		model.addAttribute("musics",musics);
		return "musics.listar.tiles";
	}
	
	@RequestMapping(value="/adicionar", method=RequestMethod.GET)
	public String adicionar(Model model) {
		model.addAttribute("music",new Music());
		model.addAttribute("albuns", albunsRepo.findAll());
		return "musics.adicionar.tiles";
	}
	
	@RequestMapping(value="/adicionar", method=RequestMethod.POST)
	public String adicionar(@ModelAttribute("music") @Valid Music newMusic, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("albuns", albunsRepo.findAll());
			return "musics.adicionar.tiles";
		}
		musicsRepo.save(newMusic);
		return "redirect:/musics/listar";
	}
	
	@RequestMapping(value= "/alterar/{id}", method=RequestMethod.GET)
	public String alterar(@PathVariable("id") Long id,Model model) {
		Optional<Music> mdfMusic = musicsRepo.findById(id);
		model.addAttribute("music",mdfMusic);
		model.addAttribute("albuns",albunsRepo.findAll());
		return "musics.alterar.tiles";
	}
	
	@RequestMapping(value="/alterar", method=RequestMethod.POST)
	public String alterar(@ModelAttribute("music") @Valid Music mdfMusic, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("albuns", albunsRepo.findAll());
			return "musics.alterar.tiles";
		}
		musicsRepo.save(mdfMusic);
		return "redirect:/musics/listar";
	}
	
	@RequestMapping(value="/excluir/{id}", method = RequestMethod.GET)
	public String excluir(@PathVariable("id") Long id) {
		
		//remoção da referência à album
		//Music music = musicsRepo.getOne(id);
		//music.setAlbum(null);
		musicsRepo.deleteById(id);
		return "redirect:/musics/listar";
	}
}
