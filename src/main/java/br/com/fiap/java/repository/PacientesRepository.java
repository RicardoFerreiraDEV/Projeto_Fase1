package br.com.fiap.java.repository;

import br.com.fiap.java.model.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacientesRepository extends JpaRepository<Pacientes, Long> {
    // List<Pacientes> findPacienteByCPF(String cpf);
}
