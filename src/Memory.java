package src;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Memory {
    private HashMap<String, Integer> Database;
    private List<Product> Cache;

    public Memory(){
        this.Database = new HashMap();
        this.Cache = new ArrayList<>();
    }

    public void addToCache(String productName, int price){
        Cache.add(new Product(productName , price));
    }

    public void getFromCache(String productName){
        Cache.stream().filter(x -> x.equals(new Product(productName))).forEach(System.out::println);
    }

    public boolean isInCache(String productName) {
        for (Product product : Cache) {
            if (product.getProductname().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public Product fetchProduct(String productname) {

        // CACHE HIT
        for (Product product : Cache) {
            if (product.getProductname().equals(productname)) {
                System.out.println("Cache HIT: " + productname);
                return product;
            }
        }

        // CACHE MISS → DATABASE
        Integer price = Database.get(productname);

        if (price == null) {
            return null;
        }

        Product newProduct = new Product(productname, price);

        Cache.add(newProduct);

        System.out.println("Cache MISS: loaded from DB");

        return newProduct;
    }
}
