package tp.pokemonTypes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tp.pokemonTypes.bo.PokemonType;
import tp.trainers.bo.Trainer;
import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    RestTemplate restTemplate ;
    String pokemonServiceUrl;

    public List<PokemonType> listPokemonsTypes() {

        PokemonType[] resultat= restTemplate.getForObject(pokemonServiceUrl+"/pokemon-types/", PokemonType[].class);
        if(resultat==null)
        {
         System.out.println(("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"));
        }
        List<PokemonType> list=new ArrayList<>();
        for( PokemonType pokemonType : resultat){
            list.add(pokemonType);
        }
        return list;

    }



    @Override
    public PokemonType getPokemonType(String id){
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