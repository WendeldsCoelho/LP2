import java.util.InputMismatchException;
import java.util.Scanner;
public class FilmeUtil {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Filme filmes[] = new Filme[4];

        for(int i = 0; i < 4; i++){
            //boolean filmeCriado = false;
            try{
            System.out.println("Prencha as perguntas abaixo com os dados do filme escolhido......:");
            System.out.println("Título do filme: ");
            String titulo = scanner.nextLine();
            System.out.println("Duração do filme em minutos: ");
            int duracao = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Exibição com áudio original (sim ou não): ");
            boolean audioOriginal = scanner.nextLine().equalsIgnoreCase("sim");
            System.out.println("Exibição com legenda (sim ou não): ");
            boolean legenda = scanner.nextLine().equalsIgnoreCase("sim");
            System.out.println("Preço de entrada inteira: ");
            double entradaInteira = scanner.nextDouble();
            scanner.nextLine();
            filmes[i] = new Filme(titulo, duracao, audioOriginal, legenda, entradaInteira);
            }
            catch(Exception e){
                System.out.println("Erro: " + e.getMessage());
            }
        }

        boolean registrarExibicao = false;
        do{
        try{
            System.out.println("Qual filme você deseja registrar uma nova exibição(1/2/3/4)");
            int numeroFilme = scanner.nextInt();
            if(numeroFilme < 1 || numeroFilme > 4){
                System.out.println("Número inserido é inadequado para a continuação");
            }

            else{
                System.out.println("Informe o número de pessoas que pagaram entrada Inteira");
                int qtdEntradaInteira = scanner.nextInt();
                System.out.println("Informe o número de pessoas que pagaram meia entrada");
                int qtdMeiaEntrada = scanner.nextInt();
                filmes[numeroFilme - 1].registrarExibicao(qtdEntradaInteira,qtdMeiaEntrada);
                registrarExibicao = true;
            }
        }
        catch(InputMismatchException e){
            System.out.println("Erro: Entrada inválida");
        }
        }
        while(!registrarExibicao);
        String opcao;
        do{
            System.out.println("Qual das seguintes opções você deseja executar?");
            System.out.println("a) Listagem de nomes e respectivas durações de filmes com áudio original e com legenda");
            System.out.println("b) Listagem de nomes e respectivas durações de filmes com áudio não original e sem legenda");
            System.out.println("c) Registrar um novo filme");
            System.out.println("d)Listagem de bilheteria dos filmes para os quias houve registros");
            System.out.println("e)Listagem de nomes acompanhados de respectivos tipos de áudio(original ou não) e de legendamento(com ou sem legenda) de filmes cujo percentual de venda de meias entradas até então registradas é superior a 50% do total de entradas vendidads para exibição daqueles filmes");
            System.out.println("f) encerramento da aplicação");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "a":
                    for(int i = 0; i < 4; i++){
                        if(filmes[i].getLegenda() == true && filmes[i].getAudioOriginal() == true){
                            System.out.println("Título: "+filmes[i].getTitulo()+"  duração: "+filmes[i].getDuracao());
                        }
                    }
                    break;
                case "b":
                    for(int i = 0; i < 4; i++){
                        if(filmes[i].getLegenda() == false && filmes[i].getAudioOriginal() == false){
                             System.out.println("Título: "+filmes[i].getTitulo()+"  duração: "+filmes[i].getDuracao());
                    }
                }
                    break;
                case "c":
                    System.out.println("Prencha abaixo os dados do novo filme: ");
                    System.out.println("Título: ");
                    String novoTitulo = scanner.nextLine();
                    System.out.println("Duração");
                    int novaDuracao = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Áudio original (sim ou não)");
                    boolean novoAudio = scanner.nextLine().equalsIgnoreCase("sim");
                    System.out.println("Exibição com legenda (sim ou não)");
                    boolean novaLegenda = scanner.nextLine().equalsIgnoreCase("sim");
                    System.out.println("Preço da entradaInteira");
                    double novaEntradaInteira = scanner.nextDouble();
                    for(int i = 0; i < 4;i++){
                        if(filmes[i] == null){
                            boolean isCoerente = false;
                            do{
                                try{
                            filmes[i] = new Filme(novoTitulo, novaDuracao, novoAudio, novaLegenda,novaEntradaInteira);
                            System.out.println("Novo filme registrado com sucesso, insira abaixo o número de ingressos vendidos de entrada inteira e meia entrada");
                            System.out.println("Entrada inteira: ");
                            int numInteira = scanner.nextInt();
                            System.out.println("Meia entrada: ");
                            int numMeiaEntrada = scanner.nextInt();
                                    filmes[i].registrarExibicao(numInteira, numMeiaEntrada);
                                }
                                catch(InputMismatchException e){
                                    System.out.println("Resposta inválida em relação ao que se propôe, por favor tente novamente");
                                    break;
                                }
                                isCoerente = true;
                            }
                            while(!isCoerente);
                            break;
                        }
                    }
                    break;
                case "d":
                    for(int i = 0; i < 4; i++){
                        if(filmes[i] != null){
                            System.out.println("Filme: "+filmes[i].getTitulo());
                            filmes[i].getBilheteria();
                        }
                    }
                    break;
                case "e":
                    for(int i = 0; i < 4; i++){
                        if(filmes[i].getPercentualMeiaEntrada()> 50.0){
                            System.out.println("Filme: "+ filmes[i].getTitulo() + filmes[i].isAudioOriginal() + filmes[i].isLegendado());
                        }
                }
                    break;
                case "f":
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        while(!opcao.equals("f"));
    }
}
