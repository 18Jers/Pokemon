package com.id.spring.app.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.id.spring.app.model.Pokemon;


@Component
public class PokemonService implements IPokemonService{

	@Override
	public List<Pokemon> ObtenerListaPokemon() {
		//Creando nueva instanci de un pokemon (pokemoncito)
		Pokemon pokemoncito = new Pokemon();
		Pokemon pokemoncito2 = new Pokemon();
		Pokemon pokemoncito3 = new Pokemon();
		
		List<Pokemon> listaPokemones = new ArrayList<>();
		
		pokemoncito.setNombre("Pikachu ");
		pokemoncito.setTipo("Eléctrico");
		pokemoncito.setHabilidad("Nitro carga");
		pokemoncito.setNivelPoder("500");
		
		pokemoncito2.setNombre("Raichu");
		pokemoncito2.setTipo("Eléctrico");
		pokemoncito2.setHabilidad("Bola bolteo");
		pokemoncito2.setNivelPoder("150");
		
		pokemoncito3.setNombre("Piplop");
		pokemoncito3.setTipo("Agua");
		pokemoncito3.setHabilidad("Tornado de agua");
		pokemoncito3.setNivelPoder("500");
		
		listaPokemones.add(pokemoncito);
		listaPokemones.add(pokemoncito2);
		listaPokemones.add(pokemoncito3);
		
		return listaPokemones;
		//retunr
	}
    
	@Override
	public String CrearPokemon(Pokemon pk) {
		
		//Sirve pra envio de base de datos
		
		return "Pokemon atrapado";
	}

}
