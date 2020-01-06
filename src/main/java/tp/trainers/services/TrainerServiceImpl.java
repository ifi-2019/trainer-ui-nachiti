package tp.trainers.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tp.pokemonTypes.bo.PokemonType;
import tp.pokemonTypes.services.PokemonTypeService;
import tp.trainers.bo.Pokemon;
import tp.trainers.bo.Trainer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService{

    private RestTemplate restTemplate;
    private PokemonTypeService pokemonTypeService;
    private String trainerServiceUrl;


    public List<Trainer> getAllTrainers() {
        Trainer[] listTrainers =restTemplate.getForObject(trainerServiceUrl+"/trainers/", Trainer[].class);
        List<Trainer> res=new ArrayList<>();
        Arrays.sort(listTrainers);
        return Arrays.asList(listTrainers);
    }



    @Override
    public Trainer getTrainer(String name) {
        Trainer oldTrainer =restTemplate.getForObject(trainerServiceUrl+"/trainers/{name}"+name, Trainer.class);
        Trainer newTrainer = this.addPokemons(oldTrainer);
        return newTrainer;
    }
    private Trainer addPokemons(Trainer t){
        for (Pokemon p : t.getTeam()) {
            PokemonType pokemonType =pokemonTypeService.getPokemonType(p.getPokemonType());
            p.setType(pokemonTypeService.getPokemonType(p.getPokemonType()));
        }
        return t;
    }

    @Override
    public void addTrainer(String trainerName) {
        Trainer trainer = new Trainer(trainerName);
        this.restTemplate.postForLocation(trainerServiceUrl+"/trainers/",trainer);

    }

    @Override
    public void updatePassword(String name, String newPassword) {

    }


    @Autowired
    @Qualifier("trainerApiRestTemplate")
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${trainer.service.url}")/*qua da modificare*/
    void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.trainerServiceUrl=pokemonServiceUrl;
    }

    @Autowired
    void setPokemonService(PokemonTypeService pokemonTypeService) {
        this.pokemonTypeService = pokemonTypeService;
    }


}
