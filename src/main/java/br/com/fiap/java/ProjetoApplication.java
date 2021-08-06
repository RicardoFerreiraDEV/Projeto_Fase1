package br.com.fiap.java;

import br.com.fiap.java.service.PacientesService;
import br.com.fiap.java.service.VacinasService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ProjetoApplication implements CommandLineRunner {

    private final PacientesService pacientesService;
    private final VacinasService vacinasService;

    private Boolean system = true;

    public ProjetoApplication(PacientesService pacientesService, VacinasService vacinasService) {
        this.pacientesService = pacientesService;
        this.vacinasService = vacinasService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjetoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while(system) {
            System.out.println("");
            System.out.println("--- SISTEMA DE CONTROLE DE VACINAS ---");
            System.out.println("");
            System.out.println("1 - Pacientes");
            System.out.println("2 - Vacinas");
            System.out.println("0 - Sair");
            System.out.println("");
            System.out.println("Digite uma Opção : ");

            int action = scanner.nextInt();
            if(action == 1){
                pacientesService.inicial(scanner);
            }if(action == 2){
                vacinasService.inicial(scanner);
            }else
                system = false;
        }
    }
}
