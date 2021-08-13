package br.com.fiap.java.service;
import java.util.Optional;
import java.util.Scanner;
import br.com.fiap.java.model.Pacientes;
import br.com.fiap.java.repository.PacientesRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class PacientesService {

    private final PacientesRepository pacientesRepository;

    public PacientesService(PacientesRepository pacientesRepository) {
        this.pacientesRepository = pacientesRepository;
    }


    public List<Pacientes> visualizarTodos() {
        return pacientesRepository.findAll();
    }

    public Pacientes visualizar(Long pacienteId) {
        Pacientes pacientesRecuperado = pacientesRepository.findById(pacienteId)
                .orElseThrow(() -> new IllegalStateException("Paciente com Id" + pacienteId + "não existe"));
        return pacientesRecuperado;
    }


    public void salvar(Pacientes paciente) {
        boolean isPresent = pacientesRepository.findById(paciente.getIdPacientes()).isPresent();

        if(isPresent) {
           throw new IllegalStateException("Paciente ja cadastrado");
        }



        pacientesRepository.save(paciente);
    }

    public void deletar(Long pacienteId) {
        boolean exists = pacientesRepository.existsById(pacienteId);

        if(!exists) {
            throw new IllegalStateException("Paciente com Id" + pacienteId + "não existe");
        }

        pacientesRepository.deleteById(pacienteId);
    }

    @Transactional
    public void atualizarPaciente(Pacientes paciente) {
        Pacientes pacientesRecuperado = pacientesRepository.findById(paciente.getIdPacientes())
                .orElseThrow(() -> new IllegalStateException("Paciente com Id" + paciente.getIdPacientes() + "não existe"));

        //verificar se o campo não ta zuado;
        //validar email
        //validar cpf
        pacientesRecuperado.setNome(paciente.getNome());
        pacientesRecuperado.setCpf(paciente.getCpf());
        pacientesRecuperado.setDataNasc(paciente.getDataNasc());
        pacientesRecuperado.setDose(paciente.getDose());
        pacientesRecuperado.setEndereco(paciente.getEndereco());
        pacientesRecuperado.setDataVasc(paciente.getDataVasc());
        pacientesRecuperado.setTelefone(paciente.getTelefone());
        pacientesRecuperado.setNomeMae(paciente.getNomeMae());
        pacientesRecuperado.setNomePai(paciente.getNomePai());
        pacientesRecuperado.setSexo(paciente.getSexo());
        pacientesRecuperado.setGrupoPrioridade(paciente.getGrupoPrioridade());
        pacientesRecuperado.setRacaCor(paciente.getRacaCor());

    }


}
