package unit7.task1;

import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private final int ID;
    private int amount;
    private ReentrantLock lock;

    private static int IDincreaser;

    public Account(){
        ID = ++IDincreaser;
    }

    public Account(int startAmount){
        this();
        amount = startAmount;
    }

    public void withdrawWithLock(int amount){
        lock.lock();
        if (this.amount - amount < 0) {
            throw new IllegalArgumentException("Amount to withdraw is too large");
        } else {
            this.amount -= amount;
        }
        lock.unlock();
    }

    public void depositWithLock(int amount){
        lock.lock();
        if (amount >= 0) {
            this.amount += amount;
        } else {
            throw new IllegalArgumentException("Amount to deposit can not be negative");
        }
        lock.unlock();
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
        synchronized (this) {
            if (amount >= 0) {
                this.amount += amount;
            } else {
                throw new IllegalArgumentException("Amount to deposit can not be negative");
            }
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
}
