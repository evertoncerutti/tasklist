package br.com.everton.Tasklist.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author everton
 * @since 28/08/2018
 */
@Data
@Entity
public class Tarefa implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Enumerated(EnumType.STRING)
    private Status status = Status.NOVO;
    
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "idUsuario", nullable = false)
    private Usuario usuario;
    
    public static enum Status {
        NOVO,
        FAZENDO,
        CONCLUIDO
    }
}
