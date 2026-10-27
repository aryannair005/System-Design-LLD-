import java.util.ArrayList;


class Product{
    public String name;
    public double price;

    public Product(String name,double price){
        this.name = name;
        this.price = price;
    }
}

// ShoppingCart : (Only one cart related responsibility)

class ShoppingCart{
    private ArrayList<Product> list = new ArrayList<>();

    public void addProduct(Product p){
        list.add(p);
    }

    public ArrayList<Product> getProducts(){
        return list;
    }

    // Calculates total price (Only responsibility)
    public double calculateTotal(){
        double total = 0;

        for(int i=0;i<list.size();i++){
            Product p = list.get(i);
            total += p.price;
        }

        return total;
    }
}


// ShoppingCartPrinter : Only reponsible for printing invoices

class ShoppingCartPrinter{
    private ShoppingCart cart;

    public ShoppingCartPrinter(ShoppingCart cart){
        this.cart = cart;
    }

    public void printInvoice(){
        System.out.println("Shopping Cart Invoice:");
        ArrayList<Product> allProducts = cart.getProducts();
        for(int i=0;i<allProducts.size();i++){
            Product p = allProducts.get(i);
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + cart.calculateTotal());
    }
}

// ShopingCartStorage : Only responsibility to store in DB

class ShopingCartStorage{
    private ShoppingCart cart;

    public ShopingCartStorage(ShoppingCart cart){
        this.cart = cart;
    } 

    public void saveToDb(){
        System.out.println("Saving shopping cart to database...");
    }
}


public class SRP_Followed{
    public static void main(String[] args){
        ShoppingCart sc = new ShoppingCart();

        sc.addProduct(new Product("Dumbles",1400));
        sc.addProduct(new Product("Resistance Band",200));

        ShoppingCartPrinter scp = new ShoppingCartPrinter(sc);
        scp.printInvoice();

        ShopingCartStorage scs = new ShopingCartStorage(sc);
        scs.saveToDb();
    }
}