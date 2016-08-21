package ua.notebook_shop.service;


import ua.notebook_shop.model.Element;

import java.util.List;

public interface ElementService {
    void addElement(Element element);

    List getAllElements(Class clazz);

    Element getElement(Class clazz, int elementId);
}
