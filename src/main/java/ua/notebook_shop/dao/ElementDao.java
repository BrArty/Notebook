package ua.notebook_shop.dao;


import ua.notebook_shop.model.Element;

import java.util.List;

public interface ElementDao {
    void saveElement(Element element);
    List getAll(Class clazz);
    Element getElement(Class clazz, int elementId);
}
