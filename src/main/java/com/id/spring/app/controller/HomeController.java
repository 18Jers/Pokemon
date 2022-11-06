package com.id.spring.app.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.id.spring.app.model.Pokemon;
import com.id.spring.app.model.service.IPokemonService;

@Controller
@RequestMapping("/app")
@SessionAttributes("pokemon")
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
		model.addAttribute("pokemon", pk);		
		
		return "home";
	}
	
	@GetMapping("/listar")
	public String ListarPokemon(Model model) {
		
		model.addAttribute("titlePage", titlePage);
		model.addAttribute("titulo", "Lista de Pokemones");
		model.addAttribute("resumen", "Lista de los mejores pokemones");	
		model.addAttribute("ListaPokemon", IpService.ObtenerListaPokemon());
		model.addAttribute("respuesta", "");
		
		return "lista";
	}
	
	@GetMapping("/form")
	public String Formulario(Model model) {
		
		//String codUnico =UUID.randomUUID().toString();
		
		
		//creandoi el pokemon
		//IpService.CrearPokemon(Pokemon pokemon)
		
		Pokemon pk = new Pokemon();
		pk.setIdPokemon(123);
		pk.setNivelPoder(""+Math.random());
		
		model.addAttribute("titlePage", titlePage);
		model.addAttribute("titulo", "Formulario con Spring Boot");
				
		model.addAttribute("pokemon", pk);
		return "formulario";
	}
	
	@PostMapping("nuevoform")//o /nuevoform
	public String CrearFormulario(@Validated Pokemon pk,BindingResult result ,Model model, SessionStatus status) {
		
		if(result.hasErrors()) {
			return "formulario";		
		}
		
		
		String respuesta = IpService.CrearPokemon(pk);
		
		//IpService.CrearPokemon(Pokemon pokemon)
		
		model.addAttribute("titlePage", titlePage);
		model.addAttribute("titulo", "Lista de Pokemones");	
		model.addAttribute("resumen", "Lista de los mejores pokemones");
		model.addAttribute("ListaPokemon", IpService.ObtenerListaPokemon());				
		model.addAttribute("respuesta",respuesta);
		
		//para mostrar los errores en home.html
		//model.addAttribute("errores",result.hasErrors());
		
		return "lista";
	}
	
	@GetMapping("/Editar/{id}")
	private String editarPokemon( @PathVariable int id ,Model model) {
		
		Optional<Pokemon> pokemon = IpService.EditarPokemon(id);
						
		model.addAttribute("titlePage", titlePage);
		model.addAttribute("titulo", "Formulario con Spring Boot -  Edición");
		
		model.addAttribute("pokemon", pokemon);
				
		return "formulario";		
	}

	
}
