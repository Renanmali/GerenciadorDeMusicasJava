package Usuario;
import Musicas.Playlist;

public class UsuarioComum extends Usuario {

    public UsuarioComum(String nome, String login, String senha){
        this.setNome(nome);
        this.setLogin(login);
        this.setSenha(senha);
    }


    public boolean createPlaylist(String nome){
        Playlist playlist = new Playlist(nome);
        return getPlaylists().add(playlist);
    }


    public boolean addMusicaToPlaylist(int id, int index){
       return getPlaylists().get(index).addMusica(id);
    }

    public boolean removeMusicaToPlaylist(int id, int index){
        return getPlaylists().get(index).removeMusica(id);
    }

    public void removePlaylist(int index){
        getPlaylists().remove(index);
    }

    public Playlist getPlaylist(int index){
        return getPlaylists().get(index);
    }

}
