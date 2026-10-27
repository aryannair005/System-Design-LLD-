import java.util.ArrayList;

class Product{
    public String name;
    public double price;


    public Product(String name,double price){
        this.name = name;
        this.price = price;
    }
}

// Single class doing multiple responsibilities
class ShoppingCart{
    private ArrayList<Product> list = new ArrayList<>();

    // Add product
    public void addProduct(Product p){
        list.add(p);
    }

    // Get products
    public ArrayList<Product> getProducts(){
        return list;
    }

    // 1- Calculate total prices (first responsibility)
    public double calculateTotal(){
        double totalPrice = 0;
        for(int i=0;i<list.size();i++){
            Product p = list.get(i);
            totalPrice += p.price;
        }
        return totalPrice;
    } 

    // 2- Prints Invoice (second responsibility)
    public void printInvoice(){
        System.out.println("Shopping Cart Invoice");
        for(int i=0;i<list.size();i++){
            Product p = list.get(i);
            System.out.println("Product : "+p.name);
            System.out.println("Product Price : "+p.price);
        }
        System.out.println("Total Price : "+calculateTotal());
    }

    // 3- Saves to Database (third responsibility)
    public void saveToDb(){
        System.out.println("Saved to Db....");
    }
}


public class SRP_Violated{
    public static void main(String[] args){
        ShoppingCart sc = new ShoppingCart();

        sc.addProduct(new Product("Dumbles",1400));
        sc.addProduct(new Product("Resistance Band",200));

        System.out.println(sc.getProducts());
        System.out.println(sc.calculateTotal());
        sc.printInvoice();
        sc.saveToDb();
    }
}