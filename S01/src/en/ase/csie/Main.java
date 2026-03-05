package en.ase.csie;

import en.ase.csie.classes.Product;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program is starting");
        Product p1 = new Product("Milk", "Dairy", new int[]{1,2,3,4});
        System.out.println(p1.getName());
        Product p2 = p1;
        p1.setName("Bread");
        p1.setQuantity(25);
        p1.print();
        p2.print();
        System.out.println("The program is ending");
    }
}
