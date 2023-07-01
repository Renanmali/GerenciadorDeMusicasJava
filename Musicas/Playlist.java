package Musicas;

import java.io.Serializable;
import java.util.ArrayList;


public class Playlist implements Serializable {
    private String nome;
    
    private ArrayList<Integer> lista = new ArrayList<Integer>();


    public Playlist(String nome){
        this.nome = nome;
    }


    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public ArrayList<Integer> getMusicas(){
        return this.lista;
    }

    public Boolean addMusica(int id){
        if(lista.contains(Integer.valueOf(id))){
            return false;
        }
        lista.add(Integer.valueOf(id));
        return true;
    }

    public Boolean removeMusica(int id){
        int index = lista.indexOf(Integer.valueOf(id));
        if(index == -1){
            return false;
        }
        lista.remove(index);
        return true;
    }

    public Boolean containsMusica(int id){
        int index = lista.indexOf(Integer.valueOf(id));
        return index != -1 ;
    }

    public Boolean containsMusica(String titulo){
        int id = BancoMusicas.getByTitle(titulo);
        return containsMusica(id);
    }

    @Override
    public String toString(){
        String output = getNome()+'\n';
        for(Integer id: lista){
            Musica musica = BancoMusicas.getById(id);
            output += '\t';
            output += musica.getTitulo();
            output += '\n';
        }
        return output;
    }

}
