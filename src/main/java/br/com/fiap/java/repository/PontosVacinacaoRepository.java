package br.com.fiap.java.repository;

import br.com.fiap.java.model.PontosVacinacao;
import br.com.fiap.java.model.Vacinas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontosVacinacaoRepository extends JpaRepository<PontosVacinacao, Long> {
}
