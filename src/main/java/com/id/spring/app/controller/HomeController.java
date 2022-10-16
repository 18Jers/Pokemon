package com.id.spring.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.id.spring.app.model.Pokemon;
import com.id.spring.app.model.service.IPokemonService;

@Controller
@RequestMapping("/app")
public class HomeController {
	
	@Value("${titlePage.param}")
	private String titlePage;
	
		
	@Autowired 
	private IPokemonService IpService;
		
	@GetMapping("/home")
	public String Home(Model model) {
		
		model.addAttribute("titlePage", titlePage);
		model.addAttribute("titulo", "Iniciando con Spring Boot");
		model.addAttribute("ListaPokemon", IpService.ObtenerListaPokemon());
				
		return "home";
	}
	
	@GetMapping("/form")
	public String Formulario(Model model) {
		
		//creandoi el pokemon
		//IpService.CrearPokemon(Pokemon pokemon)
		
		model.addAttribute("titlePage", titlePage);
		model.addAttribute("titulo", "Formulario con Spring Boot");
				
		return "formulario";
	}
	
	@PostMapping("/nuevoform")
	public String CrearFormulario(Model model, Pokemon pk) {
		
		List<Pokemon>pokemonX= new ArrayList<>();
		pokemonX.add(pk);
		String respuesta = IpService.CrearPokemon(pk);
		
		//IpService.CrearPokemon(Pokemon pokemon)
		
		model.addAttribute("titlePage", titlePage);
		model.addAttribute("titulo", "Formulario con Spring Boot");
		model.addAttribute("ListaPokemon",pokemonX);
				
		model.addAttribute("respuesta",respuesta);
		
		return "home";
	}

}
