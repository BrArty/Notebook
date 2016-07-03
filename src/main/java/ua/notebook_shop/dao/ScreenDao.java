package ua.notebook_shop.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.notebook_shop.exceptions.AlreadyExistsException;
import ua.notebook_shop.model.Screen;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
public class ScreenDao {

    @PersistenceContext
    private EntityManager manager;

    public ScreenDao() {
    }

    public void saveScreen(Screen screen) throws AlreadyExistsException{
        if (manager.find(Screen.class, screen.getId()) == null) {
            manager.persist(screen);
        } else throw new AlreadyExistsException("This screen is already exists");
    }

    public Screen findScreen(int idScreen) {
        return manager.find(Screen.class, idScreen);
    }

    public Screen removeScreen(int idScreen) {
        Screen screen = manager.find(Screen.class, idScreen);
        manager.remove(screen);
        return screen;
    }

    public List getAll() {
        return manager.createQuery("SELECT s FROM Screen s").getResultList();
    }

    public void updateScreen(Screen screen) {

        Screen screenFromDB = manager.find(Screen.class, screen.getId());

        if (screenFromDB == null) return;

        screenFromDB.setSize(screen.getSize());

        manager.merge(screenFromDB);

    }

}
