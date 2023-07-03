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
        // UsuarioAdmin userAdm = new UsuarioAdmin("Mauricio", "Jason", "1973");
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

        
        
        // Inicializando o Banco de Usuários e o Banco de Músicas // 
        



        BancoMusicas bancoMusicas = new BancoMusicas();
        BancoUsuarios bancoUsuarios = new BancoUsuarios("Armazena");
        
        //  Inicializando o Terminal para o usuário //
        
        System.out.println("O que você quer fazer?");
        System.out.println("1- Login | 2- Criar uma conta");
        int inicio = teclado.nextInt();

        // Comparando a opção do usuário com as opções possíveis // 

        // 1 - Usuário quer fazer o login // 

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

                // Loop para verificar os dados Login e senha do usuário // 

                for (int i = 0; i < bancoUsuarios.getGeral().size(); i++){

                    String comparaLogin = bancoUsuarios.getById(i).getLogin();
                    String comparaSenha = bancoUsuarios.getById(i).getSenha();
                    if (login.equals(comparaLogin) && senha.equals(comparaSenha)){
                        int verifica = 0;
                        do {
                           


                            System.out.println("Selecione o que deseja acessar: ");
                            System.out.println("1- Músicas | 2- Usuários");
                            int entrar = teclado.nextInt();
                            if (entrar == 1) {
                                System.out.println("Selecione o que deseja fazer: ");
                                System.out.println("1- Adicionar Música | 2- Remover Música | 3- Editar Música");
                                int entrarMus = teclado.nextInt();
                                if(entrarMus == 1){
                                    
                                    System.out.println("Qual é o tipo da música? ");
                                    System.out.println("1- Música Canção | 2- Música Instrumental ");
                                    
                                    int tipoMusica = teclado.nextInt();
                                    if(tipoMusica == 1){
                                        
                                        
                                        
                                        System.out.printf("Qual o título da música? ") ; 
                                        String titulo = teclado.next();
                                        System.out.printf("Qual a data de criação da música? ");
                                        String data = teclado.next();
                                        System.out.printf("Quais são os autores da música? ");
                                        String autores = teclado.next();
                                        System.out.printf("Qual o gênero da música? ");
                                        String genero = teclado.next();
                                        System.out.printf("Qual a duração da música? Em segundos");
                                        int duracao = teclado.nextInt();
                                        System.out.println("Qual a letra da música?  ");
                                        String letra = teclado.next();

                                        bancoMusicas.readMusicas();
                                        BancoMusicas.addMusica(new MusicaCancao(titulo, data, autores, genero, duracao, letra));
                                        bancoMusicas.saveMusicas();



                                        break;
                                    }
                                    else if(tipoMusica == 2){

                                        System.out.printf("Qual o título da música? ") ; 
                                        String titulo = teclado.next();
                                        System.out.printf("Qual a data de criação da música? ");
                                        String data = teclado.next();
                                        System.out.printf("Quais são os autores da música? ");
                                        String autores = teclado.next();
                                        System.out.printf("Qual o gênero da música? ");
                                        String genero = teclado.next();
                                        System.out.printf("Qual a duração da música? Em segundos");
                                        int duracao = teclado.nextInt();
                                        System.out.println("Qual a partitura da música?  ");
                                        String partitura = teclado.next();

                                        
                                        bancoMusicas.readMusicas();
                                        BancoMusicas.addMusica(new MusicaInstrumental(titulo, data, autores, genero, duracao, partitura));
                                        bancoMusicas.saveMusicas();

                                        break;






                                    }
                                    else{System.out.println("ERRO! Escreva um comando válido");}




                                    
                                    
                                    
                                    
                                    verifica = -1;
                                }
                                else if(entrarMus == 2){

                                    System.out.println("Qual música vocẽ deseja remover? ");
                                }
                                else if(entrarMus == 3){}
                                else{System.out.println("Erro! Digite um comando válido.");}
                            }
                            else if(entrar == 2){
                                System.out.println("1- Adicionar Usuário | 2- Remover Usuário");
                            }




                        }while(verifica != -1);
                    } 
                }
                System.out.println("Login e senha não correspondentes");
            }
            else if (entrada == 4) {
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

                       
        } 
 
        
        
        
        
        // 2 - Usuário deseja criar uma nova conta // 
        
        
        else if (inicio == 2) {
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
                bancoUsuarios.readUsuarios();
                bancoUsuarios.addUsuario(userComum);
                bancoUsuarios.saveUsuarios();
                System.out.println("Cadastro concluído com sucesso, retorne a página inicial e se divirta ! \n");
            } else {
                System.out.println("ERROR! Digite um comando válido.");
                System.out.println("Sessão finalizada");
            }

        }

// ** - Usuário selecionou uma opção errada //
else{System.out.println("ERROR! Digite um comando válido.");}}

}
