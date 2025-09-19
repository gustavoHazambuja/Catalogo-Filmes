package catalogo_filmes.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    
    private String nome;
    private Integer ano;
    private String genero;
    private Double avaliacao;
    private String comentario;
}
