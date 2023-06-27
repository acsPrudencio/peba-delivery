package br.com.pebas.pebasdelivery.repository;

import br.com.pebas.pebasdelivery.domain.dto.PessoaDto;
import br.com.pebas.pebasdelivery.domain.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
    @Query("select p from Pessoa p order by p.createdAt")
    List<Pessoa> findByOrderByCreatedAtAsc();


    @Override
    void deleteById(UUID uuid);
}
