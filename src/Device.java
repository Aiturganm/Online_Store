import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Device extends Product{
    private String brand;
    private String color;
    private boolean isNew;
    private String memory;

    public Device() {
    }

    @Override
    public Product[] addNewProduct(Product[] products) {
        Scanner scanner = new Scanner(System.in);
        this.setId(MyCenerateId.generateId());
        System.out.println("Enter device name: ");
        this.setName(scanner.nextLine());
        System.out.println("Enter device description: ");
        this.setDescription(scanner.nextLine());
        System.out.println("Enter price: ");
        this.setPrice(new Scanner(System.in).nextBigDecimal());
        System.out.println("Enter device brand: ");
        this.setBrand(scanner.nextLine());
        System.out.println("Enter color: ");
        this.setColor(scanner.nextLine());
        System.out.println("Is device new? (1 - new, 2 - old): ");
        String NewOld = scanner.nextLine().toLowerCase();
        if(NewOld.equals("1") || NewOld.equals("new")){
            this.setNew(true);
        }
        else if(NewOld.equals("2") || NewOld.equals("old")){
            this.setNew(false);
        }
        System.out.println("Enter the memory: ");
        this.setMemory(scanner.nextLine());
        this.setCreatedAt(ZonedDateTime.now());

        Product[] newProductsArray = Arrays.copyOf(products, products.length+1);
        newProductsArray[newProductsArray.length - 1] = this;
        return newProductsArray;
    }

    @Override
    public void getProducts(Product[] products) {
        for (Product product : products) {
            if(product instanceof Device device){
                System.out.println(device);
            }
        }
    }

    public Device(String name, String description, BigDecimal price, String brand, String color, boolean isNew, String memory) {
        super(name, description, price);
        this.brand = brand;
        this.color = color;
        this.isNew = isNew;
        this.memory = memory;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }
}
