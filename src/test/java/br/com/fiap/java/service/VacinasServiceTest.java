package br.com.fiap.java.service;

import br.com.fiap.java.model.Pacientes;
import br.com.fiap.java.model.PontosVacinacao;
import br.com.fiap.java.model.Vacinas;
import br.com.fiap.java.repository.PacientesRepository;
import br.com.fiap.java.repository.VacinasRepository;
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
class VacinasServiceTest {


    @Mock
    private VacinasRepository vacinasRepositoryMock;
    private VacinasService vacinasServiceMock;

    @BeforeEach
    void setUp() {
        vacinasServiceMock = new VacinasService(vacinasRepositoryMock);

    }

    @Test
    void salvarOK() {
        //given

        LocalDate date = LocalDate.now();

        PontosVacinacao pontos = new PontosVacinacao();
        Vacinas vacina = new Vacinas("Astrazeneca", date, "JJFSU&*&WHSJJ",pontos);


        //when
        vacinasServiceMock.salvar(vacina);

        //then
        ArgumentCaptor<Vacinas> pacientesArgumentCaptor = ArgumentCaptor.forClass(Vacinas.class);
        verify(vacinasRepositoryMock).save(pacientesArgumentCaptor.capture());
        Vacinas vacinaCapturada = pacientesArgumentCaptor.getValue();

        assertThat(vacinaCapturada).isEqualTo(vacina);
    }

    @Test
    void salvarException() throws Exception {
        //given

        LocalDate date = LocalDate.now();

        PontosVacinacao pontos = new PontosVacinacao();
        Vacinas vacina = new Vacinas("Astrazeneca", date, "JJFSU&*&WHSJJ",pontos);


        when(vacinasRepositoryMock.findById(vacina.getIdVacina())).thenReturn(Optional.of(vacina));
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            vacinasServiceMock.salvar(vacina);
        });
        String expectedMessage = "Vacina ja cadastrada";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test

    void atualizarPaciente() {
        //given

        LocalDate date = LocalDate.now();

        PontosVacinacao pontos = new PontosVacinacao();
        Vacinas vacina = new Vacinas("Astrazeneca", date, "JJFSU&*&WHSJJ",pontos);


        when(vacinasRepositoryMock.findById(vacina.getIdVacina())).thenReturn(Optional.of(vacina));

        vacinasServiceMock.atualizarVacina(vacina);

        verify(vacinasRepositoryMock).findById(vacina.getIdVacina());
    }

    @Test

    void atualizarPacienteException() {
        //given

        LocalDate date = LocalDate.now();

        PontosVacinacao pontos = new PontosVacinacao();
        Vacinas vacina = new Vacinas("Astrazeneca", date, "JJFSU&*&WHSJJ",pontos);

        //when
        given(vacinasRepositoryMock.findById(vacina.getIdVacina())).willReturn(Optional.<Vacinas>empty());

        //then
        assertThatThrownBy(() -> vacinasServiceMock.atualizarVacina(vacina))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Vacina com Id" + vacina.getIdVacina() + "não existe");
    }

    @Test
    void visualizarTodos() {
        //when
        vacinasServiceMock.visualizarTodos();
        //then
        verify(vacinasRepositoryMock).findAll();
    }

    @Test
    void visualizarUm() {
        //given

        LocalDate date = LocalDate.now();

        PontosVacinacao pontos = new PontosVacinacao();
        Vacinas vacina = new Vacinas("Astrazeneca", date, "JJFSU&*&WHSJJ",pontos);

        when(vacinasRepositoryMock.findById(vacina.getIdVacina())).thenReturn(Optional.of(vacina));

        Vacinas expected = vacinasServiceMock.visualizar(vacina.getIdVacina());

        assertThat(expected).isSameAs(vacina);
        verify(vacinasRepositoryMock).findById(vacina.getIdVacina());
    }

    @Test
    void visualizarUmException() {
        LocalDate date = LocalDate.now();

        PontosVacinacao pontos = new PontosVacinacao();
        Vacinas vacina = new Vacinas("Astrazeneca", date, "JJFSU&*&WHSJJ",pontos);

        //when
        given(vacinasRepositoryMock.findById(vacina.getIdVacina())).willReturn(Optional.<Vacinas>empty());

        //then
        assertThatThrownBy(() -> vacinasServiceMock.visualizar(vacina.getIdVacina()))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Vacina com Id" + vacina.getIdVacina() + "não existe");
    }

    @Test
    void deletar() {
        //given

        LocalDate date = LocalDate.now();

        PontosVacinacao pontos = new PontosVacinacao();
        Vacinas vacina = new Vacinas("Astrazeneca", date, "JJFSU&*&WHSJJ",pontos);


        //when
        vacinasServiceMock.deletar(vacina.getIdVacina());

        //then
        ArgumentCaptor<Long> vacinaArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(vacinasRepositoryMock).deleteById(vacinaArgumentCaptor.capture());
        Long vacinaId = vacinaArgumentCaptor.getValue();

        assertThat(vacinaId).isEqualTo(vacina.getIdVacina());
    }

    @Test
    void deletarException() {
        //given

        LocalDate date = LocalDate.now();

        PontosVacinacao pontos = new PontosVacinacao();
        Vacinas vacina = new Vacinas("Astrazeneca", date, "JJFSU&*&WHSJJ",pontos);


        when(vacinasRepositoryMock.existsById(vacina.getIdVacina())).thenReturn(true);
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            vacinasServiceMock.deletar(vacina.getIdVacina());
        });
        String expectedMessage = "Vacina com Id" + vacina.getIdVacina() + "não existe";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}