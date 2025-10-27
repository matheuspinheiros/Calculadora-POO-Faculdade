#  Calculadora POO - Trabalho da Faculdade

Este projeto é uma calculadora desenvolvida em Java puro, focada em aplicar os conceitos fundamentais da Programação Orientada a Objetos (POO) e os relacionamentos entre classes UML.

## Funcionalidades

* Operações básicas: Soma, Subtração, Multiplicação, Divisão.
* Operações adicionais: Potência (x^y) e Raiz Quadrada.
* Histórico de operações.
* Interface via terminal.

## Conceitos de POO Aplicados

* **Abstração:** Uso da interface `Operacao.java` para definir o contrato de um cálculo.
* **Polimorfismo:** A classe `Calculadora` executa o método `calcular()` sem saber qual operação específica está sendo chamada.
* **Herança (Implementação):** Classes como `Soma`, `Potencia`, etc., implementam a interface `Operacao`.
* **Encapsulamento:** Atributos privados (`private`) com acesso via métodos públicos (ex: `Historico.java`).
* **Relacionamentos:**
    * **Composição:** `Calculadora` ◆-- `Historico`
    * **Agregação:** `Calculadora` ◇-- `Operacao`
    * **Dependência:** `Main` ...> `Calculadora`

---

## Como Compilar e Rodar (Via Terminal)

O projeto foi feito para ser compilado e executado diretamente pelo terminal, sem necessidade de Maven ou Gradle.

**Pré-requisito:** Ter o JDK (Java Development Kit) instalado e configurado no PATH do sistema.

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/matheuspinheiros/Calculadora-POO-Faculdade](https://github.com/matheuspinheiros/Calculadora-POO-Faculdade)
    cd Calculadora
    ```

2.  **Compile o código:**
    Este comando compila todos os arquivos `.java` e coloca os `.class` resultantes em uma pasta `bin`.
    ```bash
    javac -d bin src/calculadora/*.java
    ```

3.  **Execute o programa:**
    Este comando executa a classe `Main` que está dentro do pacote `calculadora`, usando a pasta `bin` como classpath.
    ```bash
    java -cp bin calculadora.Main
    ```