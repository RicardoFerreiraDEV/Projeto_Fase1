package br.com.fiap.java.service;

import br.com.fiap.java.model.Pacientes;
import br.com.fiap.java.repository.PacientesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
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
            System.out.println("");
            System.out.println("1 - Novo");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar Todos");
            System.out.println("4 - Visualizar Por Nome");
            System.out.println("5 - Excluir");
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
                    visualizarAll(scanner);
                    break;
                case 4:
                    visualizar(scanner);
                    break;
                case 5:
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
        String nome = scanner.next();
        System.out.println("Data Nascimento : ");
        LocalDate dataNasc = LocalDate.parse(scanner.next());
        System.out.println("Endereço : ");
        String endereco = scanner.next();
        System.out.println("Dose : ");
        String dose = scanner.next();
        System.out.println("Telefone : ");
        String telefone = scanner.next();
        System.out.println("Nome da Mãe : ");
        String nomeMae = scanner.next();
        System.out.println("Nome do Pai : ");
        String nomePai = scanner.next();
        System.out.println("Sexo : ");
        String sexo = scanner.next();
        System.out.println("CPF : ");
        String cpf = scanner.next();
        System.out.println("Grupo Prioridade : ");
        String grupoprioridade = scanner.next();
        System.out.println("Raca / Cor : ");
        String racacor = scanner.next();
        Pacientes paciente = new Pacientes();
        paciente.setNome(nome);
        paciente.setDataNasc(dataNasc);
        paciente.setEndereco(endereco);
        paciente.setDose(dose);
        paciente.setTelefone(telefone);
        paciente.setNomeMae(nomeMae);
        paciente.setNomePai(nomePai);
        paciente.setSexo(sexo);
        paciente.setCpf(cpf);
        paciente.setGrupoPrioridade(grupoprioridade);
        paciente.setRacaCor(racacor);
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

    private void visualizarAll(Scanner scanner) {
        Iterable<Pacientes> pacientes = pacientesRepository.findAll();
        pacientes.forEach(paciente -> System.out.println(pacientes));
    }

    private void visualizar(Scanner scanner) {
        System.out.println("Nome do Paciente : ");
        String nome = scanner.next();
        List<Pacientes> list = pacientesRepository.findAllByNome(nome);
        list.forEach(System.out::println);
    }

    private void excluir(Scanner scanner) {
        System.out.println("Digite o Código do Paciente Para Excluir : ");
        int id_paciente = (int) scanner.nextLong();
        pacientesRepository.deleteById(id_paciente);
        System.out.println("Paciente Excluído com Sucesso!");
    }
}
