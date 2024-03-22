import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        SomadorAleatorio somadores[] = new SomadorAleatorio[5];
        Scanner scanner = new Scanner(System.in);
        int intervalo;
        for(int i = 0; i < 5; i++){
            System.out.println("Qual o intervalo deseja na geração de números pseudoaleatórios (em segundos) para o Gerador "+(i+1)+":");
            intervalo = scanner.nextInt();
            somadores[i] = new SomadorAleatorio(intervalo);
        }

        int opcao = 0;
        do{
            System.out.println("--------------Operações------------");
            System.out.println("1. Consulta de valor atual de algumas das 5 somas pseudoaleatórias");
            System.out.println("2. Consultar menor valor atual das somas pseudoaleatórias");
            System.out.println("3. Consulta diferença entra maior e menor valor atual das somas pseudoaleatórias");
            System.out.println("$. Encerrar");
            System.out.println("Insira sua escolha (1/2/3/4)");
            switch (opcao) {
                case 1:
                    System.out.println("Escolha qual somador vocês deseja consultar");
                    int somador = scanner.nextInt();
                    System.out.println("Soma atual: " +  somadores[somador-1].getSomaAtual());
                    break;
                
                case 2:
                    int menorValor = somadores[0].getSomaAtual();
                    for(int i = 0; i < 5; i++){
                        if(menorValor > somadores[i].getSomaAtual()){
                            menorValor = somadores[i].getSomaAtual();
                        }
                    }
                    System.out.println("Menor valor entre as somas pseudoaleatórias atuais é: "+menorValor);
                    break;
                
                case 3:
                 int maiorValor = somadores[0].getSomaAtual();
                 int menorValor1 = somadores[0].getSomaAtual();
                    for(int i = 0; i < 5; i++){
                        if(menorValor1 > somadores[i].getSomaAtual()){
                            menorValor1 = somadores[i].getSomaAtual();
                        }
                 }
                    maiorValor = somadores[0].getSomaAtual();
                    for(int i = 0; i < 5; i++){
                        if(maiorValor < somadores[i].getSomaAtual()){
                            maiorValor = somadores[i].getSomaAtual();
                        }
                    }
                    int diferenca = maiorValor - menorValor1;
                    System.out.println("Diferença entre maior e menor valor atual das somas pseudoaleatórias"+diferenca);
                    break;

                case 4:
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }
        }
        while(opcao!= 4);
    }
}
