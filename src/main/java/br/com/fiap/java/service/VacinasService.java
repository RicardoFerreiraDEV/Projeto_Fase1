package br.com.fiap.java.service;

import br.com.fiap.java.model.Pacientes;
import br.com.fiap.java.model.Vacinas;
import br.com.fiap.java.repository.VacinasRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Scanner;

@Service
public class VacinasService {

    private Boolean system = true;
    private final VacinasRepository vacinasRepository;

    public VacinasService(VacinasRepository vacinasRepository) {
        this.vacinasRepository = vacinasRepository;
    }

    //////////////////////////////////////////////////////////////////

    public List<Vacinas> visualizarTodos() {
        return vacinasRepository.findAll();
    }

    public Vacinas visualizar(Long vacinaId) {
        Vacinas vacinaRecuperada = vacinasRepository.findById(vacinaId)
                .orElseThrow(() -> new IllegalStateException("Vacina com Id" + vacinaId + "não existe"));
        return vacinaRecuperada;
    }

    public void salvar(Vacinas vacina) {
        boolean isPresent = vacinasRepository.findById(vacina.getIdVacina()).isPresent();

        if(isPresent) {
            throw new IllegalStateException("Vacina ja cadastrada");
        }

        vacinasRepository.save(vacina);
    }

    public void deletar(Long vacinaId) {
        boolean exists = vacinasRepository.existsById(vacinaId);

        if(!exists) {
            throw new IllegalStateException("Vacina com Id" + vacinaId + "não existe");
        }

        vacinasRepository.deleteById(vacinaId);
    }

    @Transactional
    public void atualizarVacina(Vacinas vacina) {
        Vacinas vacinaRecuperada = vacinasRepository.findById(vacina.getIdVacina())
                .orElseThrow(() -> new IllegalStateException("Vacina com Id" + vacina.getIdVacina() + "não existe"));

        //verificar se o campo não ta zuado;
        //validar email
        //validar cpf
        vacinaRecuperada.setNomeVacina(vacina.getNomeVacina());
        vacinaRecuperada.setLote(vacina.getLote());
        vacinaRecuperada.setVencimento(vacina.getVencimento());
    }

}

