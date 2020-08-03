/*
Vì lớp InvalidException là lớp mô tả lỗi sai nên phải là lớp con của lớp Exception
 */
public class InvalidException extends Exception{

    public InvalidException() {
        super("Loi sai nhap lieu !!!");
    }
    public InvalidException(String thongbaoLoi){
        super(thongbaoLoi);
    }
    
}
