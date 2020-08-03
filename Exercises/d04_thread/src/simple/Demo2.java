package simple;
// thử nghiệm hoạt động của thread DemM1 và DemM2
public class Demo2 {

    public static void main(String[] args) {
        
        // khởi tạo thread M1
        Thread t1 = new DemM1();
        t1.setName("Huy"); // đặt tên cho t1
        
        // khởi tạo thread M2
        // Thread t2 = new DemM2(); // không phải lớp con của Thread nên không dùng như vầy được
        Thread t2 = new Thread(new DemM2());
        t2.setName("Thu"); // đặt tên cho t2
        
        // ra lệnh cho t1 và t2 chạy
        t1.start(); //t1.run()
        t2.start(); //t2.run()
        
        int dem = Thread.activeCount();
        System.out.printf("So luong thread dang hoat dong: %d\n", dem);
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        System.out.println("\n ***** MAIN THREAD FINISHED !!! *****");

        
    }
}
