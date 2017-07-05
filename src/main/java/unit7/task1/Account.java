package unit7.task1;

import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private final int ID;
    private int amount;
    private ReentrantLock lockForWithdraw = new ReentrantLock();
    private ReentrantLock lockForDeposit = new ReentrantLock();

    private static int IDincreaser;

    public Account(){
        ID = ++IDincreaser;
    }

    public Account(int startAmount){
        this();
        amount = startAmount;
    }

    public void withdrawWithLock(int amount){
        lockForWithdraw.lock();
        if (this.amount - amount < 0) {
            throw new IllegalArgumentException("Amount to withdraw is too large");
        } else {
            this.amount -= amount;
        }
        lockForWithdraw.unlock();
    }

    public void depositWithLock(int amount){
        if (amount >= 0) {
            lockForDeposit.lock();
            this.amount += amount;
            lockForDeposit.unlock();
        } else {
            throw new IllegalArgumentException("Amount to deposit can not be negative");
        }
    }

    public void withdrawSynchronized(int amount){
        synchronized (this) {
            if (this.amount - amount < 0) {
                throw new IllegalArgumentException("Amount to withdraw is too large");
            } else {
                this.amount -= amount;
            }
        }
    }

    public void depositSynchronized(int amount){
        if (amount >= 0) {
            synchronized (this) {
                this.amount += amount;
            }
        } else {
            throw new IllegalArgumentException("Amount to deposit can not be negative");
        }
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getID() {
        return ID;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return ID == account.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "Account{" +
                "ID=" + ID +
                ", amount=" + amount +
                '}';
    }
}
