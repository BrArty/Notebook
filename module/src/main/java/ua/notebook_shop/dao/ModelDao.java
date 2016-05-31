package ua.notebook_shop.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.notebook_shop.model.Model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
public class ModelDao {

    @PersistenceContext
    private EntityManager manager;

    public ModelDao() {
    }

    public Model saveModel(Model model) {
        manager.persist(model);
        return model;
    }

    public Model findModel(int idModel) {
        return manager.find(Model.class, idModel);
    }

    public Model removeModel(int idModel) {
        Model model = manager.find(Model.class, idModel);
        manager.remove(model);
        return model;
    }

    public List getAll() {
        return manager.createQuery("SELECT m FROM Model m").getResultList();
    }

    public void updateModel(Model model) {

        Model modelFromDB = manager.find(Model.class, model.getId());

        if (modelFromDB == null) return;

        modelFromDB.setModel(model.getModel());

        manager.merge(modelFromDB);

    }
}
