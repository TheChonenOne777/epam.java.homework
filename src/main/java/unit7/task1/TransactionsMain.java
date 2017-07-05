package unit7.task1;

public class TransactionsMain {
    public static void main(String[] args) {
        TransactionsModel tmodel = new TransactionsModel();
        TransactionsView tview = new TransactionsView();
        TransactionsController tcontroller = new TransactionsController(tmodel, tview);
        System.out.println(tmodel.getAccounts());
        tcontroller.executeAllTransactionsParallel();
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(tmodel.getAccounts());
    }
}
