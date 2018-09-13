package br.com.everton.Tasklist.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author everton
 * @since 28/08/2018
 */
@Entity
@Data
public class Usuario implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O nome não pode ser nulo.")
    private String nome;
    @NotNull(message = "A senha não pode ser nulo.")
    private String senha;
}
