package com.example.ship.form;

public class SendMoneyForm {

    private Long fromAccountId;
    private Double amount;

    public SendMoneyForm() {

    }

    public SendMoneyForm(Long fromAccountId, Double amount) {
        this.fromAccountId = fromAccountId;
        this.amount = amount;
    }

    public Long getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }


    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
