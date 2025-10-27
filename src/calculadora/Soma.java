package calculadora;

public class Soma implements Operacao {
    @Override
    public String getNome() {
        return "Soma";
    }

    @Override
    public String getSimbolo() {
        return "+";
    }
    
    @Override
    public int getNumOperandos() {
        return 2;
    }

    @Override
    public double calcular(double... operandos) {
        if (operandos.length != getNumOperandos()) {
            throw new IllegalArgumentException("A soma requer 2 operandos.");
        }
        return operandos[0] + operandos[1];
    }
}