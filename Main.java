import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Musicas.*;
import Persistencia.PersistenciaUsuario;
import Usuario.BancoUsuarios;
import Usuario.UsuarioAdmin;
import Usuario.UsuarioComum;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // carregaUsuarios();
        // Criando o banco de músicas //
        // BancoMusicas bancoMusicas = new BancoMusicas();
        // BancoMusicas.addMusica(new MusicaCancao("Ok", "21/06/2023", "Teto", "rap",
        // 300, "Olá"));
        // BancoMusicas.addMusica(new MusicaInstrumental("Rio de Janeiro", "23/06/2023",
        // "Xamã", "rap", 400, "Sol"));
        // BancoMusicas.addMusica(new MusicaCancao("real", "21/06/2023", "Teto", "rap",
        // 300, "Olá"));
        // System.out.println(BancoMusicas.getById(0).getData());
        // System.out.println(BancoMusicas.getById(1));
        // UsuarioComum user = new UsuarioComum("renan", "renanmali", "151021Al");
        // UsuarioAdmin userAdm = new UsuarioAdmin("Pedro", "Pierrot", "8238120");
        // BancoUsuarios bancoUsuarios = new BancoUsuarios("Spotify");
        // bancoMusicas.saveMusicas();
        // bancoMusicas.readMusicas();
        // System.out.println(BancoMusicas.getById(0).getTitulo());
        // System.out.println(BancoMusicas.getById(1).getData());
        // bancoUsuarios.addUsuario(user);
        // bancoUsuarios.addUsuario(userAdm);
        // user.createPlaylist("Romance");
        // user.addMusicaToPlaylist(0, 0);
        // bancoUsuarios.saveUsuarios();
        // bancoUsuarios.readUsuarios();
        // System.out.println(bancoUsuarios.getById(1).getLogin());
        // System.out.println(bancoUsuarios.getById(0).getNome());
        // System.out.println(BancoMusicas.getById(0));

        BancoUsuarios bancoUsuarios = new BancoUsuarios("Spotify");
        System.out.println("O que você quer fazer?");
        System.out.println("1- Login | 2- Criar uma conta");
        int inicio = teclado.nextInt();
        if (inicio == 1) {
            System.out.println("Qual tipo de usuário é você? ");
            System.out.println("3- Administrador | 4- Comum");
            int entrada = teclado.nextInt();
            if (entrada == 3) {
                System.out.println("Digite seu login");
                String login = teclado.next();
                System.out.println("Digite a sua senha");
                String senha = teclado.next();
                bancoUsuarios.readUsuarios();
                String comparaLogin = bancoUsuarios.getById(0).getLogin();
                String comparaSenha = bancoUsuarios.getById(0).getSenha();
                if (login.equals(comparaLogin) && senha.equals(comparaSenha)) {
                    System.out.println("Selecione o que deseja acessar: ");
                    System.out.println("1- Músicas | 2- Usuários");
                    int entrar = teclado.nextInt();
                    if (entrar == 1) {
                        System.out.println("Selecione o que deseja fazer: ");
                        System.out.println("1- Adicionar Música | 2- Remover Música | 3- Editar Música");
                    }
                    else if(entrar == 2){
                        System.out.println("1- Adicionar Usuário | 2- Remover Usuário");
                    }
                } else {
                    System.out.println("Login e senha não são correspondentes");
                }
            } else if (entrada == 4) {
                System.out.println("Digite seu login");
                String login = teclado.next();
                System.out.println("Digite a sua senha");
                String senha = teclado.next();
                bancoUsuarios.readUsuarios();
                String comparaLogin = bancoUsuarios.getById(0).getLogin();
                String comparaSenha = bancoUsuarios.getById(0).getSenha();
                if (login.equals(comparaLogin) && senha.equals(comparaSenha)) {
                    System.out.println("Selecione o que deseja acessar");
                } else {
                    System.out.println("Login e senha não são correspondentes");
                }
            }

        } else if (inicio == 2) {
            System.out.println("Qual tipo de usuário quer adicionar?");
            System.out.println("3- Administrador | 4- Comum");
            int usuario = teclado.nextInt();
            if (usuario == 3) {
                System.out.printf("Digite o nome do usuário: \n");
                String nome = teclado.next();
                System.out.printf("Digite o login do usuário: \n");
                String login = teclado.next();
                System.out.printf("Digite a senha do usuário: \n");
                String senha = teclado.next();
                UsuarioAdmin userAdm = new UsuarioAdmin(nome, login, senha);
                bancoUsuarios.readUsuarios();
                bancoUsuarios.addUsuario(userAdm);
                bancoUsuarios.saveUsuarios();
                System.out.println("Cadastro concluído com sucesso, retorne a página inicial e se divirta ! \n");
            } else if (usuario == 4) {
                System.out.printf("Digite o nome do usuário: \n");
                String nome = teclado.next();
                System.out.printf("Digite o login do usuário: \n");
                String login = teclado.next();
                System.out.printf("Digite a senha do usuário: \n");
                String senha = teclado.next();
                UsuarioComum userComum = new UsuarioComum(nome, login, senha);
                bancoUsuarios.addUsuario(userComum);
                bancoUsuarios.saveUsuarios();
                System.out.println("Cadastro concluído com sucesso, retorne a página inicial e se divirta ! \n");
            } else {
                System.out.println("ERROR! Digite um comando válido.");
                System.out.println("Sessão finalizada");
            }

        } else {
            System.out.println("ERROR! Digite um comando válido.");
        }
    }

}
