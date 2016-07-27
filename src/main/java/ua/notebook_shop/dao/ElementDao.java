package ua.notebook_shop.dao;


import ua.notebook_shop.exceptions.AlreadyExistsException;
import ua.notebook_shop.model.Element;

import java.util.List;

public interface ElementDao {
    void saveElement(Element element) throws AlreadyExistsException;
    List getAll(Class clazz);
    Element getElement(Class clazz, int elementId);
}
