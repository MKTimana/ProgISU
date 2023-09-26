package Casting.Funcionario;

public class Professor extends Funcionario{
   public Professor(String nome, double salario){
    super(nome,salario);
   }

    public void retSalario(){
        System.out.println("O salario do professor e: "+ this.getSalario());
    }

}
