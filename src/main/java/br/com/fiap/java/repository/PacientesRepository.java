package br.com.fiap.java.repository;

import br.com.fiap.java.model.Pacientes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacientesRepository extends PagingAndSortingRepository<Pacientes, Integer> {
    List<Pacientes> findAllByNome(String nome);
}
