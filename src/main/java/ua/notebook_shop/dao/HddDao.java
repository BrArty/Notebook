package ua.notebook_shop.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.notebook_shop.model.Hdd;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class HddDao {

    @PersistenceContext
    private EntityManager manager;

    public HddDao() {
    }

    public void persistHDD(Hdd hdd) {
        manager.persist(hdd);
    }

    public Hdd findHDD(int idHDD) {
        return manager.find(Hdd.class, idHDD);
    }

    public Hdd removeHDD(int idHDD) {
        Hdd hdd = manager.find(Hdd.class, idHDD);
        manager.remove(hdd);
        return hdd;
    }

    public void updateHDD(Hdd hdd) {
        Hdd hddFromDB = manager.find(Hdd.class, hdd.getId());

        if (hddFromDB == null) return;

        hddFromDB.setMemoryInGb(hdd.getMemoryInGb());

        manager.merge(hddFromDB);
    }

}
