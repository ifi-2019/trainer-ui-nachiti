package tp.pokemonTypes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tp.pokemonTypes.bo.PokemonType;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    RestTemplate restTemplate ;
    String pokemonServiceUrl;

    @Cacheable("pokemon-types")
    public List<PokemonType> listPokemonsTypes() {

        PokemonType[] result=restTemplate.getForObject(this.pokemonServiceUrl+"/pokemon-types/",PokemonType[].class);
        return Arrays.asList(result) ;
    }

    @Cacheable("pokemon-types")
    public PokemonType getPokemonType(int id){
        PokemonType result=restTemplate.getForObject(
                this.pokemonServiceUrl+"/{id}",PokemonType.class,id
        );
        return result;

    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate=restTemplate;
    }

    public String getPokemonTypeServiceUrl() {
        return pokemonServiceUrl;
    }

    @Value("${pokemonType.service.url}")
    public void setPokemonTypeServiceUrl(String pokemonServiceUrl){
        this.pokemonServiceUrl=pokemonServiceUrl;

    }


}