package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    ArrayList<Book> pList = new ArrayList<Book>();

    public static void main(String[] args) {
        Library o = new Library();
        o.menu();
    }

    public void menu() {
        Library o = new Library();
        while (true) {
            Scanner sc = new Scanner(System.in);
            String op = "";
            System.out.println("\n ===== MENU =====");
            System.out.println("1. Create a new Book");
            System.out.println("2. Publish the entire list");
            System.out.println("3. Search and delete the Book");
            System.out.println("4. Exit");
            System.out.print("Select an option [1-4]: ");
            op = sc.nextLine().trim();

            switch (op) {
                case "1":
                    o.addBook();
                    break;
                case "2":
                    o.viewAll();
                    break;
                case "3":
                    System.out.print("Input Book ID need to delete: ");
                    o.deleteBook(sc.nextLine().trim());
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Error!!! Please input agains");
            }
        }

    }

    public void addBook() {
        Book p=new Book();
        p.acceptBook();
        pList.add(p);
        
        if(LibraryDAO.Insert(p)>0){
            System.out.println("Added Successfully");
        }
        else{
            System.out.println("Error!!! ");
        }
    }

    public void viewAll() {
        List<Book> empList = LibraryDAO.getList();
        if (pList.isEmpty()) {
            System.out.println("System is blank !!");
            return;
        }
        System.out.println("\n>> Book Catalogue <<");
        empList.stream().forEach(System.out::println);
    }

    public void deleteBook(String s) {
        if (LibraryDAO.Delete(s) > 0) {
            System.out.println("Deleted Successfully with id " + s);
        } else {
            System.out.println("Error!!! Can not delete the book with id " + s);
    }
}
}
