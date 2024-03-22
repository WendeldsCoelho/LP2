import java.util.Random;
public class SomadorAleatorio extends Thread {
    final int MAX = 10; // valor máximo possível de ser gerado de forma pseudoaleatório
    private int soma = 0; // soma de valores pseudoaleatórios
    private int intervalo = 0; // intervalo para geração de inteiros pseudoaleatórios (em seg)
    // construtor com inicialização de intervalo de geração de inteiros pseudoaleatórios
    public SomadorAleatorio(int intervalo) {
    this.intervalo = intervalo;
    }
    // retorno de soma de valores pseudoaleatórios até então gerados
    public int getSomaAtual() {
    return soma;
    }
    // tarefa de geração e totalização de inteiros pseudoaleatórios
    public void run() {
    Random gerador = new Random(); // gerador de números pseudoaleatórios
    while (true) { // loop infinito
    try {
    // geração de inteiro pseudoaleatório e atualização de soma
    soma += gerador.nextInt(MAX) + 1;
    sleep(intervalo * 1000); // espera de acordo com intervalo
    }
    catch(InterruptedException e) {
    e.printStackTrace();
    }
    }
    }
   }
   