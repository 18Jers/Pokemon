package com.id.spring.app.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.id.spring.app.interfaces.IPokemon;
import com.id.spring.app.model.Pokemon;


@Component
public class PokemonService implements IPokemonService{

	@Autowired
	private IPokemon pokemonRepository;
	
	@Override
	public List<Pokemon> ObtenerListaPokemon() {
		return (List<Pokemon>)pokemonRepository.findAll();
	}
    
	@Override
	public String CrearPokemon(Pokemon pk) {
		String estado = "No guardado"; 
		Pokemon p =  new Pokemon();		
		p = pokemonRepository.save(pk);
		
		if (p.getIdPokemon()>0) {
			estado = "Guardado Correctamente";
		}		
		return estado;
	}
	
	@Override
	public Optional<Pokemon> EditarPokemon(Integer id) {		
		Optional<Pokemon> p = Optional.empty();		
		p = pokemonRepository.findById(id);		
		return p;
	}

}
