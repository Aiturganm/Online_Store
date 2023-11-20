import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Book extends Product{
    private String authorFullName;

    public Book(){}

    @Override
    public Product[] addNewProduct(Product[] products) {
        Scanner scanner = new Scanner(System.in);
        this.setId(MyCenerateId.generateId());
        System.out.println("Enter book name: ");
        this.setName(scanner.nextLine());
        System.out.println("Enter book description: ");
        this.setDescription(scanner.nextLine());
        System.out.println("Enter price: ");
        this.setPrice(new Scanner(System.in).nextBigDecimal());
        System.out.println("Enter author: ");
        this.setAuthorFullName(scanner.nextLine());
        this.setCreatedAt(ZonedDateTime.now());

        Product[] newProductsArray = Arrays.copyOf(products,products.length+1);
        newProductsArray[newProductsArray.length - 1] = this;
        return newProductsArray;
    }

    @Override
    public void getProducts(Product[] products) {
        for (Product product : products) {
            if(product instanceof Book book){
                System.out.println(book);
            }
        }
    }

    public Book(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    public Book(String name, String description, BigDecimal price, String authorFullName) {
        super(name, description, price);
        this.authorFullName = authorFullName;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }
}
