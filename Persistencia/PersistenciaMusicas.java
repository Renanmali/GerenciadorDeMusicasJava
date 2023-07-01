package Persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import Musicas.BancoMusicas;
import Musicas.Musica;

public class PersistenciaMusicas {
    private static String dir = "DadosMusicas/";

    public static void saveMusicas(List<Musica> musicas) {
        int i = 0;
        for (Musica musica : musicas) {
            if (musica != null) {
                    try (FileOutputStream fos = new FileOutputStream(dir + String.valueOf(musica.getId()));
                            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                        oos.writeObject(musica);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
            } else {
                try (FileOutputStream fos = new FileOutputStream(dir + i);
                        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                    oos.writeObject(null);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }

    public static ArrayList<Musica> readMusicas() {
        Path dir1 = FileSystems.getDefault().getPath(dir);
        ArrayList<Musica> lista = new ArrayList<Musica>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir1)) {
            while (lista.size() < new File(dir).list().length)
                lista.add(null);
            for (Path file : stream) {
                try (FileInputStream fis = new FileInputStream(dir + file.getFileName());
                        ObjectInputStream ois = new ObjectInputStream(fis)) {
                    Musica musica = (Musica) ois.readObject();
                    lista.set(Integer.valueOf(file.getFileName().toString()), musica);
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException | DirectoryIteratorException x) {
            System.err.println(x);
            return null;
        }
        System.out.println(lista);
        return lista;
    }

}
