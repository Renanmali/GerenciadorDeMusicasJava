package Usuario;
import Musicas.BancoMusicas;
import Musicas.Musica;
import Musicas.MusicaCancao;
import Musicas.MusicaInstrumental;

public class UsuarioAdmin extends Usuario{ 
    public UsuarioAdmin(String nome, String login, String senha){
        this.setNome(nome);
        this.setLogin(login);
        this.setSenha(senha);
    }

    public void addMusicaToBanco(Musica musica){
        BancoMusicas.addMusica(musica);
    }

    public void removeMusicaFromBanco(int id){
        BancoMusicas.removeMusica(id);
    }
    

    // Retorna o objeto música do banco
    public Musica getMusicaFromBanco(String titulo){
        return BancoMusicas.getById(BancoMusicas.getByTitle(titulo));
    }

    // Edita as músicas do banco de músicas
    public void editMusica(MusicaCancao musica, String titulo, int duracao, String autores, String data, String genero, String letra){
        if(titulo != null){
            musica.setTitulo(titulo);
        }
        if(duracao > 0){
            musica.setDuracao(duracao);
        }
        if(autores != null){
            musica.setAutores(autores);
        }
        if(data != null){
            musica.setData(data);
        }
        if(genero != null){
            musica.setGenero(genero);
        }
        if(letra != null){
            musica.setLetra(letra);
        }

    }
    public void editMusica(MusicaInstrumental musica, String titulo, int duracao, String autores, String data, String genero, String partitura){
        if(titulo != null){
            musica.setTitulo(titulo);
        }
        if(duracao > 0){
            musica.setDuracao(duracao);
        }
        if(autores != null){
            musica.setAutores(autores);
        }
        if(data != null){
            musica.setData(data);
        }
        if(genero != null){
            musica.setGenero(genero);
        }
        if(partitura != null){
            musica.setPartitura(partitura);
        }
    }




    public void addUsuarioToBancoUsuario(Usuario usuario, BancoUsuarios banco){
        banco.addUsuario(usuario);
    }

     public void removeUsuarioFromBancoUsuario(int id, BancoUsuarios banco){
        banco.removeUsuario(id);
    }

    public Usuario getUsuarioFromBancoUsuario(int id, BancoUsuarios banco){
        return banco.getById(id);
    }



}
