package br.tec.db;

public class ValidadorCPF {

    public boolean valida(String cpf){

        char digito10, digito11;
        int digito, resto, soma, numeroCalculo;

        if(cpf.equals("11111111111") || cpf.equals("22222222222") ||
            cpf.equals("33333333333") || cpf.equals("44444444444") ||
            cpf.equals("55555555555") || cpf.equals("66666666666") ||
            cpf.equals("77777777777") || cpf.equals("88888888888") ||
            cpf.equals("99999999999") || cpf.length() != 11){

            throw new IllegalArgumentException("CPF invalido");
        }

        //calcula primeiro digito.
        soma = 0;
        numeroCalculo = 10;

        for (int i = 0; i < 9; i++) {
            digito = (int) (cpf.charAt(i) - 48);
            soma = soma + (digito * numeroCalculo);
            numeroCalculo--;
        }

        resto = (soma % 11);

        if (resto == 0 || resto == 1) {
            digito10 = '0';
        } else {
            resto = 11 - resto;
            digito10 = (char) (resto + 48);
        }

        //Calcula segundo digito
        numeroCalculo = 11;
        soma = 0;

        for (int i = 0; i < 10; i++) {
            digito = (int) (cpf.charAt(i) - 48);
            soma = soma + (digito * numeroCalculo);
            numeroCalculo--;
        }

        resto = (soma % 11);

        if (resto == 0 || resto == 1) {
            digito11 = '0';
        } else {
            resto = 11 - resto;
            digito11 = (char) (resto + 48);
        }

        //Se os 2 digitos fechar com o calculo retorna true
        return digito10 == cpf.charAt(9) && digito11 == cpf.charAt(10);


    }
}