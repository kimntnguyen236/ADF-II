package simple;

public class Demo1 {

    public static void main(String[] args) {
        // lấy tên của main thread
       String ten = Thread.currentThread().getName();
        
        // đếm có bao nhiêu thread đang chạy trong chương trình/ ứng dụng Demo1
        int dem = Thread.activeCount();
        
        System.out.printf("Ten cua main thread: %s \n",ten);
        System.out.printf("So luong thread dang hoat dong: %d \n",dem);
        
        m1();m2();
    }
    
    static void m1(){
        System.out.println(">>> 10 số nguyên đầu tiên theo thứ tự tăng dần (0-9): ");
        for (int i = 0; i < 10; i++) {
            System.out.printf("\t M1 :%3d \n",i);
        }
    }
    static void m2(){
        System.out.println(">>> 10 số nguyên đầu tiên theo thứ tự giảm dần (9-0): ");
        for (int i = 9; i >= 0; i--) {
            System.out.printf("\t\t M2 :%3d \n",i);
        }
    }
}
