package br.com.fiap.java.repository;

import br.com.fiap.java.model.Pacientes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacientesRepository extends CrudRepository <Pacientes, Integer> {

}
