package br.com.fiap.java.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table(name = "pacientes")
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

    public Long getIdPacientes() {
        return idPacientes;
    }

    public void setIdPacientes(Long idPacientes) {
        this.idPacientes = idPacientes;
    }

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNac() {
        return dataNac;
    }

    public void setDataNac(LocalDate dataNac) {
        this.dataNac = dataNac;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public LocalDate getDataVasc() {
        return dataVasc;
    }

    public void setDataVasc(LocalDate dataVasc) {
        this.dataVasc = dataVasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGrupoPrioridade() {
        return grupoPrioridade;
    }

    public void setGrupoPrioridade(String grupoPrioridade) {
        this.grupoPrioridade = grupoPrioridade;
    }

    public String getRacaCor() {
        return racaCor;
    }

    public void setRacaCor(String racaCor) {
        this.racaCor = racaCor;
    }

    @Override
    public String toString() {
        return "Pacientes{" +
                "idPacientes=" + idPacientes +
                ", idVacina=" + idVacina +
                ", idPontoVacinacao=" + idPontoVacinacao +
                ", nome='" + nome + '\'' +
                ", dataNac=" + dataNac +
                ", endereco='" + endereco + '\'' +
                ", dose='" + dose + '\'' +
                ", dataVasc=" + dataVasc +
                ", telefone='" + telefone + '\'' +
                ", nomeMae='" + nomeMae + '\'' +
                ", nomePai='" + nomePai + '\'' +
                ", sexo='" + sexo + '\'' +
                ", cpf='" + cpf + '\'' +
                ", grupoPrioridade='" + grupoPrioridade + '\'' +
                ", racaCor='" + racaCor + '\'' +
                '}';
    }
}
