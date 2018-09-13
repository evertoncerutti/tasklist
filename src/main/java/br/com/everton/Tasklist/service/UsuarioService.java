package br.com.everton.Tasklist.service;

import br.com.everton.Tasklist.model.Usuario;
import br.com.everton.Tasklist.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author everton
 * @since 29/08/2018
 */
@Service
public class UsuarioService {

    @Autowired private UsuarioRepository repository;
    
    public Usuario criarUsuario (Usuario usuario) {
        return repository.save(usuario);
    }
    
    public List<Usuario> listarTodosUsuarios() {
        return repository.findAll();
    }
    
    public Usuario getUsuario(String nome, String senha) {
        return repository.findByNomeAndSenha(nome, senha);
    }
}
