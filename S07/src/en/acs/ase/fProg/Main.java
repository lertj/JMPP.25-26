package en.acs.ase.fProg;

import en.acs.ase.fProg.models.GroceryList;
import en.acs.ase.fProg.models.Printable;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args){
        List<Integer> prices1 = new ArrayList<>();
        prices1.add(15);
        prices1.add(10);
        prices1.add(20);

        List<String> names1 = new ArrayList<>();
        names1.add("egg");
        names1.add("Milk");
        names1.add("Bread");

        GroceryList g1 = new GroceryList("First List", prices1, names1);



        Printable err = new Printable() {
            @Override
            public String log(String message) {
                return "[ERROR] " + message;
            }
        };

        System.out.println(err.log("Variable not valid"));

        Printable info = (mssg) -> {
            return "[INFO] " + mssg;
        };

        System.out.println(info.log("Operation succesful!"));

        Printable debug = x -> "[DEBUG] " + x;
        System.out.println(debug.log("Debugged"));

        System.out.println(g1.modifyPrice());
        System.out.println(g1.itemNamesGreaterThan3());
        System.out.println(g1.itemNames);

    }
}
