package br.com.everton.Tasklist.controller;

import br.com.everton.Tasklist.model.Tarefa;
import br.com.everton.Tasklist.service.TarefaService;
import br.com.everton.Tasklist.util.Util;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author everton
 * @since 28/08/2018
 */
@Controller
@RequestMapping({"/", "/tarefa"})
public class IndexController {
   
    @Autowired TarefaService service;
    
    
    @GetMapping
    public ModelAndView home(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("tarefa/index");
        modelAndView.addObject("tarefa", service.getAll(Util.getUsuarioBySession(session)));
        return modelAndView;
    } 
    
    
    @GetMapping("/novo")
    public ModelAndView novo() {
        ModelAndView modelAndView = new ModelAndView("tarefa/form");
        modelAndView.addObject("tarefa", new Tarefa());
        return modelAndView;
    }
    
    @PostMapping("/gravar")
    public ModelAndView gravar(Tarefa tarefa, HttpSession session) {
        service.save(tarefa, Util.getUsuarioBySession(session));
        return new ModelAndView("redirect:/tarefa");
    }  
    
    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable Long id, HttpSession session) {
        Tarefa tarefaAlterar = service.getById(id, Util.getUsuarioBySession(session));
        
        if (tarefaAlterar != null) {
            ModelAndView modelAndView = new ModelAndView("tarefa/form");
            modelAndView.addObject("tarefa", tarefaAlterar);
            return modelAndView;
        } else {
            return new ModelAndView("redirect:/tarefa/novo");
        }
    }
    
    @PostMapping("/excluir")
    public ModelAndView excluir(Long id, HttpSession session) {
        Tarefa tarefa = service.getById(id, Util.getUsuarioBySession(session));

        if (tarefa != null) {
            service.delete(tarefa);
        }
        
        return new ModelAndView("redirect:/tarefa");
    }
}

