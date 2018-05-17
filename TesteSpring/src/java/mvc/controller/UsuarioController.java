package mvc.controller;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import mvc.bean.Usuario;
import mvc.dao.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author Raymison
 */
@Controller
public class UsuarioController {
    private final UsuarioDAO dao;
    
    @Autowired
    public UsuarioController(UsuarioDAO dao){
        this.dao = dao;
    }
    
    @RequestMapping("/formAdcUsuario")
    public String form(){
        return "usuario/adcUsuario";
    }
    
    @RequestMapping("/adcUsuario")
    public String adiciona(@Valid Usuario usuario){
        dao.adcUsuario(usuario);
        
        return "usuario/usuario-adicionado";
    }

    @RequestMapping("/listaUsuarios")
    public String lista(Model model){
        model.addAttribute("listaUsuarios", dao.listarUsuarios());
        return "usuario/listagem-usuarios";
    }
    
    @RequestMapping("/removeUsuario")
    public String remove(int id){
        dao.removerUsuario(id);
        return "redirect:/listaUsuarios";
    }
    
    @RequestMapping("/exibeUsuario")
    public String exibe(int id, Model model) throws SQLException{
       
        model.addAttribute("usuario", dao.buscarUsuarioPorId(id));
        
        return "usuario/exibe-usuario";
    }
    
    @RequestMapping("/alteraUsuario")
    public String altera(@Valid Usuario usuario, BindingResult result){
        dao.alterarUsuario(usuario);
        return "redirect:/listaUsuarios";
    }
}
