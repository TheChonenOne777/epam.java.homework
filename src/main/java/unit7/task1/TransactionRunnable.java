package unit7.task1;

public class TransactionRunnable implements Runnable{
    TransactionsModel transactionsModel;
    Transaction transaction;

    public TransactionRunnable(Transaction transaction, TransactionsModel transactionsModel) {
        this.transactionsModel = transactionsModel;
        this.transaction = transaction;
    }

    @Override
    public void run() {
        transactionsModel.executeTransaction(transaction);
    }
}
