package ua.notebook_shop.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import ua.notebook_shop.model.Element;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@EnableTransactionManagement
public class ElementDaoImpl implements ElementDao {

    @PersistenceContext
    private EntityManager manager;

    public ElementDaoImpl() {
    }

    @Override
    @Transactional
    public void saveElement(Element element) {
        manager.persist(element);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public Element getElement(Class clazz, int elementId) {
        return (Element) manager.find(clazz, elementId);
    }

    @Override
    @Transactional
    public List getAll(Class clazz) {
        String className = clazz.toString();
        Pattern p = Pattern.compile("[^\\d]\\.[\\s]*([A-Z][A-z]*)");  //delete "ua.notebook_shop.model" part of string
        Matcher m = p.matcher(className);
        if (m.find()) {
            return manager.createQuery("SELECT e FROM " + m.group(1) + " e").getResultList();
        }
        return null;
    }
}
