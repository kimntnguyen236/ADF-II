
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterOutputStream;

public class UnCompressFile2 {

    public static void main(String[] args) {
        String compressName = "danga.dft"; // KHÔNG ĐƯỢC ĐỂ TRONG THƯ MỤC SOURCE, nếu không sẽ bị lỗi
        String txtName = "baihat2.txt";
        
        try {
            java.nio.file.Path p = java.nio.file.Paths.get(compressName); 
            
            java.io.FileOutputStream fos = new FileOutputStream(txtName);
            java.util.zip.InflaterOutputStream os = new InflaterOutputStream(fos);  // Inflater : làm phồng lên/ giải nén dữ liệu, Deflater : làm xẹp xuống/nén dữ liệu -> giảm dung lượng dữ liệu
            os.write(java.nio.file.Files.readAllBytes(p));
            
            os.flush();
            os.close();
            System.out.println("FINSHED UNCOMPRESS FILE !");
            
        } catch (Exception ex) {
            System.out.println("Loi: " + ex.getMessage());
        }
        
        
        // chạy cái này thành công thì danga.adf -> baihat2.txt
    }

}
