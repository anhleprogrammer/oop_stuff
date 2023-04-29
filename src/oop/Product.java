package oop;

import java.util.Comparator;

public class Product implements Comparable {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Object o) {
        //compare based on price
        //return -1 if object of the class we implement less than the one in parameter
        if(this.getClass() == o.getClass()) {
            if(this.price < ((Product) o).getPrice()) {
                return -1;
            } else if(this.price ==  ((Product) o).getPrice()) {
                return 0;
            }
        }
        return 1;
    }
}

