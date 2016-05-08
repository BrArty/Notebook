package ua.notebook_shop.dao_implementation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.notebook_shop.dao_interfaces.ModelDao;
import ua.notebook_shop.model.Model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class ModelDaoImpl implements ModelDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void persistModel(Model model) {
        manager.persist(model);
    }

    @Override
    public Model findModel(int idModel) {
        return manager.find(Model.class, idModel);
    }

    @Override
    public Model removeModel(int idModel) {
        Model model = manager.find(Model.class, idModel);
        manager.remove(model);
        return model;
    }

    @Override
    public void updateModel(Model model) {

        Model modelFromDB = manager.find(Model.class, model.getId());

        if (modelFromDB == null) return;

        modelFromDB.setModel_name(model.getModel_name());

        manager.merge(modelFromDB);

    }
}
