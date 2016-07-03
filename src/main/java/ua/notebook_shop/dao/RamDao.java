package ua.notebook_shop.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.notebook_shop.exceptions.AlreadyExistsException;
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

    public void saveRam(Ram ram) throws AlreadyExistsException {
        if (manager.find(Ram.class, ram.getId()) == null) {
            manager.persist(ram);
        } else throw new AlreadyExistsException("This ram is already exists");
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
        return manager.createQuery("SELECT r FROM Ram r").getResultList();
    }

    public void updateRam(Ram ram) {
        Ram ramFromDB = manager.find(Ram.class, ram.getId());

        if (ramFromDB == null) return;

        ramFromDB.setMemoryInGb(ram.getMemoryInGb());

        manager.merge(ramFromDB);
    }
}
