package Musicas;
public class MusicaInstrumental extends Musica{
    private String partitura;

    public MusicaInstrumental(String titulo, String data, String autores, String genero, int duracao, String partitura){
        this.setAutores(autores);
        this.setData(data);
        this.setDuracao(duracao);
        this.setGenero(genero);
        this.setPartitura(partitura);
        this.setTitulo(titulo);
    }

    public String getPartitura(){
        return partitura;
    }

    public void setPartitura(String partitura){
        this.partitura = partitura;
    }
    
    // @Override
    // public String toString(){
    //     int minutos = this.getDuracao()/60;
    //     int segundos = this.getDuracao()%60;
        
    //     return this.getTitulo() + " : " + this.getAutores() + " : " + minutos + ":" + String.format("%02d", segundos);

    // }
}
