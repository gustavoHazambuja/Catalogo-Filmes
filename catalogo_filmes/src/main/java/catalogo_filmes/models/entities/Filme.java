package catalogo_filmes.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_filme")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Filme {
    
    private Integer codigo;
    private String nome;
    private Integer ano;
    private String genero;
    private Double avaliacao;
    private String comentario;
}
