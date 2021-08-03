package br.com.fiap.java.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "PontosVacninas")
public class PontosVacinacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPontoVacinacao;
    private Long idVacina;
    private Long idPaciente;
    private Long enderecoVacinacao;
    private Long tipoLocal;

    public Long getIdPontoVacinacao() {
        return idPontoVacinacao;
    }

    public void setIdPontoVacinacao(Long idPontoVacinacao) {
        this.idPontoVacinacao = idPontoVacinacao;
    }

    public Long getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(Long idVacina) {
        this.idVacina = idVacina;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Long getEnderecoVacinacao() {
        return enderecoVacinacao;
    }

    public void setEnderecoVacinacao(Long enderecoVacinacao) {
        this.enderecoVacinacao = enderecoVacinacao;
    }

    public Long getTipoLocal() {
        return tipoLocal;
    }

    public void setTipoLocal(Long tipoLocal) {
        this.tipoLocal = tipoLocal;
    }

    @Override
    public String toString() {
        return "PontosVacinacao{" +
                "idPontoVacinacao=" + idPontoVacinacao +
                ", idVacina=" + idVacina +
                ", idPaciente=" + idPaciente +
                ", enderecoVacinacao=" + enderecoVacinacao +
                ", tipoLocal=" + tipoLocal +
                '}';
    }
}
