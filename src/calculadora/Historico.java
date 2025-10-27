package calculadora;

import java.util.ArrayList;
import java.util.List;

public class Historico {
    private List<String> expressoes;

    public Historico() {
        this.expressoes = new ArrayList<>();
    }

    public void adicionar(String expressao) {
        this.expressoes.add(expressao);
    }

    public void mostrar() {
        System.out.println("\n--- Histórico de Operações ---");
        if (expressoes.isEmpty()) {
            System.out.println("Nenhuma operação registrada.");
        } else {
            for (String s : expressoes) {
                System.out.println(s);
            }
        }
        System.out.println("--------------------------------\n");
    }
}