package unit7.task1;

public class TransactionsMain {
    public static void main(String[] args) {
        TransactionsModel tmodel = new TransactionsModel();
        TransactionsView tview = new TransactionsView();
        TransactionsController tcontroller = new TransactionsController(tmodel, tview);
        tcontroller.executeAllTransactionsParallel();
    }
}
