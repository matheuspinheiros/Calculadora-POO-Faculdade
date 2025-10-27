package calculadora;

public class RaizQuadrada implements Operacao {
    @Override
    public String getNome() {
        return "Raiz Quadrada";
    }

    @Override
    public String getSimbolo() {
        return "sqrt";
    }

    @Override
    public int getNumOperandos() {
        return 1;
    }

    @Override
    public double calcular(double... operandos) {
        if (operandos.length != getNumOperandos()) {
            throw new IllegalArgumentException("A raiz quadrada requer 1 operando.");
        }
        if (operandos[0] < 0) {
            throw new ArithmeticException("Não é possível calcular a raiz de um número negativo.");
        }
        return Math.sqrt(operandos[0]);
    }
}