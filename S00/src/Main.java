public class Main {

    static void add(int x, int y,int[] z){
        x = x+y;
        z = new int[]{9,10};
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        int x =5;
        int y=2;

        System.out.println(x+y);

        Student student = new Student(20, "Odobasian", "CSIE");
        System.out.println(student.name);
        student.print();
        int[] z = new int[]{1,2,3};
        add(x,y,z);
        System.out.println(x);

        Student student2 = Student.cloneC(student);
        Student student3 = student.clone();

        Student student4 = new Student();
        Student student5 = student4.clone();

        for(int i=0;i<z.length;i++){
            System.out.println(z[i]);
        }
    }
}
