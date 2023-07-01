package Persistencia;

import java.io.*;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


import Usuario.Usuario;

public class PersistenciaUsuario {
    private static String dir = "DadosUsuarios/";

    public static void saveUsuarios(List<Usuario> usuarios) {
        int i = 0;
        for (Usuario usuario : usuarios) {
            if (usuario != null) {
                try (FileOutputStream fos = new FileOutputStream(dir + String.valueOf(usuario.getId()));
                        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                    oos.writeObject(usuario);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            else{
                try (FileOutputStream fos = new FileOutputStream(dir + i);
                        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                    oos.writeObject(null);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            i ++;
        }
    }

    public static ArrayList<Usuario> readUsuarios() {
        Path dir1 = FileSystems.getDefault().getPath(dir);
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir1)) {
            while (lista.size() < new File(dir).list().length)
                lista.add(null);
            for (Path file : stream) {
                try (FileInputStream fis = new FileInputStream(dir + file.getFileName());
                        ObjectInputStream ois = new ObjectInputStream(fis)) {
                    Usuario usuario = (Usuario) ois.readObject();
                    lista.set(Integer.valueOf(file.getFileName().toString()), usuario);
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
            return null;
        }
        return lista;
    }
}
