package composition;

public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int quantity = 0;

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
     }

    // Constructor
    public Book(String name, Author[] authors, double price, int quantity) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.quantity = quantity;
    }

    // Getter and Setter methods for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter methods for author
    public Author[] getAuthor() {
        return authors;
    }

    public void setAuthor(Author[] authors) {
        this.authors = authors;
    }

    // Getter and Setter methods for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter and Setter methods for quantity
    public int getQty() {
        return quantity;
    }

    public void setQty(int quantity) {
        this.quantity = quantity;
    }

    // toString method
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Book[name=").append(name).append(", Authors={");
        for(int i = 0; i < authors.length; i++) {
            if(i == authors.length - 1) builder.append("[" + authors[i] + "]");
            else builder.append("[" + authors[i]).append("], ");
        }
        builder.append("}").append(", Price=$").append(price).append(", Quantity=").append(quantity + "]");
        return builder.toString();
    }
    public String getAuthorsName() {
        String result = "";
        for(int i = 0; i < authors.length; i++) {
            result += authors[i].getName() + ", " ;
        }
        return result.substring(result.length() - 2, result.length());
    }

    public static void main(String args[]) {
        // Declare and allocate an array of Authors
        Author[] authors = new Author[2];
        authors[0] = new Author("Tan Ah Teck", "AhTeck@somewhere.com", 'm');
        authors[1] = new Author("Paul Tan", "Paul@nowhere.com", 'm');

// Declare and allocate a Book instance
        Book javaDummy = new Book("Java for Dummy", authors, 19.99, 99);
        System.out.println(javaDummy);  // toString()
    }
}