package basic;

// vì lớp InvalidDataException là lớp mô tả lỗi sai nên phải là lớp con của lớp Exception
public class InvalidDataException extends Exception {

    public InvalidDataException() {
        super("Loi sai nhap lieu !!!");
    }
    public InvalidDataException(String thongbaoLoi){
        super(thongbaoLoi);
    }
}
