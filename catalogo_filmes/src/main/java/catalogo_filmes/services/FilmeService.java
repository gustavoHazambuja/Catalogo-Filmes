package catalogo_filmes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import catalogo_filmes.dtos.FilmeAtualizadoDTO;
import catalogo_filmes.dtos.FilmeDTO;
import catalogo_filmes.models.entities.Filme;
import catalogo_filmes.repositories.FilmeRepository;

@Service
public class FilmeService {
    
    @Autowired
    private FilmeRepository filmeRepository;


    public boolean verificaFilme(int codigo){
        return filmeRepository.existsByCodigo(codigo);
    }

    public FilmeDTO adicionarFilme(FilmeDTO dto){
        Filme filme = toModel(dto);
        Filme result = filmeRepository.save(filme);
        return FilmeDTO.fromModel(result);
    }

    public Page<FilmeDTO> listarFilmes(Pageable pageable){
        return filmeRepository.findAll(pageable)
            .map(FilmeDTO::fromModel);
    }

    public Page<FilmeDTO> pesquisarFilmePorNome(String nome, Pageable pageable){
        return filmeRepository.findByNomeContainingIgnoringCase(nome, pageable)
            .map(FilmeDTO::fromModel);
    }

    public boolean deletarFilmePorCodigo(int codigo){
        if(!filmeRepository.existsByCodigo(codigo)){
            return false;
        }

        filmeRepository.deleteById(codigo);
        return true;
    }

    public FilmeDTO atualizarFilmePorCodigo(int codigo, FilmeAtualizadoDTO dto){
        Filme filmeEncontrado = filmeRepository.findByCodigo(codigo);
         if(filmeEncontrado == null) {
            throw new RuntimeException("Filme não encontrado com código: " + codigo);
        }

       filmeEncontrado.setAvaliacao(dto.getAvaliacao());
       filmeEncontrado.setComentario(dto.getComentario());

       Filme atualizado = filmeRepository.save(filmeEncontrado);
       return FilmeDTO.fromModel(atualizado);
       
    }




    private Filme toModel(FilmeDTO dto){
        return new Filme(
            dto.getCodigo(),
            dto.getNome(),
            dto.getAno(),
            dto.getGenero(),
            dto.getAvaliacao(),
            dto.getComentario()
        );
    }
}
