package ua.notebook_shop.dao_interfaces;

import ua.notebook_shop.model.Model;

public interface ModelDao {

    void persistModel(Model model);

    Model findModel(int idModel);

    Model removeModel(int idModel);

    void updateModel(Model model);

}
