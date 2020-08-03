package demo;

import java.util.Scanner;

public class Vidu1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap so thu 1: ");
        int a = Integer.parseInt(sc.nextLine().trim());
        System.out.print("nhap so thu 2: ");
        int b = Integer.parseInt(sc.nextLine().trim());
        
        Cong2So o1 = new Cong2So();
        Tru2So o2 = new Tru2So();
        
        o1.calculate(a, b);
        o2.calculate(a, b);
    }
}

class Cong2So implements ICasio {

    @Override
    public void calculate(int x, int y) {
        System.out.printf("%d + %d = %d \n", x, y, x + y);
    }
}

class Tru2So implements ICasio {

    @Override
    public void calculate(int x, int y) {
        System.out.printf("%d - %d = %d \n", x, y, x - y);
    }
}
