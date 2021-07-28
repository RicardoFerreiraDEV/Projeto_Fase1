package br.com.fiap.java.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pacientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPacientes;
    private Long idVacina;
    private Long idPontoVacinacao;
    private String nome;
    private LocalDate dataNac;
    private String endereco;
    private String dose;
    private LocalDate dataVasc;
    private String telefone;
    private String nomeMae;
    private String nomePai;
    private String sexo;
    private String cpf;
    private String grupoPrioridade;
    private String racaCor;

}
