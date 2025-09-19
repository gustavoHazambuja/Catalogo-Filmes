package catalogo_filmes.dtos;

import catalogo_filmes.models.entities.Filme;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmeAtualizadoDTO {
    

    @NotNull(message = "A avaliação é obrigatório")
    @Max(value = 5, message = "A avaliação não pode exceder 5")
    private Double avaliacao;

    private String comentario;





    public static FilmeAtualizadoDTO fromModel(Filme filme){
        return new FilmeAtualizadoDTO(
            filme.getAvaliacao(),
            filme.getComentario()
        );
    }
}
