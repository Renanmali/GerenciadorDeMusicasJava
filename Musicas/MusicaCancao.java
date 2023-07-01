package Musicas;
public class MusicaCancao extends Musica{
    private String letra;

    public MusicaCancao(String titulo, String data, String autores, String genero, int duracao, String letra){
        this.setAutores(autores);
        this.setData(data);
        this.setDuracao(duracao);
        this.setGenero(genero);
        this.setLetra(letra);
        this.setTitulo(titulo);
    }

    public String getLetra(){
        return letra;
    }

    public void setLetra(String letra){
        this.letra = letra;
    }
   
    // @Override
    // public String toString(){
    //     int minutos = this.getDuracao()/60;
    //     int segundos = this.getDuracao()%60;
        
    //     return this.getTitulo() + " : " + this.getAutores() + " : " + minutos + ":" + String.format("%02d", segundos);

    // }
}
