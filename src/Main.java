package src;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        Disk disk = new Disk();


       disk.WriteThrough("Laptop", 1000);
       disk.WriteThrough("Phone", 500);

       System.out.println();
       System.out.println(disk.ReadInCache("Laptop")); // Cache HIT
       System.out.println();
       System.out.println(disk.ReadInCache("Iphone")); // Cache Miss
       System.out.println();
       disk.WriteBack("Iphone");

        //Memory
        Memory memory = new Memory();

        memory.addToCache("Laptop", 1000);
        memory.addToCache("Phone", 500);
        System.out.println();

        System.out.println("the laptop is in Cache: " + memory.isInCache("Laptop")); // Cache HIT
        System.out.println("the Iphone is in Cache: " + memory.isInCache("Iphone")); // Cache





    }
}
