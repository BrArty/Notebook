package ua.notebook_shop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.notebook_shop.model.Model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class ModelDao {

    @PersistenceContext
    private EntityManager manager;

    public ModelDao() {
    }

    public void persistModel(Model model) {
        manager.persist(model);
    }

    public Model findModel(int idModel) {
        return manager.find(Model.class, idModel);
    }

    public Model removeModel(int idModel) {
        Model model = manager.find(Model.class, idModel);
        manager.remove(model);
        return model;
    }

    public void updateModel(Model model) {

        Model modelFromDB = manager.find(Model.class, model.getId());

        if (modelFromDB == null) return;

        modelFromDB.setModel_name(model.getModel_name());

        manager.merge(modelFromDB);

    }
}
