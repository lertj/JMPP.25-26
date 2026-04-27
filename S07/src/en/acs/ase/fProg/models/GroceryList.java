package en.acs.ase.fProg.models;

import java.util.ArrayList;
import java.util.List;

public class GroceryList {
    private String name;
    public List<Integer> itemPrices;
    public List<String> itemNames;

    public GroceryList(String name, List<Integer> itemPrices, List<String> itemNames) {
        this.name = name;
        this.itemPrices = new ArrayList<>(itemPrices);
        this.itemNames = new ArrayList<>(itemNames);
    }

    // a function that gives the names of the items that have a name with the length > 3
//    public List<String> itemNamesGreaterThan3(){
//        List<String> namesGreaterThan3 = new ArrayList<>();
//        for (String name : itemNames)
//            if (name.length() > 3)
//                namesGreaterThan3.add(name);
//        return namesGreaterThan3;
//    }

    public List<String> itemNamesGreaterThan3(){
        return this.itemNames.stream().filter(x -> {
            if (x.length() > 3)
                return true;
            return false;
        }).toList();
    }
    // a function that goes through all the prices, and if the price is dividable by 3, double it, otherwise -1,
    // and at the end return the sum of all the prices (do not change the original prices)
//    public int modifyPrice(){
//        List<Integer> copyPrice = new ArrayList<>(this.itemPrices);
//        int s = 0;
//        for (Integer price : copyPrice) {
//            if (price % 3 == 0)
//                price *= 2;
//            else
//                price -= 1;
//            s += price;
//        }
//        return s;
//    }
    public int modifyPrice() {
        return this.itemPrices.stream().map(x -> {
            if (x % 3 == 0)
               x *= 2;
            else
                x -= 1;
            return x;
        }).reduce((x, y) -> x + y).get();
    }


}
