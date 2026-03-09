package en.csie.ase.classes;

import en.csie.ase.interfaces.Moveable;

public abstract class Vehicle implements Moveable,Cloneable{
    String brand;
    String model;
    int capacity;
    int[] weightPerPassenger;

    public String getBrand() {
        return brand;
    }

    public int[] getWeightPerPassenger() {
        int[] newWeightPerPassenger= new int[this.weightPerPassenger.length];
        for(int i=0;i<this.weightPerPassenger.length;i++)
            newWeightPerPassenger[i]=this.weightPerPassenger[i];
        return newWeightPerPassenger;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setWeightPerPassenger(int[] weightPerPassenger) {
        this.weightPerPassenger = new int[weightPerPassenger.length];
        for(int i=0; i<weightPerPassenger.length;i++)
            this.weightPerPassenger[i]=weightPerPassenger[i];
    }

    public Vehicle(String brand, String model, int capacity, int[] weightPerPassenger) {
        this.brand = brand;
        this.model = model;
        this.capacity = capacity;
        this.weightPerPassenger=new int[weightPerPassenger.length];
        for(int i=0;i<weightPerPassenger.length;i++)
            this.weightPerPassenger[i]=weightPerPassenger[i];
    }


    @Override
    public void move(int distance) {

        System.out.println("Moving " + distance);
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        //return super.clone();
        //shallow copy
        Vehicle v= (Vehicle) super.clone();
        v.brand=this.brand;
        v.model=this.model;
        v.capacity=this.capacity;
        v.weightPerPassenger=new int[this.weightPerPassenger.length];
        for(int i=0;i<this.weightPerPassenger.length;i++)
            v.weightPerPassenger[i]=this.weightPerPassenger[i];

        return v;

    }
}
