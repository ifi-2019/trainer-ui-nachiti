package tp.trainers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import tp.pokemonTypes.bo.PokemonType;
import tp.pokemonTypes.services.PokemonTypeService;
import tp.trainers.bo.Trainer;
import tp.trainers.services.TrainerService;

import java.security.Principal;
import java.util.List;

@Controller
public class ProfileController {
    PokemonTypeService pokemonTypeService;
    TrainerService trainerService;


    @GetMapping(value = "/UpdatePsw")
    public ModelAndView updatePassword(){
        ModelAndView modelAndView=new ModelAndView("updatePsw");
        return modelAndView;
    }

    @PostMapping(value = "/UpdatePassword")
    public String updatePasswordPost(Principal principal, @PathVariable String oldPassword, @PathVariable String newPassword, @PathVariable String confirmPassword){
        trainerService.updatePassword(principal.getName(),newPassword);
        return "redirect:/profile";
    }
    @Autowired
    public void setPokemonTypeService(PokemonTypeService pokemonTypeService) {
        this.pokemonTypeService=pokemonTypeService;
    }

    @Autowired
    public void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }
    }