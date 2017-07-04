package unit7.task1;

public class TransactionRunnable implements Runnable{
    TransactionsModel transactionsModel = new TransactionsModel();;
    Transaction transaction;

    public TransactionRunnable(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public void run() {
        transactionsModel.executeTransaction(transaction);
    }
}
