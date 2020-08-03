/*
- Hoạt động như 1 thread - đơn giản là in ra 1 chuỗi số nguyên 9-0
 */
package simple;

public class DemM2 implements Runnable{

    @Override
    public void run() {
        String ten = Thread.currentThread().getName();
        System.out.println("Ten cua Thread: "+ten);
        System.out.println(">>> 10 số nguyên đầu tiên theo thứ tự giảm dần (9-0): ");
        for (int i = 9; i >= 0; i--) {
            System.out.printf("\t\t %s :%3d \n",ten,i);
            try {
                Thread.sleep(300);//nghỉ 500ms
            } catch (InterruptedException ex) {
                System.out.println("Loi: "+ex.getMessage());
            }
        }
    }
    
}
