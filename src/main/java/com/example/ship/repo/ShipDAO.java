package com.example.ship.repo;

import com.example.ship.entity.Ship;
import com.example.ship.exception.ShipException;
import com.example.ship.model.ShipInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ShipDAO {

    @Autowired
    private EntityManager entityManager;

    public ShipDAO() {

    }

    public Ship findById(Long id) {
        return this.entityManager.find(Ship.class, id);
    }

    public List<ShipInfo> listShips() {
        String sql = "Select new " + ShipInfo.class.getName() //
                + "(e.id,e.name,e.km) " //
                + " from " + Ship.class.getName() + " e ";

        Query query = entityManager.createQuery(sql, ShipInfo.class);

        return query.getResultList();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,
    rollbackFor = ShipException.class)
    public void addkm(Long accountId, double amount) throws ShipException {
        Ship ship = this.findById(accountId);

        if (ship == null ) {
            throw new ShipException("account not found " + accountId);
        }

        double newKm = ship.getKm() + amount;

        ship.setKm(newKm);
    }
}
