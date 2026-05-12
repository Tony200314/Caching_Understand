package src;

public class Product {
    private String productname;
    private int price;

    public Product(String productname){
        this.productname = productname;
    }

    public  Product(int price){
        this.price = price;
    }

    public Product(String productname , int price){
        this.productname = productname;
        this.price = price;
    }

    public String getProductname() {
        return productname;
    }

    public int getPrice() {
        return price;
    }
}
