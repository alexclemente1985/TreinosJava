package br.com.tw.alex.springmvc.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import br.com.tw.alex.springmvc.entities.Album;

@Controller
@RequestMapping("/albuns")
public class AlbunsController {
	
	@RequestMapping(value = "/adicionar",method = RequestMethod.GET)
	public String adicionar(Model model) {
		model.addAttribute("album", new Album());
				
		//return "/albuns/adicionar";
		return "album.adicionar.tiles";
	}
	
	@RequestMapping(value="/adicionar", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("album") @Valid Album album,BindingResult result, Model model) {
		if(result.hasErrors()) {
			//return "albuns/adicionar";
			return "album.adicionar.tiles";
		}
		model.addAttribute("album", album);
		//return "/albuns/exibir";
		return "album.exibir.tiles";
	}
}
