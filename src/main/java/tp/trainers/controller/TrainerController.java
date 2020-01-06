package tp.trainers.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.context.SecurityContextHolder;
import tp.pokemonTypes.services.PokemonTypeService;
import org.springframework.security.core.userdetails.User;
import tp.trainers.bo.Trainer;
import tp.trainers.services.TrainerService;

import java.util.List;

@Controller
public class TrainerController {

    TrainerService trainerService;

    @Autowired/*mise*/
    private PokemonTypeService pokemonTypeService;

    @GetMapping(value = "/trainers")
    public ModelAndView trainers(){
        ModelAndView modelAndView=new ModelAndView("trainers");

        modelAndView.addObject("allTrainers",trainerService.getAllTrainers());
        return modelAndView;
    }

    @GetMapping("/trainers/{name}")
    public ModelAndView trainers(@PathVariable String name){

        ModelAndView modelAndView=new ModelAndView("trainer");

        modelAndView.addObject("trainer",trainerService.getTrainer(name));
        return modelAndView;
    }

    @GetMapping("/profile")
    ModelAndView profile(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        var modelAndView = new ModelAndView("profile");
        modelAndView.addObject("trainer", trainerService.getTrainer(user.getUsername()));
        return modelAndView;
    }



    @Autowired
    public void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }
}
