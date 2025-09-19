package catalogo_filmes.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import catalogo_filmes.models.entities.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {
    
    boolean existsByCodigo(int codigo);

    Filme findByCodigo(int codigo);

    Page<Filme> findByNomeContainingIgnoringCase(String nome, Pageable pageable);
}
