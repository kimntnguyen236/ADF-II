/*
    a. Các fields dữ liệu:
    int max, next để lưu kích thước mảng, và sô lượng khách hàng lưu trữ trong hệ thống.
    Customer[] cList để lưu danh sách khách hàng.
    c. Method :
        1. void add () : thêm 1 khách hàng vô danh sách cList.
        2. void displayAll() : In toàn bộ danh sách khách hàng ra màn hình.
        3. void searchByName(String name) : Tìm và in ra ds các khách hàng có tên chứa trong đối số name
 */
package basic;

public class CustomerList {
    int max = 10, next = 0;
    Customer[] cList = new Customer[max];
    
    public void add(){
        if (next==max) {
            System.out.println("HT het bo nho luu tru. Tu choi thêm mới !!! ");
        } else {
            Customer c = new Customer();
            c.input();
            
            // kiểm tra trùng ID
            for (int i = 0; i < next; i++) {
                if (cList[i].id.equals(c.id)) {
                    System.out.println("ID da ton tai. Khong the them moi !!!");
return;
                }
            }
            cList[next++]=c;
        }
    }
    
    public void displayAll(){
        if (next==0) {
            System.out.println("HT không có dữ liệu. Vui lòng thêm mới ! ");
        } else {
            for (int i = 0; i < next; i++) {
                System.out.println(cList[i]);
            }
        }
    }
    
    public void searchByName(String Cname){
        if (next==0) {
            System.out.println("Danh sach trong !!! ");
            return;
        }
            int cnt = 0;
            for (int i = 0; i < next; i++) {
                if (cList[i].name.toLowerCase().contains(Cname)) {
                    System.out.println(cList[i]);
                    cnt++;
                }
            }
            if (cnt==0) {
                System.out.println("Khong tim thay khách hàng có tên "+Cname);
            }
    }
}
