package tp.pokemonTypes.services;

import tp.pokemonTypes.bo.PokemonType;
import tp.trainers.bo.Trainer;

import java.util.List;

public interface PokemonTypeService {

    List<PokemonType> listPokemonsTypes();
    PokemonType getPokemonType(String id);


}
