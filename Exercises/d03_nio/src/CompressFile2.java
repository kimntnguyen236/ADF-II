// nén tập tin văn bản : danga.txt ->huy.zip
import java.io.FileOutputStream;
import java.util.*;
import java.util.zip.DeflaterOutputStream;
public class CompressFile2 {

    public static void main(String[] args) {
        String vb = "baihat2.txt";
        String nen = "huy.zip";
        try {
            java.nio.file.Path p = java.nio.file.Paths.get(vb);
            
            java.io.FileOutputStream fos = new FileOutputStream(nen);
            java.util.zip.DeflaterOutputStream dos = new DeflaterOutputStream(fos);
            
            dos.write(java.nio.file.Files.readAllBytes(p));
            
            dos.flush(); 
            dos.close();
            
            System.out.println("NEN FILE THANH CONG!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
