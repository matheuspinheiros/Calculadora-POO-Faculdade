package calculadora;

import java.util.ArrayList;
import java.util.List;

public class Calculadora {

    private final List<Operacao> operacoes;
    
    private final Historico historico;
    
    private final InputUtil input;

    public Calculadora(InputUtil input) {
        this.input = input;
        this.historico = new Historico();
        this.operacoes = new ArrayList<>();
    }

    public void carregarOperacoes(List<Operacao> operacoes) {
        this.operacoes.addAll(operacoes);
    }

    public void iniciar() {
        System.out.println("Bem-vindo à Calculadora");

        boolean deveContinuar = true; 
        
        while (deveContinuar) {
            mostrarMenu();
            int opcao = input.lerOpcao("Escolha uma opção: ");

            if (opcao == 0) {
                System.out.println("Até logo!");
                deveContinuar = false;
            } else if (opcao == 11) {
                historico.mostrar();
            } else if (opcao > 0 && opcao <= operacoes.size()) {
                executarOperacao(opcao - 1);
                while (true) {
                    int continuar = input.lerOpcao("\nDeseja fazer outra operação? (1-Sim / 2-Não): ");
                    if (continuar == 1) {
                        break; 
                    } else if (continuar == 2) {
                        System.out.println("Até logo!");
                        deveContinuar = false;
                        break;
                    } else {
                        System.err.println("Opção inválida. Digite 1 para Sim ou 2 para Não.");
                    }
                }
            } else {
                System.err.println("Opção inválida. Tente novamente.");
            }
        }
        
        input.fechar();
    }

    private void mostrarMenu() {
        System.out.println("\n--- Menu Principal ---");
        for (int i = 0; i < operacoes.size(); i++) {
            System.out.printf("%d. %s\n", (i + 1), operacoes.get(i).getNome());
        }
        System.out.println("----------------------");
        System.out.println("11. Ver Histórico");
        System.out.println("0. Sair");
    }

    private void executarOperacao(int indiceOperacao) {
        try {
            Operacao operacao = operacoes.get(indiceOperacao);
            int numOperandos = operacao.getNumOperandos();
            double[] operandos = new double[numOperandos];
            for (int i = 0; i < numOperandos; i++) {
                operandos[i] = input.lerNumero(String.format("Digite o %dº número: ", i + 1));
            }

            double resultado = operacao.calcular(operandos);

            System.out.printf(">> O resultado é: %.2f\n", resultado);
            
            String expressao = formatarExpressao(operacao, operandos, resultado);
            historico.adicionar(expressao);

        } catch (Exception e) {
            System.err.println("Erro ao calcular: " + e.getMessage());
        }
    }
    
    private String formatarExpressao(Operacao op, double[] operandos, double resultado) {
        StringBuilder sb = new StringBuilder();
        
        if (op.getNumOperandos() == 1) {
            sb.append(op.getSimbolo());
            sb.append(String.format("(%.2f)", operandos[0]));
        } else {
            sb.append(String.format("%.2f", operandos[0]));
            for (int i = 1; i < operandos.length; i++) {
                sb.append(String.format(" %s %.2f", op.getSimbolo(), operandos[i]));
            }
        }
        
        sb.append(String.format(" = %.2f", resultado));
        return sb.toString();
    }
}