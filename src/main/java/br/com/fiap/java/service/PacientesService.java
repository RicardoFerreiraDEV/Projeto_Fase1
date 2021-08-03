package br.com.fiap.java.service;

import br.com.fiap.java.model.Pacientes;
import br.com.fiap.java.repository.PacientesRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class PacientesService {

    private Boolean system = true;
    private final PacientesRepository pacientesRepository;

    public PacientesService(PacientesRepository pacientesRepository) {
        this.pacientesRepository = pacientesRepository;
    }

    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("-- CADASTRO DE PACIENTES --");
            System.out.println("1 - Novo");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar");
            System.out.println("4 - Excluir");
            System.out.println("0 - Sair");
            System.out.println("");
            System.out.println("Escolha a Opção : ");
            System.out.println("");

            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    atualizar(scanner);
                    break;
                case 3:
                    visualizar(scanner);
                    break;
                case 4:
                    excluir(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void salvar(Scanner scanner) {
        System.out.println("Nome do Paciente : ");
        String nomePaciente = scanner.next();
        Pacientes paciente = new Pacientes();
        paciente.setNome(nomePaciente);
        pacientesRepository.save(paciente);
        System.out.println("Paciente Salvo com Sucesso!");
        System.out.println("");
    }

    private void atualizar(Scanner scanner) {
        System.out.println("Código do Paciente :");
        int id_pacientes = scanner.nextInt();
        System.out.println("Novo Nome do Paciente :");
        String nome = scanner.next();
        Pacientes pacientes = new Pacientes();
        pacientes.setNome(nome);
        System.out.println("Paciente Atualizado com Sucesso!");
        System.out.println("");
    }

    private void visualizar(Scanner scanner) {
        Iterable<Pacientes> pacientes = pacientesRepository.findAll();
        pacientes.forEach(paciente -> System.out.println(pacientes));
    }

    private void excluir(Scanner scanner) {
        System.out.println("Digite o Código do Paciente Para Excluir : ");
        int id_paciente = scanner.nextInt();
        pacientesRepository.deleteById(id_paciente);
        System.out.println("Paciente Excluído com Sucesso!");
    }
}
