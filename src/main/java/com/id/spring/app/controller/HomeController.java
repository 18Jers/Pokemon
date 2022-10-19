package com.id.spring.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

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
		
		Pokemon pk = new Pokemon();
		model.addAttribute("titlePage", titlePage);
		model.addAttribute("titulo", "Iniciando con Spring Boot");
		model.addAttribute("ListaPokemon", IpService.ObtenerListaPokemon());
		model.addAttribute("pokemon", pk);		
		
		return "home";
	}
	
	@GetMapping("/form")
	public String Formulario(Model model) {
		
		//creandoi el pokemon
		//IpService.CrearPokemon(Pokemon pokemon)
		
		Pokemon pk = new Pokemon();
		model.addAttribute("titlePage", titlePage);
		model.addAttribute("titulo", "Formulario con Spring Boot");
				
		model.addAttribute("pokemon", pk);
		return "formulario";
	}
	
	@PostMapping("nuevoform")//o /nuevoform
	public String CrearFormulario(@Validated Pokemon pk,BindingResult result ,Model model) {
		
		if(result.hasErrors()) {
			return "formulario";		
		}
		
		
		String respuesta = IpService.CrearPokemon(pk);
		
		//IpService.CrearPokemon(Pokemon pokemon)
		
		model.addAttribute("titlePage", titlePage);
		model.addAttribute("titulo", "Formulario con Spring Boot");
		model.addAttribute("pokemon",pk);				
		model.addAttribute("respuesta",respuesta);
		
		//para mostrar los errores en home.html
		//model.addAttribute("errores",result.hasErrors());
		
		return "home";
	}
	
}
