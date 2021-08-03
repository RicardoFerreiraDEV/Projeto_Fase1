package br.com.fiap.java.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table(name="vacinas")
public class Vacinas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVacina;
    private Long idPontoVacinacao;
    private Long idPaciente;
    private String nomeVacina;
    private LocalDate vencimento;
    private String lote;

    public Long getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(Long idVacina) {
        this.idVacina = idVacina;
    }

    public Long getIdPontoVacinacao() {
        return idPontoVacinacao;
    }

    public void setIdPontoVacinacao(Long idPontoVacinacao) {
        this.idPontoVacinacao = idPontoVacinacao;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    @Override
    public String toString() {
        return "Vacinas{" +
                "idVacina=" + idVacina +
                ", idPontoVacinacao=" + idPontoVacinacao +
                ", idPaciente=" + idPaciente +
                ", nomeVacina=" + nomeVacina +
                ", vencimento=" + vencimento +
                ", lote='" + lote + '\'' +
                '}';
    }
}
