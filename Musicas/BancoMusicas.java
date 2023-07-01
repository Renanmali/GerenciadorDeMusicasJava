package Musicas;
import java.util.ArrayList;

import Persistencia.PersistenciaMusicas;

public class BancoMusicas {
    private static int nextId = 0;

    // Criando o banco das músicas do catálogo 
    private static ArrayList<Musica> geral = new ArrayList<Musica>();

    public static void addMusica(Musica musica){
        
        // Passar após a variável o ++, ele usa a váriavel e depois incrementa o ++ //
        
        musica.setId(nextId++);
        geral.add(musica.getId(), musica);

    }


    public void saveMusicas(){
        PersistenciaMusicas.saveMusicas(geral);
    }

    public void readMusicas(){
        geral = PersistenciaMusicas.readMusicas();
    }

    public static void removeMusica(int id){
        
        geral.set(id, null);

    }

    public static Musica getById(int id){
        return geral.get(id);
    }

    public static int getByTitle(String titulo){
        for(Musica music : geral ){
            if(music.getTitulo().equals(titulo)){
                return music.getId();
            }
        }
        return -1;
    }
}

