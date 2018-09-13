package br.com.everton.Tasklist.repository;

import br.com.everton.Tasklist.model.Tarefa;
import br.com.everton.Tasklist.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author everton
 * @since 29/08/2018
 */
@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
    public List<Tarefa> findAllByUsuario(Usuario usuario);
    public Tarefa findByUsuarioAndId(Usuario usuario, Long id);
}
