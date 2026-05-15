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

    public Product fetchProduct(Product product) {

        // CACHE HIT
        for (Product product2 : Cache) {
            if (product2.getProductname().equals(product.getProductname())) {
                System.out.println("Cache HIT: " + product.getProductname());
                return product;
            }
        }

        // CACHE MISS → DATABASE
        Integer price = Database.get(product.getPrice());

        if (price == null) {
            return null;
        }

        Product newProduct = new Product(product.getProductname(), price);

        Cache.add(newProduct);

        System.out.println("Cache MISS: loaded from DB");

        return newProduct;
    }
}
