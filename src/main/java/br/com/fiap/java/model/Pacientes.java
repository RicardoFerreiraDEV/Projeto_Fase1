package br.com.fiap.java.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_pacientes")
public class Pacientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPacientes;
    private String nome;
    private LocalDate dataNasc;
    private String endereco;
    private String dose;
    private LocalDate dataVac;
    private String telefone;
    private String nomeMae;
    private String nomePai;
    private String sexo;
    private String cpf;
    private String grupoPrioridade;
    private String racaCor;

    @ManyToOne
    private Vacinas Vacina;

    public Pacientes(String nome, LocalDate dataNasc, String endereco, String dose, LocalDate dataVasc, String telefone, String nomeMae, String nomePai, String sexo, String cpf, String grupoPrioridade, String racaCor, Vacinas vacina) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.dose = dose;
        this.dataVac = dataVasc;
        this.telefone = telefone;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.sexo = sexo;
        this.cpf = cpf;
        this.grupoPrioridade = grupoPrioridade;
        this.racaCor = racaCor;
        Vacina = vacina;
    }

    public Pacientes() {
    }

    public Long getIdPacientes() {
        return idPacientes;
    }

    public void setIdPacientes(Long idPacientes) {
        this.idPacientes = idPacientes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
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
        return dataVac;
    }

    public void setDataVasc(LocalDate dataVasc) {
        this.dataVac = dataVasc;
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
                ", nome='" + nome + '\'' +
                ", dataNasc=" + dataNasc +
                ", endereco='" + endereco + '\'' +
                ", dose='" + dose + '\'' +
                ", dataVasc=" + dataVac +
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
