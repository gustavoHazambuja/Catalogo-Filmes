package catalogo_filmes.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import catalogo_filmes.models.entities.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {
    
    boolean existsCodigo(int codigo);

    Page<Filme> listarFilmes(Pageable pageable);

    Page<Filme> findByNomeIgnoringCase(String nome, Pageable pageable);
}
