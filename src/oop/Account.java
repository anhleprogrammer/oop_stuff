package oop;

public class Account { //blueprint for object account, model account of a customer
    //Variables, attributes of the object OOP.Account
    private String id;
    private String name;
    private int balance = 0;

    public Account(String id, String name) {
        //Constructor to set initial value of the attributes
        this.id = id;
        this.name = name;
    }
    public Account(String id, String name, int balance) {
        this(id,name); //call above constructor
        this.balance = balance;
    }
    public String getID() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public int getBalance() {
        return this.balance;
    }
    public int credit(int amount) {
        this.balance = getBalance() + amount;
        return this.balance;
    }
    public int debit(int amount) {
        if(amount <= this.balance) {
            this.balance -= amount;
        } else {
            System.out.println("Amount exceeded balance");
        }
        return this.balance;
    }
    public int transferTo(Account another, int amount) {
        if(amount <= this.balance) {
            another.balance += amount;
            this.balance -= 100;
        } else {
            System.out.println("Amount exceeded balance");
        }
        return this.balance;
    }
    public String toString() {
        String result = "OOP.Account[id=" + getID() + ",name=" + getName() +
        ",balance=" + getBalance();
        return result;
    }
    public static void main(String[] args) {
        Account a1 = new Account("A101", "Tan Ah Teck", 88);
        System.out.println(a1);  // toString();
        Account a2 = new Account("A102", "Kumar"); // default balance
        System.out.println(a2);

        // Test Getters
        System.out.println("ID: " + a1.getID());
        System.out.println("Name: " + a1.getName());
        System.out.println("Balance: " + a1.getBalance());

        // Test credit() and debit()
        a1.credit(100);
        System.out.println(a1);
        a1.debit(50);
        System.out.println(a1);
        a1.debit(500);  // debit() error
        System.out.println(a1);

        // Test transfer()
        a1.transferTo(a2, 100);  // toString()
        System.out.println(a1);
        System.out.println(a2);
    }
}
