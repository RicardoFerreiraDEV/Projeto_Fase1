package br.com.fiap.java.service;

import br.com.fiap.java.model.Pacientes;
import br.com.fiap.java.model.PontosVacinacao;
import br.com.fiap.java.model.Vacinas;
import br.com.fiap.java.repository.PacientesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PacientesServiceTest {

    @Mock
    private PacientesRepository pacientesRepositoryMock;
    private PacientesService pacientesServiceMock;

    @BeforeEach
    void setUp() {
        pacientesServiceMock = new PacientesService(pacientesRepositoryMock);

    }

    @Test
    void salvarOK() {
        //given

        LocalDate date = LocalDate.now();

        PontosVacinacao pontos = new PontosVacinacao();
        Vacinas vacina = new Vacinas("Astrazeneca", date, "JJFSU&*&WHSJJ",pontos);

        Pacientes paciente = new Pacientes("Henrique Rangel",  date, "Rua ponta da mandanha",
                "Primeira", date, "11982305700", "Flavia Abravanel", "Felipe Oliveira",
                "Masculino", "40785898715","Sim","Negro",vacina);

        // paciente.setIdPacientes(1L);
        //when
        pacientesServiceMock.salvar(paciente);

        //then
        ArgumentCaptor<Pacientes> pacientesArgumentCaptor = ArgumentCaptor.forClass(Pacientes.class);
        verify(pacientesRepositoryMock).save(pacientesArgumentCaptor.capture());
        Pacientes pacientesCapturados = pacientesArgumentCaptor.getValue();

        assertThat(pacientesCapturados).isEqualTo(paciente);
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

        when(pacientesRepositoryMock.findById(paciente.getIdPacientes())).thenReturn(Optional.of(paciente));
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            pacientesServiceMock.salvar(paciente);
        });
        String expectedMessage = "Paciente ja cadastrado";
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

        when(pacientesRepositoryMock.findById(paciente.getIdPacientes())).thenReturn(Optional.of(paciente));

        pacientesServiceMock.atualizarPaciente(paciente);

        verify(pacientesRepositoryMock).findById(paciente.getIdPacientes());
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
        given(pacientesRepositoryMock.findById(paciente.getIdPacientes())).willReturn(Optional.<Pacientes>empty());

        //then
        assertThatThrownBy(() -> pacientesServiceMock.atualizarPaciente(paciente))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Paciente com Id" + paciente.getIdPacientes() + "não existe");
    }

    @Test
    void visualizarTodos() {
        //when
        pacientesServiceMock.visualizarTodos();
        //then
        verify(pacientesRepositoryMock).findAll();
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

        when(pacientesRepositoryMock.findById(paciente.getIdPacientes())).thenReturn(Optional.of(paciente));

        Pacientes expected = pacientesServiceMock.visualizar(paciente.getIdPacientes());

        assertThat(expected).isSameAs(paciente);
        verify(pacientesRepositoryMock).findById(paciente.getIdPacientes());
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
        given(pacientesRepositoryMock.findById(paciente.getIdPacientes())).willReturn(Optional.<Pacientes>empty());

        //then
        assertThatThrownBy(() -> pacientesServiceMock.visualizar(paciente.getIdPacientes()))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Paciente com Id" + paciente.getIdPacientes() + "não existe");
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
        pacientesServiceMock.deletar(paciente.getIdPacientes());

        //then
        ArgumentCaptor<Long> pacientesArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(pacientesRepositoryMock).deleteById(pacientesArgumentCaptor.capture());
        Long pacienteId = pacientesArgumentCaptor.getValue();

        assertThat(pacienteId).isEqualTo(paciente.getIdPacientes());
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

        when(pacientesRepositoryMock.existsById(paciente.getIdPacientes())).thenReturn(true);
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            pacientesServiceMock.deletar(paciente.getIdPacientes());
        });
        String expectedMessage = "Paciente com Id" + paciente.getIdPacientes() + "não existe";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}