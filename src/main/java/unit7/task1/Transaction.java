package unit7.task1;

public class Transaction {
    private int ID;
    private int IDAccountToWithdrawFrom;
    private int IDAccountToDepositTo;
    private int amountToTransfer;

    public Transaction(){}

    public Transaction(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDAccountToWithdrawFrom() {
        return IDAccountToWithdrawFrom;
    }

    public void setIDAccountToWithdrawFrom(int IDAccountToWithdrawFrom) {
        this.IDAccountToWithdrawFrom = IDAccountToWithdrawFrom;
    }

    public int getIDAccountToDepositTo() {
        return IDAccountToDepositTo;
    }

    public void setIDAccountToDepositTo(int IDAccountToDepositTo) {
        this.IDAccountToDepositTo = IDAccountToDepositTo;
    }

    public int getAmountToTransfer() {
        return amountToTransfer;
    }

    public void setAmountToTransfer(int amountToTransfer) {
        this.amountToTransfer = amountToTransfer;
    }
}
