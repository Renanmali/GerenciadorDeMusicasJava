package Usuario;
import java.util.ArrayList;

import Persistencia.PersistenciaUsuario;

public class BancoUsuarios {
    private int nextId = 0;
    private String nome_banco;
    // Criando o banco de usuários  
    private ArrayList<Usuario> geral = new ArrayList<Usuario>();

    public BancoUsuarios(String nome_banco){
        this.nome_banco = nome_banco;
    }



    public void saveUsuarios(){
        PersistenciaUsuario.saveUsuarios(geral);

    }

    public void readUsuarios(){
        geral = PersistenciaUsuario.readUsuarios();
        
    }

    public void addUsuario(Usuario usuario){
        
        // Passar após a variável o ++, ele usa a váriavel e depois incrementa o ++ //
        
        usuario.setId(nextId++);
        geral.add(usuario.getId(), usuario);

    }

    public void removeUsuario(int id){
        
        geral.set(id, null);

    }

    public Usuario getById(int id){
        return geral.get(id);
    }

}


