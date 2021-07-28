package br.com.fiap.java.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PontosVacinacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPontoVacinacao;
    private Long idVacina;
    private Long idPaciente;
    private Long enderecoVacinacao;
    private Long tipoLocal;
}
