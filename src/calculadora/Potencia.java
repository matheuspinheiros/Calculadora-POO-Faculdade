package calculadora;

public class Potencia implements Operacao {
    @Override
    public String getNome() {
        return "Potência (x^y)";
    }

    @Override
    public String getSimbolo() {
        return "^";
    }

    @Override
    public int getNumOperandos() {
        return 2;
    }

    @Override
    public double calcular(double... operandos) {
        if (operandos.length != getNumOperandos()) {
            throw new IllegalArgumentException("A potência requer 2 operandos.");
        }
        return Math.pow(operandos[0], operandos[1]);
    }
}