package unit7.task1;


public class TransactionsController {
    TransactionsModel transactionsModel;
    TransactionsView transactionsView;

    public TransactionsController(TransactionsModel transactionsModel, TransactionsView transactionsView) {
        this.transactionsModel = transactionsModel;
        this.transactionsView = transactionsView;
    }

    public void executeAllTransactionsParallel(){
        transactionsModel.readFromXML();
        for(Transaction transaction : transactionsModel.getTransactions()){
            new Thread(new TransactionRunnable(transaction, transactionsModel)).start();
        }
    }

}
