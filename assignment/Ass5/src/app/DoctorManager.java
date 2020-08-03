/*
a. Các fields dữ liệu:
    i. TreeMap<String,Doctor> doctorList để lưu danh sách bác sĩ.
    ii. String fname chứa tên file lưu dữ liệu các bác sĩ.
b. Default contructor (hàm dựng mặc định) :
    i. khởi tạo field doctorList .
    ii. Gọi method readFile() để đọc dữ liệu từ file và khởi tạo cho doctorList.
c. void add() : thêm 1 bác sĩ mới vô danh sách.
d. void display() : In toàn bộ danh sách bác sĩ ra màn hình.
d. void display(String id) : Tìm bác sĩ có mã số id, và in thông tin chi tiết của bs đó ra màn hình.
Nếu ko tìm thấy, in thông báo lỗi.
e. void readFile() : Đọc file có tên chứa trong field ‘fname’ (nếu có) và fill vào danh sách bác sĩ.
HD : sử dụng lớp File, ObjectInputStream.
f. void saveFile() : Ghi danh sách bác sĩ vô file có tên chứa trong field ‘fname’ HD : sử dụng lớp File, ObjectOutputStream.
g. hàm main(): chứa menu gọi các chức năng trên
 */
package app;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoctorManager {

    public Map<String, Doctor> doctorList;
    public String fname;

    public DoctorManager() {
        // khởi tạo field DoctorList
        doctorList = new TreeMap<>();
        fname = "bacsi.data";
        readFile();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoctorManager o = new DoctorManager();
        String op = "";
        while (true) {            
            System.out.println("\n ==== MENU ====");
            System.out.println("1. Thêm bác sĩ");
            System.out.println("2. In danh sách bác sĩ");
            System.out.println("3. Tìm kiếm bác sĩ theo mã số ");
            System.out.println("4. Ghi File");
            System.out.println("5. Exit");
            System.out.print("Chọn [1-5]: ");
            op = sc.nextLine().trim();
            
            switch(op){
                case "1": o.add(); break;
                case "2": o.display(); break;
                case "3": System.out.print("Nhập mã số bác sĩ: "); o.display(sc.nextLine().trim()); break;
                case "4": o.writeFile(); break;
                case "5": return;
            }
        }
    }

    // hàm thêm 1 bác sĩ vô danh sách
    public void add() {
        Scanner sc = new Scanner(System.in);
        Doctor d = new Doctor();
        System.out.println("Nhập thông tin bác sĩ: ");
        while (true) {
            System.out.print(">> Nhập id: ");
            d.id = sc.nextLine().trim();

            // kiểm tra mã số mới nhập đã tồn tại trong ds doctorList chưa? 
            if (doctorList.containsKey(d.id) == false) {
                // true -> trùng -> nhập lại
                break;
            }
            System.out.println("Id đã tồn tại. Vui lòng nhập id khác !");
        }

        System.out.print(">> Nhập name: ");
        d.name = sc.nextLine().trim();

        System.out.print(">> nhập chuyên khoa: ");
        d.specialization = sc.nextLine().trim();

        while (true) {
            try {
                System.out.print(">> Nhập số giờ làm việc trong ngày: ");
                d.availHours = Integer.parseInt(sc.nextLine().trim());
                break; // thoát khỏi vòng lặp
            } catch (Exception e) {
                System.out.println("Loi sai: " + e.getMessage());
            }
        }
        // đưa đối tượng bác sĩ mới nhập thành công vô Map = hàm put(K,V)
        doctorList.put(d.id, d);
        System.out.println(">>> Thêm bác sĩ mới thành công");

    }

    // hàm in toàn bộ danh sách bác sĩ ra màn hình
    public void display() {
        // kiểm tra ds có dữ liệu hay không
        if (doctorList.isEmpty()) {
            System.out.println(">>> HT chưa có dữ liệu ! ");
            return; // kết thúc hàm
        }

        System.out.println(">>> Danh sách bác sĩ <<<");
        // MAP [Key , Values]
        // Key đang chứa mã bác sĩ
        // values đang chứa đối tượng bác sĩ

        // Lấy dữ liệu của cột value trong danh sách (ds đối tượng bs) : doctorList.values
        // lấy ds này thành 1 luồng : stream()
        // lấy từng phần tử trong luồng này, xuất lên màn hình: .forEach(item -> System.out.println(item)); 
        doctorList.values().stream().forEach(System.out::println); // viết rút gọn (method reference)
// lap trinh co dien - truyen thong : vong lap
// lap trinh moi, hien dai : stream
    }

    // hàm tìm và in ra thông tin bác sĩ theo tên
    public void display(String maso) {
        // kiểm tra ds có dữ liệu hay không
        if (doctorList.isEmpty()) {
            System.out.println(">>> HT chưa có dữ liệu ! ");
            return; // kết thúc hàm
        }
        if (doctorList.containsKey(maso)) {
            // tìm thấy mã số trong cột key rồi -> lấy đối tượng bác sĩ ở cột value ra
            Doctor d = doctorList.get(maso);
            
            // in thông tin của bs ra màn hình
            System.out.println("Thong tin bac si: "+d);
        }
        else{
            System.out.println(">>> Không tìm thấy bác sĩ có mã số : "+ maso);
        }
    }
    
    // ghi danh sách bác sĩ vô tập tin bacsi.data dưới dạng OBJECT (nhị phân)
    public void writeFile(){
        try {
            //open file để ghi dữ liệu
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fname));
            
            // ghi dữ liệu : ghi đối tượng doctorList
            os.writeObject(doctorList);
            
            // đóng file -> không đóng k lưu dữ liệu trên máy
            os.close();
        } catch (Exception ex) { // Exception là lỗi lớn nhất
            ex.printStackTrace();
        }
    }
    
    // đọc file bacsi.data để lấy dữ liệu trong file này đưa vô ds doctorList để làm việc
    private void readFile() {
        try {
             File f = new File(fname);
            if(f.exists() == false){
                return;
            }
        
            //open file de doc du lieu
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(fname));
            
            //doc du lieu trong tap bacsi -> danh sach doctorList
            doctorList = (Map<String, Doctor>) is.readObject();
            
            //dong file
            is.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
