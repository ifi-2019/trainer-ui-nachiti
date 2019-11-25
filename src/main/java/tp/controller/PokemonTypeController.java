package tp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import tp.pokemonTypes.bo.PokemonType;
import tp.pokemonTypes.services.PokemonTypeService;

import java.util.List;

@Controller
public class PokemonTypeController {
    PokemonTypeService pokemonTypeService;

    @GetMapping("/pokedex")
    public ModelAndView pokedex(){
        List<PokemonType> pokemons = pokemonTypeService.listPokemonsTypes();

        ModelAndView modelAndView = new ModelAndView("pokedex");
        modelAndView.getModel().put("pokemonTypes",pokemons);
        return modelAndView;
    }

    @Autowired
    public void setPokemonTypeService(PokemonTypeService pokemonTypeService){
        this.pokemonTypeService=pokemonTypeService;
    }

}