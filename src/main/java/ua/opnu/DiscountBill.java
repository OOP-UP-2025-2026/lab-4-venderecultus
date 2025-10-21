package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

import java.util.ArrayList;

public class DiscountBill extends GroceryBill {

    // Чи є клієнт постійним
    boolean regularCustomer;
    // Список товарів
    ArrayList<Item> items = new ArrayList<>();

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
    }

    // Додаємо товар у список
    @Override
    public void add(Item i) {
        super.add(i);
        items.add(i);
    }

    // Розрахунок загальної суми
    @Override
    public double getTotal() {
        double total = 0;
        double discount = 0;

        for (Item it : items) {
            total += it.getPrice();
            if (regularCustomer) discount += it.getDiscount();
        }

        if (regularCustomer) return total - discount;
        return total;
    }

    // Кількість товарів зі знижкою
    public int getDiscountCount() {
        int cnt = 0;
        if (regularCustomer) {
            for (Item it : items) {
                if (it.getDiscount() > 0) cnt++;
            }
        }
        return cnt;
    }

    // Загальна сума знижки
    public double getDiscountAmount() {
        double sum = 0;
        if (regularCustomer) {
            for (Item it : items) {
                sum += it.getDiscount();
            }
        }
        return sum;
    }

    // Відсоток знижки
    public double getDiscountPercent() {
        if (regularCustomer) {
            double total = 0;
            for (Item it : items) total += it.getPrice();
            double d = getDiscountAmount();
            return (d * 100) / total;
        }
        return 0;
    }

}
