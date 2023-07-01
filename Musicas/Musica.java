package Musicas;

import java.io.Serializable;

public abstract class Musica implements Serializable{
    private int id;
    private String titulo;
    private int duracao;
    private String autores;
    private String data;
    private String genero;


    


    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;

    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public int getDuracao(){
        return duracao;
    }

    public void setDuracao(int duracao){
        this.duracao = duracao;
    }

    public String getAutores(){
        return autores;
    }

    public void setAutores(String autores){
        this.autores = autores;
    }

    public String getData(){
        return data;
    }

    public void setData(String data){
        this.data = data;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }



}
