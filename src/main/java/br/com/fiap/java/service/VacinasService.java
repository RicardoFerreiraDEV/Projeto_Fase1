package br.com.fiap.java.service;

import br.com.fiap.java.model.Vacinas;
import br.com.fiap.java.repository.VacinasRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class VacinasService {

    private Boolean system = true;
    private final VacinasRepository vacinasRepository;

    public VacinasService(VacinasRepository vacinasRepository) {
        this.vacinasRepository = vacinasRepository;
    }

    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("-- APLICAÇÃO DE VACINAS --");
            System.out.println("");
            System.out.println("1 - Novo");
            System.out.println("2 - Visualizar");
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
                    visualizar(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void salvar(Scanner scanner) {
        System.out.println("Código do Paciente : ");
        String nomeVacina = scanner.next();
        Vacinas vacina = new Vacinas();
        vacina.setNomeVacina(nomeVacina);
        vacinasRepository.save(vacina);
        System.out.println("Paciente Vacinado com Sucesso!");
        System.out.println("");
    }

    private void visualizar(Scanner scanner) {
        Iterable<Vacinas> vacinas = vacinasRepository.findAll();
        vacinas.forEach(vacina -> System.out.println(vacinas));
    }



}

