package simple;
// đơn giản là in ra một chuỗi số nguyên 0-9
import java.util.logging.Level;
import java.util.logging.Logger;

public class DemM1 extends Thread{

    // hàm run() sẽ chứa các câu lệnh mà thread phải thực hiên
    @Override
    public void run() {
        String ten = Thread.currentThread().getName();
        System.out.println("Ten cua Thread: "+ten);
        System.out.println(">>> 10 số nguyên đầu tiên theo thứ tự tăng dần (0-9): ");
        for (int i = 0; i < 10; i++) {
            System.out.printf("\t %s :%3d \n",ten,i);
            try {
                Thread.sleep(500);//nghỉ 500ms
            } catch (InterruptedException ex) {
                System.out.println("Loi: "+ex.getMessage());
            }
        }
    }
    
}
