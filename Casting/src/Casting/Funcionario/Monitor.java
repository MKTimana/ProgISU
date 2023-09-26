package Casting.Funcionario;

import Exceptions.ValorNegativoException;

public class Monitor extends Funcionario {
    private int horas;

    public Monitor(String nome, double salario, int horas) {
        super(nome, salario);
        setHoras(horas);
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        if (horas < 0) {
            throw new ValorNegativoException("Esse numero de hotas deve ser maior que 0.");
        } else if (horas > 160) {
            throw new ValorNegativoException("Esse numero de hotas deve ser menor que 160.");
        } else {
            this.horas = horas;
        }
    }

    public double calcSal(double sal, int horas) {
        double salario = sal * horas;
        return salario;
    }

}
