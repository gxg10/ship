package com.example.jpa.dao;

import com.example.jpa.entity.BankAccount;
import com.example.jpa.exception.BankTransactionException;
import com.example.jpa.model.BankAccountInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BankAccountDAO {

    @Autowired
    private EntityManager entityManager;

    public BankAccountDAO() {
    }

    public BankAccount findById(Long id) {
        return this.entityManager.find(BankAccount.class, id);
    }

    public List<BankAccountInfo> listBankAccountInfo() {
        String sql = "Select new " + BankAccountInfo.class.getName()
                + "(e.id, e.fullName, e.balance)"
                + " from " + BankAccount.class.getName() + " e";
        Query query = entityManager.createQuery(sql, BankAccountInfo.class);

        return query.getResultList();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void addAmount(Long id, double amount) throws BankTransactionException {
        BankAccount account = this.findById(id);

        if (account == null) {
            throw new BankTransactionException("account not found " + id);
        }

        double newBalance = account.getBallance() + amount;

        if (account.getBallance() + amount< 0) {
            throw new BankTransactionException("the mony in the account " +
                    id + " is not enought ");
        }
        account.setBallance(newBalance);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,
    rollbackFor = BankTransactionException.class)
    public void sendMoney(Long fromAccountId, Long toAccountId, double amount)
        throws BankTransactionException {
        addAmount(toAccountId, amount);
        addAmount(fromAccountId, -amount);
    }
}
