public class Account { //blueprint for object account, model account of a customer
    //Variables, attributes of the object Account
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
        String result = "Account[id=" + getID() + ",name=" + getName() +
        ",balance=" + getBalance();
        return result;
    }
}
