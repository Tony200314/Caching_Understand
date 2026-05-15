package src;

import java.util.*;

public class Disk {


    private Map<String, Integer> Database;


    private List<String> Cache;

    public Disk() {
        this.Database = new HashMap<>();
        this.Cache = new ArrayList<>();
    }


    public String ReadInCache(String productName) {

        // CACHE HIT
        if (Cache.contains(productName)) {
            System.out.println("Cache HIT -> Reading from Cache");
            return productName;
        }

        // CACHE MISS
        if (Database.containsKey(productName)) {

            System.out.println("Cache MISS -> Reading from Disk");

            // Copy data into cache
            Cache.add(productName);

            return productName;
        }

        return "Product not found";
    }


    public void WriteThrough(String productName, int price) {

        Cache.add(productName);

        Database.put(productName, price);

        System.out.println("Write-Through: written to Cache and Disk");
    }


    public void WriteBack(String productName) {

        Cache.add(productName);

        System.out.println("Write-Back: written only to Cache");
    }
}
