public class Filme{
    private final int qtdsala = 1;
    private final int pessoas = 200;
    private String titulo;
    private int duracaoFilme;
    private boolean audioOriginal;
    private boolean legenda;
    private double precoInteira;
    private double precoMeiaEntrada;
    private int qtdEntradaInteira;
    private int qtdMeiaEntrada;
    private int totalPublico;
    

    public Filme(String titulo, int duracaoFilme, boolean audioOriginal, boolean legenda, double precoInteira) throws Exception{
        this.titulo = titulo;
        this.duracaoFilme = duracaoFilme;
        this.audioOriginal = audioOriginal;
        this.legenda = legenda;
        this.precoInteira = precoInteira;
        if (duracaoFilme <= 0 || precoInteira <= 0) {
            throw new Exception("Duração do filme e preço de entrada inteira devem ser valores positivos.");
        }
    }

    public void registrarExibicao(int qtdEntradaInteira, int qtdMeiaEntrada) throws Exception{
        this.qtdEntradaInteira = qtdEntradaInteira; 
        this.qtdMeiaEntrada = qtdMeiaEntrada;
        totalPublico = qtdEntradaInteira + qtdMeiaEntrada;
        if(totalPublico > pessoas){
           throw new Exception("Quantidade de expectadores ultrapassa o limite da sala.");
        }
        else
        System.out.println(qtdEntradaInteira+ " pessoas pagaram o ingresso inteiro, "+ qtdMeiaEntrada+" pagaram meia entrada");
    }

    public double  getBilheteria(){
        precoMeiaEntrada = precoInteira/2;
        double bilheteria = (qtdEntradaInteira * precoInteira)+(qtdMeiaEntrada * precoMeiaEntrada);
        System.out.println("Arrecadamento em reais: "+bilheteria);
        return bilheteria;
    }

    public double getPercentualMeiaEntrada(){
        double percentualMeiaEntrada = ((double) qtdMeiaEntrada/totalPublico) * 100;
        System.out.println(percentualMeiaEntrada + "% dos expectadores pagaram meia entrada.");
        return percentualMeiaEntrada;
    }
    public boolean getLegenda(){
        return legenda;
    }

    public boolean getAudioOriginal(){
        return audioOriginal;
    }

    public String getTitulo(){
        return titulo;
    }

    public int getDuracao(){
        return duracaoFilme;
    }

    public String isLegendado(){
        String isLegendado = " ";
        if(legenda == true)
            isLegendado = " com legenda";
        
        else
            isLegendado = " sem legenda";
            return isLegendado;
    }

    public String isAudioOriginal(){
        String isAudioOriginal = " ";
        if(audioOriginal == true)
        isAudioOriginal = " Áudio Original";
        else
        isAudioOriginal = " Áudio não Original";
        return isAudioOriginal;
    }
}