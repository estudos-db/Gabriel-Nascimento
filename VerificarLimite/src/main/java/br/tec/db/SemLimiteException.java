package br.tec.db;

public class SemLimiteException extends RuntimeException{

    public SemLimiteException(){};

    public SemLimiteException(String s){
        super(s);
    };
}
