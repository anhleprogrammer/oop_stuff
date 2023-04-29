package oop;

import java.util.Comparator;
import java.util.*;

public class ProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        if(p1.getQuantity() == p2.getQuantity() && p1.getPrice() == p2.getPrice()) {
            return 0;
        } else if(p1.getQuantity() < p2.getQuantity() && p1.getPrice() < p2.getPrice()) return -1;
        return 1;
    }
    public static void main(String args[]) {
        Product p1 = new Product("Lion", 4 , 4);
        Product p2 = new Product("Dragon", 2,2);
        Product p3 = new Product("Zebra", 3, 3);

        List<Product> products = Arrays.asList(p1,p2, p3);

        Collections.sort(products, new ProductComparator());
        products.forEach(e -> System.out.print(e.getName() + ","));
    }
}
