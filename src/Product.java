import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;

public abstract class Product {
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
    private ZonedDateTime createdAt;

    public Product() {
    }

    public Product(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(String name, String description, BigDecimal price, ZonedDateTime createdAt) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public static void getAllProducts(Product[] products){
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static Product[] deleteProduct(Product[] products, long id){
        for (int i = 0; i < products.length; i++) {
            if(products[i].getId()==id){
                for (int j = i; j < products.length-1; j++) {
                    products[j] = products[j+1];
                }
            }
        }
        return Arrays.copyOf(products, products.length-1);
    }
     public static Product[] deleteProduct(Product[] products, long[] ids){
         for (int i = 0; i < ids.length; i++) {
             products = deleteProduct(products, ids[i]);
         }
         return products;
    }

    public abstract Product[] addNewProduct(Product[] products);
    public abstract void getProducts(Product[] products);


    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\''+
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", createdAt=" + createdAt +
                '}';
    }
}
