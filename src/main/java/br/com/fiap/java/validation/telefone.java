package br.com.fiap.java.validation;

public class telefone {

    private String ddd;
    private String numero;

    public telefone(String ddd, String numero) {
        if (ddd == null || numero == null) {
            throw new IllegalArgumentException("Numero sao obrigatorios!");
        }
        if (!ddd.matches("\\d{2}")) {
            throw new IllegalArgumentException("DDD invalido!");
        }
        if (!numero.matches("\\d{8}|\\d{9}")) {
            throw new IllegalArgumentException("Numero invalido!");
        }
        this.ddd = ddd;
        this.numero = numero;
    }


}
