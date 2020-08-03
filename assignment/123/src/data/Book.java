package data;

import java.util.Scanner;

public class Book {

    public int BookId, Edition;
    public String Title, Author;

    public Book() {
    }

    public Book(int BookId, int Edition, String Title, String Author) {
        this.BookId = BookId;
        this.Edition = Edition;
        this.Title = Title;
        this.Author = Author;
    }

    public void acceptBook() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Nhập tựa sách: ");
            Title = sc.nextLine().trim();
            if (Title.length() > 0) {
                break;
            }
            System.out.println("Tựa sách không được để trống ! ");
        }
        while (true) {
            System.out.print("Nhập tên tác giả: ");
            Author = sc.nextLine().trim();
            if (Author.length() > 0) {
                break;
            }
            System.out.println("Tên tác giả không được để trống ! ");
        }
        while (true) {
            try {
                System.out.print("Nhập phiên bản sách: ");
                Edition = Integer.parseInt(sc.nextLine().trim());
                if (Edition > 0) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Loi: " + e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%6d  %-20s  %-30s  %5d", BookId, Title, Author, Edition);
    }
}
