package br.com.fiap.java;

import br.com.fiap.java.model.Pacientes;
import br.com.fiap.java.model.PontosVacinacao;
import br.com.fiap.java.model.Vacinas;
import br.com.fiap.java.service.PacientesService;
import br.com.fiap.java.service.PontosVacinacaoService;
import br.com.fiap.java.service.VacinasService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Scanner;

@SpringBootApplication
public class ProjetoApplication implements CommandLineRunner {

    private final PacientesService pacientesService;
    private final VacinasService vacinasService;
    private final PontosVacinacaoService pontosVacinacaoService;

    private Boolean system = true;

    public ProjetoApplication(PacientesService pacientesService, VacinasService vacinasService, PontosVacinacaoService pontosVacinacaoService) {
        this.pacientesService = pacientesService;
        this.vacinasService = vacinasService;
        this.pontosVacinacaoService = pontosVacinacaoService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjetoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LocalDate date = LocalDate.now();

        PontosVacinacao pontos = new PontosVacinacao();
        pontos.setIdPontoVacinacao(1L);
        PontosVacinacao pontos2 = new PontosVacinacao();
        pontos2.setIdPontoVacinacao(2L);
        PontosVacinacao pontos3 = new PontosVacinacao();
        pontos3.setIdPontoVacinacao(3L);
        PontosVacinacao pontos4 = new PontosVacinacao();
        pontos4.setIdPontoVacinacao(4L);
        pontosVacinacaoService.salvar(pontos);
        pontosVacinacaoService.salvar(pontos2);
        pontosVacinacaoService.salvar(pontos3);
        pontosVacinacaoService.salvar(pontos4);

        Vacinas vacina = new Vacinas("Astrazeneca", date, "JJFSU&*&WHSJJ",pontos);
        vacina.setIdVacina(1L);
        Vacinas vacina2 = new Vacinas("CORONAVAC", date, "FDUJHDSAL(*&YWHSJJ",pontos2);
        vacina2.setIdVacina(2L);
        Vacinas vacina3 = new Vacinas("Astrazeneca", date, "JJFSU&*&WHSJJ",pontos3);
        vacina3.setIdVacina(3L);

        vacinasService.salvar(vacina);
        vacinasService.salvar(vacina2);
        vacinasService.salvar(vacina3);

        Pacientes paciente = new Pacientes("Ricardo FErreira",  date, "Rua Piraporinha do sul",
                "Primeira", date, "11985647789", "Gustavo Oliva", "Jorge Tablet",
                "Masculino", "40785898715","Sim","Branco",vacina2);

        paciente.setIdPacientes(1L);        

        Pacientes paciente2 = new Pacientes("Henrique Rangel",  date, "Rua ponta da mandanha",
                "Primeira", date, "11982305700", "Flavia Abravanel", "Felipe Oliveira",
                "Masculino", "52189654712","Sim","Negro",vacina);

        paciente2.setIdPacientes(2L);        

        Pacientes paciente3 = new Pacientes("Godofredo Alves",  date, "Rua ponta da mandanha",
                "Primeira", date, "11982305700", "Flavia Abravanel", "Felipe Oliveira",
                "Masculino", "45674123654","Sim","Negro",vacina);

        paciente3.setIdPacientes(3L);        

        Pacientes paciente4 = new Pacientes("Shirley Braga",  date, "Rua ponta da mandanha",
                "Primeira", date, "11982305700", "Flavia Abravanel", "Felipe Oliveira",
                "Masculino", "40785898715","Sim","Negro",vacina);

        paciente4.setIdPacientes(4L);        
        pacientesService.salvar(paciente);
        pacientesService.salvar(paciente2);
        pacientesService.salvar(paciente3);
        pacientesService.salvar(paciente4);


        pacientesService.deletar(4L);


        paciente.setCpf("99999999999");
        pacientesService.atualizarPaciente(paciente);
        Pacientes pacienteRecuperado = pacientesService.visualizar(1L);
        vacinasService.deletar(2L);
    }


    

    

}
