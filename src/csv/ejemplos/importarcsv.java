package csv.ejemplos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;

import dominio.usuario;

public class importarcsv{
	
	 public static void main(String[] args) {
	try {
        
        List<usuario> usuarios = new ArrayList<usuario>();
         
        CsvReader usuarios_import = new CsvReader("C:\\Users\\Cash America\\Desktop\\nuevo\\usuarios_import.csv");
        usuarios_import.readHeaders();
         
        while (usuarios_import.readRecord())
        {
            String codigo = usuarios_import.get(0);
            String nombres = usuarios_import.get(1);
            String apellidos = usuarios_import.get("Apellidos");
            String correo = usuarios_import.get("Correo");
             
            usuarios.add(new usuario(codigo, nombres, apellidos, correo));    
        }
         
        usuarios_import.close();
         
        for(usuario us : usuarios){
         
            System.out.println(us.getCodigo() + " : " + us.getNombres() + " "
            + us.getApellidos() + " - " + us.getCorreo());
        }
         
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}