package data;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
a. Các fields dữ liệu:
i. String id, name, level
ii. int exp_years
b. Các contructors để khởi tạo giá trị ban đầu cho các field dữ liệu.
c. Method :
* void input() : nhập chi tiết bác sĩ và kiểm tra dữ liệu hợp lệ như sau :
- id : Dxx[xx], với x là ký số - từ 2 đến 4 ký số.
- name : ít nhất 2 ký tự chữ hoặc khoảng trắng.
- level : trình độ chuyên khoa: level 1, level 2, level 3 hoặc để trống.
- exp_years: số năm kinh nghiệm , từ 0 - 60
 String toString() : override method này để biểu diễn nội dung của 1 đối tượng bác sĩ dưới dạng chuỗi.
 */
public class Doctor {

    String id, name, level;
    int exp_years;

    public Doctor() {
    }

    public Doctor(String id, String name, String level, int exp_years) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.exp_years = exp_years;
    }

    void input() {
        Scanner sc = new Scanner(System.in);
        // id : Dxx[xx], với x là ký số - từ 2 đến 4 ký số.
        Pattern p = Pattern.compile("D\\d{2,4}"); // nếu nhiều kí tự thì đặt trong [DOC]\\d{2,4}
        Matcher m = null;
        while (true) {
            System.out.print("Nhap ma so bac si Dxx[xx]: ");
            id = sc.nextLine().trim();
            m = p.matcher(id);

            if (m.matches()) {
                // nhập đúng yêu cầu => thoát khỏi vòng lặp while
                break;
            }
            System.out.println(">>> ID không hợp lệ. Vui lòng nhập lại ! ");

        }//kết thúc while

        // name : ít nhất 2 ký tự chữ hoặc khoảng trắng.
        p = Pattern.compile("[a-z ]{2,}", Pattern.CASE_INSENSITIVE); // CASE_INSENSITIVE : không phân biệt chữ thường và chữ hoa <=> ("[a-zA-Z ]{2,}")
        m = null;
        while (true) {
            try {
                System.out.print("Nhap Name:");
                name = sc.nextLine().trim(); // => "   a   " => trim() => "a"
                m = p.matcher(name);
                if (m.matches()) {
                    break;
                } else {
                    throw new Exception("Name khong hop le: name phai co it nhat 2 ky tu chu or khoang trong.");
                }
            } catch (Exception e) {
                System.out.println("Loi:" + e.getMessage());
            }
        }

        // level : trình độ chuyên khoa: level 1, level 2hoặc để trống.
        p = Pattern.compile("level1|level2|Null", Pattern.CASE_INSENSITIVE);
        m = null;
        while (true) {
            System.out.print("Nhap trinh do chuyen khoa: ");
            level = sc.nextLine().trim();
            if (level.isEmpty()) {
                break;
            }

            try {
                m = p.matcher(level);
                if (m.matches()) {
                    break;
                } else {
                    throw new Exception("Trinh do chuyen khoa KO HOP LE. Phai 'level 1' hoac 'level 2', hoac null");
                }
            } catch (Exception e) {
                System.out.println("Loi:" + e.getMessage());
            }
        }//ket thuc vong lap WHILE 

        // exp_years: số năm kinh nghiệm , từ 0 - 60
        //try-catch thường áp dụng cho dạng số
        /* while (true) {
            try {
                System.out.print("Nhap so năm kinh nghiệm");
                exp_years = Integer.parseInt(sc.nextLine().trim());
                if (exp_years > 0 && exp_years < 60) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Loi: " + e.getMessage());
            }
        }// kết thúc while */
        // exp_years: số năm kinh nghiệm , từ 0 - 60 
        while (true) {
            try {
                System.out.print(">Nhap so nam kinh nghiem [0-60] : ");
                exp_years = Integer.parseInt(sc.nextLine().trim());
                if (exp_years >= 0 && exp_years <= 60) {
                    break;
                } else {
                    System.out.println("exp_years số năm kinh nghiệm , từ 0 - 60");
                }
            } catch (Exception e) {
                System.out.println("Loi : " + e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %d",id,name,level,exp_years); // level phải dùng biểu thức tam phân để xử lý
    }
    
}
