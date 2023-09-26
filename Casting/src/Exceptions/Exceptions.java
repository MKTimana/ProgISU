package Exceptions;

import java.util.Scanner;

public class Exceptions {
    private static double valorAPagar;

    public static void pagarPropina(double valor) {
        if (valor < 0) {
            throw new ValorNegativoException("O valor deve ser maior que 0, você passou o valor: " + valor);
        } else {
            valorAPagar = valorAPagar + valor;
        }
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        System.out.print("Insira um valor positivo: ");
        double valorAPagar = input.nextDouble();

        pagarPropina(valorAPagar);
    }
}