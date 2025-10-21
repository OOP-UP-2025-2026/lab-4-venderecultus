package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.Item;

import java.math.BigDecimal; // <-- ИМПОРТ
import java.math.RoundingMode; // <-- ИМПОРТ
import java.util.ArrayList;

public class DiscountBill2 {


    boolean regularCustomer;
    ArrayList<Item> items = new ArrayList<>();
    Employee clerk;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.clerk = clerk;
        this.regularCustomer = regularCustomer;
    }

    public Employee getClerk() {
        return clerk;
    }

    public void add(Item i) {
        items.add(i);
    }


    private BigDecimal calculateTotalPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Item item : items) {
            totalPrice = totalPrice.add(BigDecimal.valueOf(item.getPrice()));
        }
        return totalPrice;
    }

    private BigDecimal calculateTotalDiscount() {
        if (!regularCustomer) {
            return BigDecimal.ZERO;
        }

        BigDecimal totalDiscount = BigDecimal.ZERO;
        for (Item item : items) {
            totalDiscount = totalDiscount.add(BigDecimal.valueOf(item.getDiscount()));
        }
        return totalDiscount;
    }

    public double getTotal() {
        BigDecimal price = calculateTotalPrice();
        BigDecimal discount = calculateTotalDiscount(); // Уже учитывает, постоянный ли клиент

        BigDecimal total = price.subtract(discount);

        return total.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public int getDiscountCount() {
        int count = 0;
        if (regularCustomer) {
            for (Item item : items) {
                if (item.getDiscount() != 0) count++;
            }
        }
        return count;
    }

    public double getDiscountAmount() {
        BigDecimal totalDiscount = calculateTotalDiscount();

        return totalDiscount.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    // Відсоток знижки від загальної ціни
    public double getDiscountPercent() {
        BigDecimal totalPrice = calculateTotalPrice();
        BigDecimal totalDiscount = calculateTotalDiscount();

        // Проверка деления на ноль
        if (totalPrice.compareTo(BigDecimal.ZERO) == 0) {
            return 0.0;
        }

        BigDecimal hundred = new BigDecimal("100");


        int divisionScale = 15;
        RoundingMode rounding = RoundingMode.HALF_UP;

        BigDecimal percent = totalDiscount.multiply(hundred)
                .divide(totalPrice, divisionScale, rounding);

        return percent.doubleValue();
    }
}
