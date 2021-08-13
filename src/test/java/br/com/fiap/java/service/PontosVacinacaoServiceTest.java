package br.com.fiap.java.service;

import br.com.fiap.java.model.Pacientes;
import br.com.fiap.java.model.PontosVacinacao;
import br.com.fiap.java.model.Vacinas;
import br.com.fiap.java.repository.PontosVacinacaoRepository;
import br.com.fiap.java.service.PontosVacinacaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PontosVacinacaoServiceTest {


    @Mock
    private PontosVacinacaoRepository pontosVacinacaoRepositoryMock;
    private PontosVacinacaoService pontosVacinacaoServiceMock;

    @BeforeEach
    void setUp() {
        pontosVacinacaoServiceMock = new PontosVacinacaoService(pontosVacinacaoRepositoryMock);

    }

    @Test
    void salvarOK() {
        //given

        LocalDate date = LocalDate.now();

        Vacinas vacina = new Vacinas("Astrazeneca", date, "JJFSU&*&WHSJJ",null);

        Pacientes paciente = new Pacientes("Henrique Rangel",  date, "Rua ponta da mandanha",
                "Primeira", date, "11982305700", "Flavia Abravanel", "Felipe Oliveira",
                "Masculino", "40785898715","Sim","Negro",vacina);
        PontosVacinacao pontos = new PontosVacinacao();

        //when
        pontosVacinacaoServiceMock.salvar(pontos);

        //then
        ArgumentCaptor<PontosVacinacao> pontosVacinacaoArgumentCaptor = ArgumentCaptor.forClass(PontosVacinacao.class);
        verify(pontosVacinacaoRepositoryMock).save(pontosVacinacaoArgumentCaptor.capture());
        PontosVacinacao pontosRecuperados = pontosVacinacaoArgumentCaptor.getValue();

        assertThat(pontosRecuperados).isEqualTo(pontos);
    }

    @Test
    void salvarException() throws Exception {
        //given

        LocalDate date = LocalDate.now();

        PontosVacinacao pontos = new PontosVacinacao();
        Vacinas vacina = new Vacinas("Astrazeneca", date, "JJFSU&*&WHSJJ",pontos);

        Pacientes paciente = new Pacientes("Henrique Rangel",  date, "Rua ponta da mandanha",
                "Primeira", date, "11982305700", "Flavia Abravanel", "Felipe Oliveira",
                "Masculino", "40785898715","Sim","Negro",vacina);

        when(pontosVacinacaoRepositoryMock.findById(pontos.getIdPontoVacinacao())).thenReturn(Optional.of(pontos));
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            pontosVacinacaoServiceMock.salvar(pontos);
        });
        String expectedMessage = "Ponto ja cadastrado";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test

    void atualizarPaciente() {
        //given

        LocalDate date = LocalDate.now();

        PontosVacinacao pontos = new PontosVacinacao();
        Vacinas vacina = new Vacinas("Astrazeneca", date, "JJFSU&*&WHSJJ",pontos);

        Pacientes paciente = new Pacientes("Henrique Rangel",  date, "Rua ponta da mandanha",
                "Primeira", date, "11982305700", "Flavia Abravanel", "Felipe Oliveira",
                "Masculino", "40785898715","Sim","Negro",vacina);

        when(pontosVacinacaoRepositoryMock.findById(pontos.getIdPontoVacinacao())).thenReturn(Optional.of(pontos));

        pontosVacinacaoServiceMock.atualizarPontoVacinacao(pontos);

        verify(pontosVacinacaoRepositoryMock).findById(paciente.getIdPacientes());
    }

    @Test

    void atualizarPacienteException() {
        //given

        LocalDate date = LocalDate.now();

        PontosVacinacao pontos = new PontosVacinacao();
        Vacinas vacina = new Vacinas("Astrazeneca", date, "JJFSU&*&WHSJJ",pontos);

        Pacientes paciente = new Pacientes("Henrique Rangel",  date, "Rua ponta da mandanha",
                "Primeira", date, "11982305700", "Flavia Abravanel", "Felipe Oliveira",
                "Masculino", "40785898715","Sim","Negro",vacina);

        //when
        given(pontosVacinacaoRepositoryMock.findById(pontos.getIdPontoVacinacao())).willReturn(Optional.<PontosVacinacao>empty());

        //then
        assertThatThrownBy(() -> pontosVacinacaoServiceMock.atualizarPontoVacinacao(pontos))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Ponto com Id" + paciente.getIdPacientes() + "não existe");
    }

    @Test
    void visualizarTodos() {
        //when
        pontosVacinacaoServiceMock.visualizarTodos();
        //then
        verify(pontosVacinacaoRepositoryMock).findAll();
    }

    @Test
    void visualizarUm() {
        //given

        LocalDate date = LocalDate.now();

        PontosVacinacao pontos = new PontosVacinacao();
        Vacinas vacina = new Vacinas("Astrazeneca", date, "JJFSU&*&WHSJJ",pontos);

        Pacientes paciente = new Pacientes("Henrique Rangel",  date, "Rua ponta da mandanha",
                "Primeira", date, "11982305700", "Flavia Abravanel", "Felipe Oliveira",
                "Masculino", "40785898715","Sim","Negro",vacina);

        when(pontosVacinacaoRepositoryMock.findById(pontos.getIdPontoVacinacao())).thenReturn(Optional.of(pontos));

        PontosVacinacao expected = pontosVacinacaoServiceMock.visualizar(pontos.getIdPontoVacinacao());

        assertThat(expected).isSameAs(pontos);
        verify(pontosVacinacaoRepositoryMock).findById(pontos.getIdPontoVacinacao());
    }

    @Test
    void visualizarUmException() {
        LocalDate date = LocalDate.now();

        PontosVacinacao pontos = new PontosVacinacao();
        Vacinas vacina = new Vacinas("Astrazeneca", date, "JJFSU&*&WHSJJ",pontos);

        Pacientes paciente = new Pacientes("Henrique Rangel",  date, "Rua ponta da mandanha",
                "Primeira", date, "11982305700", "Flavia Abravanel", "Felipe Oliveira",
                "Masculino", "40785898715","Sim","Negro",vacina);

        //when
        given(pontosVacinacaoRepositoryMock.findById(pontos.getIdPontoVacinacao())).willReturn(Optional.<PontosVacinacao>empty());

        //then
        assertThatThrownBy(() -> pontosVacinacaoServiceMock.visualizar(pontos.getIdPontoVacinacao()))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Posto com Id" + pontos.getIdPontoVacinacao() + "não existe");
    }

    @Test
    void deletar() {
        //given

        LocalDate date = LocalDate.now();

        PontosVacinacao pontos = new PontosVacinacao();
        Vacinas vacina = new Vacinas("Astrazeneca", date, "JJFSU&*&WHSJJ",pontos);

        Pacientes paciente = new Pacientes("Henrique Rangel",  date, "Rua ponta da mandanha",
                "Primeira", date, "11982305700", "Flavia Abravanel", "Felipe Oliveira",
                "Masculino", "40785898715","Sim","Negro",vacina);

        //when
        pontosVacinacaoServiceMock.deletar(pontos.getIdPontoVacinacao());

        //then
        ArgumentCaptor<Long> pontosArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(pontosVacinacaoRepositoryMock).deleteById(pontosArgumentCaptor.capture());
        Long pacienteId = pontosArgumentCaptor.getValue();

        assertThat(pacienteId).isEqualTo(pontos.getIdPontoVacinacao());
    }

    @Test
    void deletarException() {
        //given

        LocalDate date = LocalDate.now();

        PontosVacinacao pontos = new PontosVacinacao();
        Vacinas vacina = new Vacinas("Astrazeneca", date, "JJFSU&*&WHSJJ",pontos);

        Pacientes paciente = new Pacientes("Henrique Rangel",  date, "Rua ponta da mandanha",
                "Primeira", date, "11982305700", "Flavia Abravanel", "Felipe Oliveira",
                "Masculino", "40785898715","Sim","Negro",vacina);

        when(pontosVacinacaoRepositoryMock.existsById(pontos.getIdPontoVacinacao())).thenReturn(true);
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            pontosVacinacaoServiceMock.deletar(pontos.getIdPontoVacinacao());
        });
        String expectedMessage = "Ponto com Id" + pontos.getIdPontoVacinacao() + "não existe";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}