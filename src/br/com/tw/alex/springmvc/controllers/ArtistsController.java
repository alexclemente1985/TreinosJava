package br.com.tw.alex.springmvc.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tw.alex.springmvc.entities.Artista;

@Controller
@RequestMapping("/artists")
public class ArtistsController {
	@RequestMapping(value="/adicionar", method=RequestMethod.GET)
	public String adicionar(Model model) {
		model.addAttribute("artist", new Artista());
		return "/artists/adicionar";
	}
	
	@RequestMapping(value="/adicionar", method=RequestMethod.POST)
	public String adicionar(@ModelAttribute("artist") @Valid Artista artist,BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "/artists/adicionar";
		}
		model.addAttribute("artist",artist);
		return "/artists/exibir";
	}
}
