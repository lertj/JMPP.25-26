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

        for(Book b: set){
            System.out.println(b);
        }

        Map<Book, String> map = new HashMap<>();
        map.put(b1,"Bob");
        map.put(b2,"Mike");
        for(Book b : map.keySet()){
            System.out.println(b);
            System.out.println(map.get(b));
        }
    }
}
