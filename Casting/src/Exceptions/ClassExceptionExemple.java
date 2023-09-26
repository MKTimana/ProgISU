package Exceptions;

public class ClassExceptionExemple {
    public static void main(String[] args) {
        try {
            Object num = Double.valueOf(10.10);
            String teste = (String) num;

        } catch (ClassCastException e) {
            System.out.println("Erro de casting porconta do conversao do: ");
        }
        System.out.println("Fechado o ClassCast");

        
    }

}
