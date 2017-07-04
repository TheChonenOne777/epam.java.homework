package unit7.task1;


import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionsModel {
    private XMLReader reader;
    private TransactionSaxHandler handler;
    private List<Transaction> transactions;
    private List<Account> accounts;

    public TransactionsModel() {
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        handler = new TransactionSaxHandler();
        initAccounts();
    }

    private void initAccounts() {
        accounts = new ArrayList<>();
        accounts.add(new Account(100));
        accounts.add(new Account(200));
        accounts.add(new Account(300));
    }

    public void readFromXML(){
        reader.setContentHandler(handler);
        try {
            reader.parse(new InputSource("unit7task1/transactions.xml"));
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
        transactions = handler.getTransactionList();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void executeTransaction(Transaction transaction){
        System.out.println("Transaction " + transaction.getID() + "started");

        checkIfTransactionHasValidAccounts(transaction);

        int amount = transaction.getAmountToTransfer();
        Account fromAccount = getAccountById(transaction.getIDAccountToWithdrawFrom());
        Account toAccount = getAccountById(transaction.getIDAccountToWithdrawFrom());
        fromAccount.withdrawSynchronized(amount);
        toAccount.depositSynchronized(amount);
    }

    private Account getAccountById(int id){
        for(Account account : accounts){
            if(account.getID() == id){
                return account;
            }
        }
        return null;
    }

    private void checkIfTransactionHasValidAccounts(Transaction transaction){
        int from = transaction.getIDAccountToDepositTo();
        int to = transaction.getIDAccountToWithdrawFrom();
        for(Account account : accounts) {
             if(from != account.getID()){
                 throw new IllegalArgumentException("Account to withdraw from does not exist");
             }
             if(to != account.getID()){
                 throw new IllegalArgumentException("Account to deposit to does not exist");
             }
        }
    }
}
