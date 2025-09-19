package catalogo_filmes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import catalogo_filmes.dtos.FilmeAtualizadoDTO;
import catalogo_filmes.dtos.FilmeDTO;
import catalogo_filmes.services.FilmeService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/filmes")
public class FilmeController {
    
    @Autowired
    private FilmeService filmeService;


    @GetMapping(value = "/verificarCodigo/{codigo}")
    public boolean verificarFilme(@PathVariable int codigo){
        return filmeService.verificaFilme(codigo);
    }


    @PostMapping(value = "/adicionarFilme")
    public ResponseEntity<FilmeDTO> adicionarFilme(@Valid @RequestBody FilmeDTO dto){

        FilmeDTO result = filmeService.adicionarFilme(dto);

        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<FilmeDTO>> listarFilmes(Pageable pageable){

        Page<FilmeDTO> result = filmeService.listarFilmes(pageable);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping(value = "/pesquisarFilme/{nome}")
    public ResponseEntity<Page<FilmeDTO>> pesquisarFilmePorNome(@PathVariable String nome, Pageable pageable){

        Page<FilmeDTO> result = filmeService.pesquisarFilmePorNome(nome, pageable);

        return new ResponseEntity<>(result,HttpStatus.FOUND);
    }

    @Transactional
    @DeleteMapping(value = "/deletarFilme/{codigo}")
    public boolean deletarFilmePorCodigo(@PathVariable int codigo){
        return filmeService.deletarFilmePorCodigo(codigo);
    }

    @PutMapping(value = "/atualizarFilme/{codigo}")
    public ResponseEntity<FilmeDTO> atualizarFilmePorCodigo(@PathVariable int codigo, @RequestBody @Valid FilmeAtualizadoDTO dto){

        FilmeDTO result = filmeService.atualizarFilmePorCodigo(codigo, dto);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
