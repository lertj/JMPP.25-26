package ro.ase.csie.ro.ase.csie;

import java.io.*;

public class DataClasses {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        DataOutput dos = null;
        try {
            fos = new FileOutputStream("class.out");
            dos = new DataOutputStream(fos);

            dos.writeUTF("Test!");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FileInputStream fis = null;
        DataInputStream dis = null;
        try {
            fis = new FileInputStream("class.out");
            dis = new DataInputStream(fis);

            String inputt = dis.readUTF();
            System.out.println(inputt);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
