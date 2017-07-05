package unit7.task1;


import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TransactionsModel {
    private XMLReader reader;
    private TransactionSaxHandler handler;
    private List<Transaction> transactions;
    private Set<Account> accounts;

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
        accounts = new HashSet<>();
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
        System.out.println("Transaction " + transaction.getID() + " started");

        Account fromAccount = getAccountById(transaction.getIDAccountToWithdrawFrom());
        Account toAccount = getAccountById(transaction.getIDAccountToDepositTo());
        int amount = transaction.getAmountToTransfer();

        checkIfAccountExist(fromAccount);
        checkIfAccountExist(toAccount);

        fromAccount.withdrawSynchronized(amount);
        toAccount.depositSynchronized(amount);

//        fromAccount.withdrawWithLock(amount);
//        toAccount.depositWithLock(amount);

        accounts.add(fromAccount);
        accounts.add(toAccount);
    }


    private Account getAccountById(int id){
        for(Account account : accounts){
            if(account.getID() == id){
                return account;
            }
        }
        return null;
    }

    private void checkIfAccountExist(Account account){
        if(!accounts.contains(account)) throw new IllegalArgumentException("Account does not exist");
    }

    public Set<Account> getAccounts() {
        return accounts;
    }
}
