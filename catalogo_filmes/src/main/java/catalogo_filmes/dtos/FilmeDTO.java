package catalogo_filmes.dtos;

import catalogo_filmes.models.entities.Filme;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmeDTO {
    
    private Integer codigo;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotNull(message = "O ano é obrigatório")
    private Integer ano;

    @NotBlank(message = "O gênero é obrigatório")
    private String genero;

    @NotNull(message = "A avaliação é obrigatório")
    @Max(value = 5, message = "A avaliação não pode exceder 5")
    private Double avaliacao;

    @Size(min = 0, max = 50, message = "O comentário não pode exceder 50 caracteres")
    private String comentario;


    public static FilmeDTO fromModel(Filme filme){
        return new FilmeDTO(
            filme.getCodigo(),
            filme.getNome(),
            filme.getAno(),
            filme.getGenero(),
            filme.getAvaliacao(),
            filme.getComentario()
        );
    }
}
