package com.example.sysadmin.quafos;


public class QuizQuestion {

    private int _id = -1;   // -1, dmit irgendwas drin steht.
    private String _category = "";
    private String _transactionCode = "";
    private String _transaction = "";

    // Getter

    public int getId() {
        return _id;
    }

    public String getCategory() {
        return _category;
    }

    public String getTransactionCode() {
        return _transactionCode;
    }

    public String getTransaction() {
        return _transaction;
    }

    // Setter

    public void setId(int id) {
        _id = id;
    }

    public void setCategory(String category) {
        _category = category;
    }

    public void setTransactionCode(String transactionCode) {
        _transactionCode = transactionCode;
    }

    public void setTransaction(String transaction) {
        _transaction = transaction;
    }
}
