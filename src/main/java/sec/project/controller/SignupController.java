package sec.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Signup;
import sec.project.repository.SignupRepository;

@Controller
public class SignupController {

    @Autowired
    private SignupRepository signupRepository;    

    @RequestMapping("*")
    public String defaultMapping() {
        return "redirect:/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String loadForm() {
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@RequestParam String name, @RequestParam String address) {
        signupRepository.save(new Signup(0, name, address));
        return "done";
    }
    
    @RequestMapping(value = "/signups", method = RequestMethod.GET)
    public String signups(Model model) {
        model.addAttribute("signups", signupRepository.getAll());
        return "signups";
    }
    
    @RequestMapping(value = "/signups/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        signupRepository.delete(id);
        return "redirect:/signups";
    }
    
    @RequestMapping(value = "/signups/{id}", method = RequestMethod.GET)
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("signup", signupRepository.findById(id));
        return "signup";
    }
    
}
