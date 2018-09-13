package br.com.everton.Tasklist.service;

import br.com.everton.Tasklist.model.Tarefa;
import br.com.everton.Tasklist.model.Usuario;
import br.com.everton.Tasklist.repository.TarefaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author everton
 * @since 29/08/2018
 */
@Service
public class TarefaService {
    
    @Autowired TarefaRepository repository;

    public List<Tarefa> getAll (Usuario usuario) {
        return repository.findAllByUsuario(usuario);
    }
    
    public Tarefa save (Tarefa tarefa, Usuario usuario) {
        tarefa.setUsuario(usuario);
        return repository.save(tarefa);
    }
    
    public Tarefa getById (Long id, Usuario usuario) {
        return repository.findByUsuarioAndId(usuario, id);
    }
    
    public void delete (Tarefa tarefa) {
        repository.delete(tarefa);
    }
    
}
