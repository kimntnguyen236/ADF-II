/*
 Đây là lớp thông báo lỗi sai nhập dữ liệu của ứng dụng
- Vì là lớp thông báo lỗi nên là lớp con của exception
 */

// hướng đối tượng - tính chất quan trọng là kế thừa
package basic;

public class MyException extends Exception{

    // hàm dựng không tham số 
    public MyException() {
        super("Loi sai nhap du lieu !!!");
    }
    // hàm dựng có tham số - là một chuỗi thông báo lỗi cụ thể
    public MyException(String tb){
        super(tb); // super đại diện cho đối tượng cha của MyException là lớp Exception
    }
}
