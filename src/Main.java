import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User[] users = new User[0];
        User currentUser = null;
        OuterLoop:
        while(true){
            System.out.print("""
                    1. Register
                    2. Get All Users
                    3. Login
                    4. Exit
                    choice commands: 
                    """);

            switch (scanner.nextLine().toLowerCase()){
                case "1", "register" ->{
                    User registerUser = User.register(new User());
                    User[] newUsers = User.addUserToArray(users, registerUser);
                    users = newUsers;
                    System.out.println("Successfuly saved user!");
                }
                case "2", "get all users" ->{
                    System.out.println(Arrays.toString(users));
                }
                case "3", "login" ->{
                    User loginUser = User.login(users);
                    currentUser = loginUser;
                    if(currentUser!=null) System.out.println("Login succes. ");
                        InnerLoop:
                        while (true) {
                            if(currentUser!=null) {
                            System.out.println("""
                                    0. Logout
                                    1. Add product
                                    2. Get All Products
                                    3. Get All Book
                                    4. Get All Device
                                    5. Delete Product by Id
                                    6. Delete Products by Ids
                                    """);
                            switch (scanner.nextLine().toLowerCase()) {
                                case "0" -> {
                                    break InnerLoop;
                                }
                                case "1" -> {
                                    System.out.println("Book or Device: ");
                                    switch (scanner.nextLine().toLowerCase()) {
                                        case "book" -> {
                                            Book product = new Book();
                                            if (currentUser != null) {
                                                Product[] products = product.addNewProduct(currentUser.getProducts());
                                                currentUser.setProducts(products);
                                                System.out.println("Book added");
                                            }
                                        }
                                        case "device" -> {
                                            Device device = new Device();
                                            if (currentUser != null) {
                                                Product[] products = device.addNewProduct(currentUser.getProducts());
                                                currentUser.setProducts(products);
                                            }
                                            System.out.println("Device added");
                                        }
                                    }
                                }
                                case "2" -> {
                                    if (currentUser != null) Product.getAllProducts(currentUser.getProducts());
                                }
                                case "3" -> {
                                    new Book().getProducts(currentUser.getProducts());
                                }
                                case "4" -> {
                                    new Device().getProducts(currentUser.getProducts());
                                }
                                case "5" -> {
                                    System.out.println("Enter id: ");
                                    Product[] products = Product.deleteProduct(currentUser.getProducts(), scanner.nextLong());
                                    currentUser.setProducts(products);
                                    System.out.println("Success deleted");
                                }
                                case "6" -> {
                                    System.out.println("Enter ids: ");
                                    int length = scanner.nextInt();
                                    long[] ids = new long[length];
                                    for (int i = 0; i < length; i++) {
                                        System.out.println("Enter ID by number: ");
                                        ids[i] = scanner.nextLong();
                                    }
                                    Product[] newProducts = Product.deleteProduct(currentUser.getProducts(), ids);
                                    currentUser.setProducts(newProducts);
                                    System.out.println("Success deleted");
                                }
                            }
                        }else break InnerLoop;
                    }
                }
                case "4", "exit" ->{
                    break OuterLoop;
                }
            }
        }
    }
}