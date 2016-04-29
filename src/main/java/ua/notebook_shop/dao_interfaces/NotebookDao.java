package ua.notebook_shop.dao_interfaces;


import ua.notebook_shop.model.Notebook;

public interface NotebookDao {
    Notebook create(Notebook notebook);
    Notebook delete(int id);
    Notebook find(int id);
}
