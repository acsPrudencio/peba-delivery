package br.com.pebas.pebasdelivery.repository;

import br.com.pebas.pebasdelivery.domain.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {

}
