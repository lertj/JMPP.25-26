package ro.ase.csie;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Book> set = new TreeSet<>();
        Book b1 = new Book("Ion","Liviu Rebreanu", 300, new int[]{100,200,50});
        Book b2 = new Book("CatIon","Ziviu Rebreanu", 301, new int[]{100,200,50});

        set.add(b1);
        set.add(b2);

//        for(Book b: set){
//            System.out.println(b);
//        }

        Map<Book, String> map = new HashMap<>();
        map.put(b1,"Bob");
        map.put(b2,"Mike");
//        for(Book b : map.keySet()){
//            System.out.println(b);
//            System.out.println(map.get(b));
//        }

        //be careful that b3 has global scope
        Book b3 = null;
        try {
            b3 = (Book)b2.clone();
        }catch(CloneNotSupportedException e){
            throw new RuntimeException("exception");
        }

        //by default, the map checks key uniqueness by comparing at object addresses
        map.put(b3, "John");

//        for(Book b : map.keySet()){
//            System.out.println(b);
//            System.out.println(map.get(b));
//        }

        map.put(b3, "Johnny");

        for(Book b : map.keySet()){
            System.out.println(b);
            System.out.println(map.get(b));
        }


    }
}
