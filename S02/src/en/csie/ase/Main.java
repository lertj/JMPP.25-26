package en.csie.ase;
import en.csie.ase.classes.Vehicle;
import en.csie.ase.classes.Autovehicle;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        Autovehicle v1 = new Autovehicle("brandName","ABC",3,new int[]{1,2,3,4});

        int[] w1= new int[5];
        w1[0]=50;w1[1]=12;w1[2]=43;w1[3]=34;w1[4]=54;
        //int[] w2
        Autovehicle v2=new Autovehicle("Mercedes","A",2,w1);
        System.out.println(v2.getBrand());
        v2.move(30);

        Autovehicle v3= (Autovehicle) v2.clone();
        //Object o;



    }

}
