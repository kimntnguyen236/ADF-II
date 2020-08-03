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
            System.out.print("Input Title: ");
            Title = sc.nextLine().trim();
            if (Title.length() > 0) {
                break;
            }
            System.out.println("Title is not blank ! ");
        }
        while (true) {
            System.out.print("Input Author: ");
            Author = sc.nextLine().trim();
            if (Author.length() > 0) {
                break;
            }
            System.out.println("Author is not blank ! ");
        }
        while (true) {
            try {
                System.out.print("Input Edition: ");
                Edition = Integer.parseInt(sc.nextLine().trim());
                if (Edition > 0) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%5d  %-15s  %-15s  %5d", BookId, Title, Author, Edition);
    }
}
