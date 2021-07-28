package br.com.fiap.java.validation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class cpf {

    private String numero;
    public cpf(String numero) {
        if (numero == null ||
                !numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("CPF inválido!");
        }
        this.numero = numero;
    }



}
