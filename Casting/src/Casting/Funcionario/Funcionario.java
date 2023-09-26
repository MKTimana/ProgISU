package Casting.Funcionario;

import Exceptions.ValorNegativoException;

public class Funcionario {
    private String nome;
    private double salario;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        if(salario <0){
            throw new ValorNegativoException("O salario nao deve ser negativo");
        }else{
            this.salario = salario;
        }
    }
    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
        setSalario(salario);
    }
    
    
    
}
