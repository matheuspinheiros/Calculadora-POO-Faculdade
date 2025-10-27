package calculadora;

public class Divisao implements Operacao {
    @Override
    public String getNome() {
        return "Divisão";
    }

    @Override
    public String getSimbolo() {
        return "/";
    }

    @Override
    public int getNumOperandos() {
        return 2;
    }

    @Override
    public double calcular(double... operandos) {
        if (operandos.length != getNumOperandos()) {
            throw new IllegalArgumentException("A divisão requer 2 operandos.");
        }
        if (operandos[1] == 0) {
            throw new ArithmeticException("Erro: Divisão por zero.");
        }
        return operandos[0] / operandos[1];
    }
}
