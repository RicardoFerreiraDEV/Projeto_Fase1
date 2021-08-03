package br.com.fiap.java.repository;

import br.com.fiap.java.model.Vacinas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacinasRepository extends CrudRepository<Vacinas, Integer> {
}
