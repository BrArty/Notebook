package ua.notebook_shop.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.notebook_shop.model.Ram;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
public class RamDao {

    @PersistenceContext
    private EntityManager manager;

    public RamDao() {
    }

    public void saveRam(Ram ram) {
        manager.persist(ram);
    }

    public Ram findRam(int idRam) {
        return manager.find(Ram.class, idRam);
    }

    public Ram removeRam(int idRam) {
        Ram ram = manager.find(Ram.class, idRam);
        manager.remove(ram);
        return ram;
    }

    public List getAll() {
        return manager.createQuery("SELECT m FROM Ram m").getResultList();
    }

    public void updateRam(Ram ram) {
        Ram ramFromDB = manager.find(Ram.class, ram.getId());

        if (ramFromDB == null) return;

        ramFromDB.setMemoryInGb(ram.getMemoryInGb());

        manager.merge(ramFromDB);
    }
}
