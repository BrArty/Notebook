package ua.notebook_shop.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import ua.notebook_shop.exceptions.AlreadyExistsException;
import ua.notebook_shop.exceptions.ElementNotFountException;
import ua.notebook_shop.model.Notebook;
import ua.notebook_shop.model.WarehouseItem;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@EnableTransactionManagement
public class WarehouseDaoImpl implements WarehouseDao {

    @PersistenceContext
    private EntityManager manager;

    private static final Logger LOG = Logger.getLogger(WarehouseDaoImpl.class);

    public WarehouseDaoImpl() {
    }

    @Override
    @Transactional
    public WarehouseItem getWarehouseItem(int id) {
        return (WarehouseItem) manager.createQuery("SELECT w FROM WarehouseItem w WHERE w.id = :id")
                .setParameter("id", id).getSingleResult();
    }

    @Override
    @Transactional
    public void takeNotebooks(double price, Notebook notebook, int amount) throws AlreadyExistsException {
        WarehouseItem item;
        try {
            item = (WarehouseItem) manager.createQuery("SELECT w FROM WarehouseItem w WHERE w.notebook.id = :id")
                    .setParameter("id", notebook.getId()).getSingleResult();
            if (item != null) {
                throw new AlreadyExistsException("Notebook is already in stock");
            }
        } catch (NoResultException ex) {
            item = new WarehouseItem(price, notebook, amount);
            manager.persist(item);
        }
    }

    @Override
    @Transactional
    public void takeNotebooks(WarehouseItem item) throws AlreadyExistsException {
        Notebook notebook;
        try {
            notebook = (Notebook) manager.createQuery("SELECT n FROM Notebook n WHERE n.id = :id")
                    .setParameter("id", item.getNotebook().getId()).getSingleResult();
            if (item.getNotebook().equals(notebook)) {
                throw new AlreadyExistsException("Notebook is already in stock");
            }
        } catch (NoResultException nre) {
            manager.persist(item);
        }
    }

    @Override
    @Transactional
    public void debitNotebooks(Notebook notebook, int amount) {
        WarehouseItem item = (WarehouseItem) manager.createQuery("SELECT w FROM WarehouseItem w WHERE w.notebook.id = :id")
                .setParameter("id", notebook.getId()).getSingleResult();
        WarehouseItem itemFromDb = manager.find(WarehouseItem.class, item.getId());
        itemFromDb.setAmount(amount);
        manager.merge(itemFromDb);
    }

    @Override
    @Transactional
    public int reportBalances(String ramMemory) throws ElementNotFountException {
        try {
            return (int) manager.createQuery("SELECT amount FROM WarehouseItem WHERE notebook.ram.memoryInGb = :ram")
                    .setParameter("ram", ramMemory).getSingleResult();
        } catch (NoResultException ex) {
            throw new NoResultException("Notebook with this ram parameters doesn't exist in stock");
        }
    }

    @Override
    @Transactional
    public int reportBalances(double screenSize) {
        try {
            return (int) manager.createQuery("SELECT amount FROM WarehouseItem WHERE notebook.screen.size = :size")
                    .setParameter("size", screenSize).getSingleResult();
        } catch (NoResultException ex) {
            throw new NoResultException("Notebook with this screen parameters doesn't exist in stock");
        }
    }

    @Override
    @Transactional
    public Notebook reportBalances(int inStock) {
        try {
            int id = (int) manager.createQuery("SELECT notebook.id FROM WarehouseItem WHERE amount = :amount")
                    .setParameter("amount", inStock).getSingleResult();
            return manager.find(Notebook.class, id);
        } catch (NoResultException ex) {
            throw new NoResultException("No notebooks of this amount is in stock");
        }
    }

    @Override
    @Transactional
    public List getAll() {
        return manager.createQuery("SELECT w FROM WarehouseItem w").getResultList();
    }
}
