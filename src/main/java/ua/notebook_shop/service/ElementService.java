package ua.notebook_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.notebook_shop.dao.ElementDao;
import ua.notebook_shop.model.Element;

import java.util.List;

@Service
public class ElementService {

    private ElementDao elementDao;

    @Autowired
    public ElementService(ElementDao elementDao) {
        this.elementDao = elementDao;
    }

    public void addElement(Element element) {
        elementDao.saveElement(element);
    }

    public List getAllElements(Class clazz) {
        return elementDao.getAll(clazz);
    }

    public Element getElement(Class clazz, int elementId) {
        return elementDao.getElement(clazz, elementId);
    }

}
