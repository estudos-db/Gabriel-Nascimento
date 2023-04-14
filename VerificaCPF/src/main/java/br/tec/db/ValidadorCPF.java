package br.tec.db;

public class ValidadorCPF {

    public boolean valida(String cpf){

        for(int i = 0; i < cpf.length(); i++){
            int iguais = 0;
            if(iguais == cpf.length() || cpf.length() != 11) throw new IllegalArgumentException("CPF invalido");
            if(cpf.charAt(0) == cpf.charAt(i)) iguais++;
        }

        return validaDigitoVerificador(cpf);
    }

    private static Boolean validaDigitoVerificador(String cpf){

        char[] digitosVerificadores = {cpf.charAt(9), cpf.charAt(10)};
        int soma = 0;
        int numeroCalculo = 10;
        int digitosParaCalculo = 9;
        int digito, resto;

        for(int i = 0; i < digitosVerificadores.length; i++){

            for (int j = 0; j < digitosParaCalculo; j++) {
                digito = (cpf.charAt(j) - 48);
                soma = soma + (digito * numeroCalculo);
                numeroCalculo--;
            }

            resto = (soma % 11);

            if (resto == 0 || resto == 1) {
                digitosVerificadores[i] = '0';
            } else {
                resto = 11 - resto;
                digitosVerificadores[i] = (char) (resto + 48);
            }
            numeroCalculo = 11;
            soma = 0;
            digitosParaCalculo = 10;
        }

        return digitosVerificadores[0] == cpf.charAt(9) && digitosVerificadores[1] == cpf.charAt(10);
    }
}