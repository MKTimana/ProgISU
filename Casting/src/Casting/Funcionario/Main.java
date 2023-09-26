package Casting.Funcionario;

import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        // System.out.println("Dados do professor");
        // System.out.println("Insira o nome do professor");
        // String nomeProf = in.nextLine();
        // System.out.println("Insira o salario do "+nomeProf);
        // double salProf = in.nextDouble();

        System.out.println("Dados do Monitor");
        System.out.println("Insira o nome do Monitor");
        String nomeM = in.nextLine();
        System.out.println("Insira o salario do "+nomeM);
        double salM = in.nextDouble();
        System.out.println("Quantas horas ele trabalhou?");
        int horas = in.nextInt();

        // Professor prof = new Professor(nomeProf,salProf);
        Monitor al = new Monitor(nomeM,salM,horas);
        
        // prof.retSalario();
        System.out.println(al.calcSal(salM, horas));
        
    }
}
