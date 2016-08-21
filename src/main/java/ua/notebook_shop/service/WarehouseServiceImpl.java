package ua.notebook_shop.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.notebook_shop.dao.WarehouseDao;
import ua.notebook_shop.exceptions.AlreadyExistsException;
import ua.notebook_shop.exceptions.ElementNotFountException;
import ua.notebook_shop.model.Notebook;
import ua.notebook_shop.model.WarehouseItem;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    private WarehouseDao dao;

    @Autowired
    public WarehouseServiceImpl(WarehouseDao dao) {
        this.dao = dao;
    }

    @Override
    public WarehouseItem getWarehouseItem(int id) {
        return dao.getWarehouseItem(id);
    }

    @Override
    public void takeNotebooks(double price, Notebook notebook, int amount) throws AlreadyExistsException {
        dao.takeNotebooks(price, notebook, amount);
    }

    @Override
    public void takeNotebooks(WarehouseItem item) throws AlreadyExistsException {
        dao.takeNotebooks(item);
    }

    @Override
    public void debitNotebooks(Notebook notebook, int amount) {
        dao.debitNotebooks(notebook, amount);
    }

    @Override
    public int reportBalances(String ramMemory) throws ElementNotFountException {
        return dao.reportBalances(ramMemory);
    }

    @Override
    public int reportBalances(double screenSize) {
        return dao.reportBalances(screenSize);
    }

    @Override
    public Notebook reportBalances(int inStock) {
        return dao.reportBalances(inStock);
    }

    @Override
    public List getAll() {
        return dao.getAll();
    }
}
