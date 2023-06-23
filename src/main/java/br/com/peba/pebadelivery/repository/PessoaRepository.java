package br.com.peba.pebadelivery.repository;

import br.com.peba.pebadelivery.domain.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {

}
