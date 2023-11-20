import java.util.Arrays;
import java.util.Scanner;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Product[] products = new Product[0];

    public User(){}

    public User(String firstName, String lastName, String email, String password, Product[] products) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.products = products;
    }

    public static User[] addUserToArray(User[] users, User registerUser) {
        User[] newArray = Arrays.copyOf(users, users.length+1);
        newArray[newArray.length-1] = registerUser;
        return newArray;
    }

    public static User login(User[] users) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return user;
            }else System.out.println("User not found");
        }
        return null;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
    public static User register(User newUser){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name: ");
        String name = scanner.nextLine();
        if(!name.isEmpty()){
            newUser.setFirstName(name);
        }else {
            String checedName;
            do{
                System.out.println("Name is empty!");
                System.out.println("Enter first name: ");
                checedName= scanner.nextLine();
            }while(checedName.isEmpty());
            if(!checedName.isEmpty()) newUser.setFirstName(checedName);
        }

        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();
        if(!lastName.isEmpty()){
            newUser.setLastName(lastName);
        }else {
            String checkedLastName;
            do{
                System.out.println("Last name is empty!");
                System.out.println("Enter last name: ");
                checkedLastName = scanner.nextLine();
            }while(checkedLastName.isEmpty());
            if (!checkedLastName.isEmpty()) newUser.setLastName(checkedLastName);
        }
        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        if(email.contains("@gmail.com")) {
            newUser.setEmail(email);
        }else {
            String checkEmail;
            do {
                System.out.println("Email must contains @gmail.com");
                System.out.println("Enter email: ");
                checkEmail = scanner.nextLine();
            }while(!checkEmail.contains("@gmail.com"));
            if (checkEmail.contains("@gmail.com")) newUser.setEmail(checkEmail);
        }

        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        if(password.length()>=4) {
            newUser.setPassword(password);
        }else {
            String checkPassword;
            do {
                System.out.println("Password length must be greater than 4");
                System.out.println("Enter password: ");
                checkPassword = scanner.nextLine();
            }while(checkPassword.length()<4);
            if (checkPassword.length()>=4) newUser.setPassword(checkPassword);
        }
        return newUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
