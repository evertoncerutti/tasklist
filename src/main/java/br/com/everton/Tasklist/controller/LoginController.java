package br.com.everton.Tasklist.controller;

import br.com.everton.Tasklist.model.Usuario;
import br.com.everton.Tasklist.service.UsuarioService;
import br.com.everton.Tasklist.util.Key;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author everton
 * @since 28/08/2018
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    
    @Autowired private UsuarioService service;
    
    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("login/login");
        modelAndView.addObject("usuario", new Usuario());
        return modelAndView;
    } 
    
    @GetMapping("/novo")
    public ModelAndView novoUsuario() {
        ModelAndView modelAndView = new ModelAndView("login/novo");
        modelAndView.addObject("usuario", new Usuario());
        return modelAndView;
    } 
    
    @PostMapping("/criarusuario")
    public ModelAndView criarusuario(@Valid Usuario usuario, HttpSession session) {
        Usuario usuarioBD = service.criarUsuario(usuario);
        
        if (usuarioBD != null) {
            session.setAttribute(Key.LOGIN_SESSION, usuarioBD);
            return new ModelAndView("redirect:/");
        } else {
            System.out.println("Nao foi possível inserir usuário");
            return new ModelAndView("redirect:/login");
        }
    }  
    
    @PostMapping("/validar")
    public ModelAndView validar(@Valid Usuario usuario, HttpSession session) {
        Usuario usuarioBD = service.getUsuario(usuario.getNome(), usuario.getSenha());
        
        if (usuarioBD != null) {
            session.setAttribute(Key.LOGIN_SESSION, usuarioBD);
            return new ModelAndView("redirect:/");
        } else {
            System.out.println("Nao encontrou o usuário");
            return new ModelAndView("redirect:/login");
        }
    }  
    
    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.setAttribute(Key.LOGIN_SESSION, null);
        return new ModelAndView("redirect:/login");
    } 
}

