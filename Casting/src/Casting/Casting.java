package Casting;

public class Casting {
    public static void main(String[] args) {

        try {
            int[] numeros = new int[-4];
            numeros[0] = 10;
            numeros[1] = 20;
            numeros[2] = 30;
            numeros[3] = 40;
            numeros[4] = 50;
            for (int i = 0; i < numeros.length; i++) {
                System.out.println(numeros[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e ) {
            System.out.println(e.getMessage());
        } catch(NegativeArraySizeException e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Cheguei!");
            
        }
    }
}