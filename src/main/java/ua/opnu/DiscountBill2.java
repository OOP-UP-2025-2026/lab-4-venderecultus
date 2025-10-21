package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.Item;

import java.util.ArrayList;

public class DiscountBill2 {

    // Чи є клієнт постійним
    boolean regularCustomer;
    // Список товарів
    ArrayList<Item> items = new ArrayList<>();
    // Працівник, який оформлює рахунок
    Employee clerk;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.clerk = clerk;
        this.regularCustomer = regularCustomer;
    }

    // Повертає працівника
    public Employee getClerk() {
        return clerk;
    }

    // Додає товар у список
    public void add(Item i) {
        items.add(i);
    }

    // Повертає загальну суму (з урахуванням знижки)
    public double getTotal() {
        double price = 0;
        double discount = 0;

        for (Item item : items) {
            price += item.getPrice();
            if (regularCustomer) discount += item.getDiscount();
        }

        if (regularCustomer) return price - discount;
        return price;
    }

    // Кількість товарів зі знижкою
    public int getDiscountCount() {
        int count = 0;
        if (regularCustomer) {
            for (Item item : items) {
                if (item.getDiscount() != 0) count++;
            }
        }
        return count;
    }

    // Загальна сума знижки
    public double getDiscountAmount() {
        double totalDiscount = 0;
        if (regularCustomer) {
            for (Item item : items) {
                totalDiscount += item.getDiscount();
            }
        }
        return totalDiscount;
    }

    // Відсоток знижки від загальної ціни
    public double getDiscountPercent() {
        if (regularCustomer) {
            double totalPrice = 0;
            for (Item item : items) totalPrice += item.getPrice();
            return (getDiscountAmount() * 100) / totalPrice;
        }
        return 0;
    }

}
