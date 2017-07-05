package unit7.task1;

import org.xml.sax.*;

import java.util.ArrayList;
import java.util.List;

public class TransactionSaxHandler implements ContentHandler, ErrorHandler {
    private List<Transaction> transactionList = new ArrayList<>();
    private Transaction transaction;
    private StringBuilder text;

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    @Override
    public void setDocumentLocator(Locator locator) {
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parsing");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End parsing");
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {

    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        text = new StringBuilder();
        if(qName.equals("transaction")){
            transaction = new Transaction();
            transaction.setID(Integer.parseInt(atts.getValue("id")));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        TransactionTagName transactionTagName = TransactionTagName.valueOf(qName.toUpperCase().replace("-", "_"));
        switch (transactionTagName){
            case FROM:
                transaction.setIDAccountToWithdrawFrom(Integer.parseInt(text.toString()));
                break;
            case TO:
                transaction.setIDAccountToDepositTo(Integer.parseInt(text.toString()));
                break;
            case AMOUNT:
                transaction.setAmountToTransfer(Integer.parseInt(text.toString()));
                break;
            case TRANSACTION:
                transactionList.add(transaction);
                transaction = null;
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(ch, start, length);
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {

    }

    @Override
    public void skippedEntity(String name) throws SAXException {

    }

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        System.err.println(exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        System.err.println(exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        System.err.println(exception.getMessage());
    }
}
