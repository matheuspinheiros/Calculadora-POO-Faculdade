package calculadora;

public interface Operacao {
    String getNome();
    
    String getSimbolo();
    
    int getNumOperandos();
    
    double calcular(double... operandos);
}