package tp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }


    @PostMapping ("/registerTrainer")
     ModelAndView registerNewTrainer(@RequestParam String trainerName) {
        ModelAndView modelView = new ModelAndView("register");
        modelView.getModel().put("name",trainerName);
        return modelView;
    }
}