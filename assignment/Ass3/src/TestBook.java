import java.util.Scanner;

public class TestBook {

    public void menu() {
        Scanner in = new Scanner(System.in);
        BookCatalog c = new BookCatalog();
        do {
            System.out.println("*-*-*-MENU-*-*-*");
            System.out.println("1. Them sach moi vao he thong.");
            System.out.println("2. Xoa sach co ma so theo yeu cau.");
            System.out.println("3. Hien thi tat ca sach co trong thu vien");
            System.out.println("4. Tim kien sach theo ten");
            System.out.println("5. Ghi file.");
            System.out.println("6. Thoat");
            System.out.print("\tChon chuc nang [1-6]: ");
            String op = in.nextLine().trim();
            switch (op) {
                case "1":
                    c.add();
                    break;
                case "2":
                    System.out.print("Nhap ID cua ten sach muon xoa: ");
                    String bkID = in.nextLine().trim();
                    c.remove(bkID);
                    break;
                case "3":
                    c.display();
                    break;
                case "4":
                    System.out.print("Nhap ten sach muon tim kiem:");
                    String auname = in.nextLine().trim();
                    c.display(auname);
                    break;
                case "5":
                    c.saveFile();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Chon sai chuc nang !!! chon lai!!.");
                    break;
            }

        } while (true);
    }

    public static void main(String[] args) {
        TestBook c = new TestBook();
        c.menu();
    }

}
