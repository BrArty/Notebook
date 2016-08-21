package ua.notebook_shop.service;


import ua.notebook_shop.exceptions.AlreadyExistsException;
import ua.notebook_shop.exceptions.ElementNotFountException;
import ua.notebook_shop.model.Notebook;
import ua.notebook_shop.model.WarehouseItem;

import java.util.List;

public interface WarehouseService {
    WarehouseItem getWarehouseItem(int id);

    void takeNotebooks(double price, Notebook notebook, int amount) throws AlreadyExistsException;

    void takeNotebooks(WarehouseItem item) throws AlreadyExistsException;

    void debitNotebooks(Notebook notebook, int amount);

    int reportBalances(String ramMemory) throws ElementNotFountException;

    int reportBalances(double screenSize);

    Notebook reportBalances(int inStock);

    List getAll();
}
