package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author Raymison
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){
    return "index";
    }
    @RequestMapping("/welcome")
    public ModelAndView wellcome(){
        String viewName = "welcome";
        String var = "message";
        String content = "BEM VINDO AO MULTVERSO SPRING";
        return new ModelAndView(viewName,var,content);
    }
    
    
}
