package csv.ejemplos;
 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import com.csvreader.CsvWriter;
 
import dominio.usuario;
 
public class exportarcsv {
 
    public static void main(String[] args) {
     
        List<usuario> usuarios = new ArrayList<usuario>();
         
        usuarios.add(new usuario("987","juan","87345","10 norte 342"));
        usuarios.add(new usuario("876","pedro","43649","8 oriente 342"));
        usuarios.add(new usuario("123","jorge","03342","av. libertad 23"));
        usuarios.add(new usuario("69","vicente","61560","valencia no.183"));
        usuarios.add(new usuario("18","lorenzo","06490","sol no.18"));
        usuarios.add(new usuario("19","lucia","06480","luna no.8"));
        
        String outputFile = "C:\\Users\\Cash America\\Desktop\\nuevo\\user_import.csv";
        boolean alreadyExists = new File(outputFile).exists();
         
        if(alreadyExists){
            File ficheroUsuarios = new File(outputFile);
            ficheroUsuarios.delete();
        }        
         
        try {
         
            CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
           
            csvOutput.endRecord();
             
            for(usuario us : usuarios){
                 
                csvOutput.write(us.getCodigo());
                csvOutput.write(us.getNombres());
                csvOutput.write(us.getApellidos());
                csvOutput.write(us.getCorreo());
                csvOutput.endRecord();                   
            }
             
            csvOutput.close();
         
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
