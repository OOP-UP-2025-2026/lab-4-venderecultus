package ua.opnu;

import ua.opnu.java.inheritance.account.BankingAccount;
import ua.opnu.java.inheritance.account.Credit;
import ua.opnu.java.inheritance.account.Debit;
import ua.opnu.java.inheritance.account.Startup;

public class MinMaxAccount extends BankingAccount {

    // Мінімальний баланс
    int min;
    // Максимальний баланс
    int max;

    public MinMaxAccount(Startup s) {
        super(s);
        min = s.getBalance();
        max = s.getBalance();
    }

    // Операція зняття коштів
    @Override
    public void debit(Debit deb) {
        super.debit(deb);
        if (max < this.getBalance()) max = this.getBalance();
    }

    // Операція поповнення
    @Override
    public void credit(Credit cred) {
        super.credit(cred);
        if (min > this.getBalance()) min = this.getBalance();
    }

    // Повертає мінімальний баланс
    public int getMin() {
        return min;
    }

    // Повертає максимальний баланс
    public int getMax() {
        return max;
    }

}
