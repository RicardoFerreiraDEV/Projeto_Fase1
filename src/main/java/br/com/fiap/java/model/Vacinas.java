package br.com.fiap.java.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="vacinas")
public class Vacinas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVacina;
    private String nomeVacina;
    private LocalDate vencimento;
    private String lote;

    @ManyToOne
    private PontosVacinacao pontosVacinacao;

    public Vacinas(String nomeVacina, LocalDate vencimento, String lote, PontosVacinacao pontosVacinacao) {
        this.nomeVacina = nomeVacina;
        this.vencimento = vencimento;
        this.lote = lote;
        this.pontosVacinacao = pontosVacinacao;
    }

    public Vacinas() {
    }

    public Long getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(Long idVacina) {
        this.idVacina = idVacina;
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
                ", nomeVacina=" + nomeVacina +
                ", vencimento=" + vencimento +
                ", lote='" + lote + '\'' +
                '}';
    }
}
