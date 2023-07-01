package Usuario;

import java.io.Serializable;
import java.util.ArrayList;

import Musicas.Playlist;

public abstract class Usuario implements Serializable {
    private String nome;
    private int id;
    private String login;
    private String senha;

    private ArrayList<Playlist> playlists = new ArrayList<Playlist>();

    
    public ArrayList<Playlist> getPlaylists(){
        return  this.playlists;
    }
    
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    


}
