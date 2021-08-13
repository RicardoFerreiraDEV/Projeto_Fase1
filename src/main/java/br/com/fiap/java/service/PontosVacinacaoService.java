package br.com.fiap.java.service;

import br.com.fiap.java.model.PontosVacinacao;
import br.com.fiap.java.model.Vacinas;
import br.com.fiap.java.repository.PontosVacinacaoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PontosVacinacaoService {

    private final PontosVacinacaoRepository pontosVacinacaoRepository;

    public PontosVacinacaoService(PontosVacinacaoRepository pontosVacinacaoRepository) {
        this.pontosVacinacaoRepository = pontosVacinacaoRepository;
    }

    public List<PontosVacinacao> visualizarTodos() {
        return pontosVacinacaoRepository.findAll();
    }

    public PontosVacinacao visualizar(Long pontosId) {
        PontosVacinacao pontoRecuperado = pontosVacinacaoRepository.findById(pontosId)
                .orElseThrow(() -> new IllegalStateException("Posto com Id" + pontosId + "não existe"));
        return pontoRecuperado;
    }

    public void salvar(PontosVacinacao posto) {
        boolean isPresent = pontosVacinacaoRepository.findById(posto.getIdPontoVacinacao()).isPresent();

        if(isPresent) {
            throw new IllegalStateException("Ponto ja cadastrado");
        }

        pontosVacinacaoRepository.save(posto);
    }

    public void deletar(Long pontoId) {
        boolean exists = pontosVacinacaoRepository.existsById(pontoId);

        if(!exists) {
            throw new IllegalStateException("Ponto com Id" + pontoId + "não existe");
        }

        pontosVacinacaoRepository.deleteById(pontoId);
    }

    @Transactional
    public void atualizarPontoVacinacao(PontosVacinacao pontosVacinacao) {
        PontosVacinacao pontoRecuperado = pontosVacinacaoRepository.findById(pontosVacinacao.getIdPontoVacinacao())
                .orElseThrow(() -> new IllegalStateException("Ponto com Id" + pontosVacinacao.getIdPontoVacinacao() + "não existe"));

        pontoRecuperado.setEnderecoVacinacao(pontosVacinacao.getEnderecoVacinacao());
        pontoRecuperado.setTipoLocal(pontosVacinacao.getTipoLocal());
    }


}
