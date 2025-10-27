package calculadora;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        InputUtil input = new InputUtil(new Scanner(System.in));

        List<Operacao> operacoesDisponiveis = new ArrayList<>();
        operacoesDisponiveis.add(new Soma());
        operacoesDisponiveis.add(new Subtracao());
        operacoesDisponiveis.add(new Multiplicacao());
        operacoesDisponiveis.add(new Divisao());
        operacoesDisponiveis.add(new Potencia());
        operacoesDisponiveis.add(new RaizQuadrada());
        
        Calculadora calculadora = new Calculadora(input);
        
        calculadora.carregarOperacoes(operacoesDisponiveis);
        
        calculadora.iniciar();
    }
}