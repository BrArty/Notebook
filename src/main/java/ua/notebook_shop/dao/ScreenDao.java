package ua.notebook_shop.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.notebook_shop.model.Screen;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class ScreenDao {

    @PersistenceContext
    private EntityManager manager;

    public ScreenDao() {
    }

    public void persistScreen(Screen screen) {
        manager.persist(screen);
    }

    public Screen findScreen(int idScreen) {
        return manager.find(Screen.class, idScreen);
    }

    public Screen removeScreen(int idScreen) {
        Screen screen = manager.find(Screen.class, idScreen);
        manager.remove(screen);
        return screen;
    }

    public void updateScreen(Screen screen) {

        Screen screenFromDB = manager.find(Screen.class, screen.getId());

        if (screenFromDB == null) return;

        screenFromDB.setSize(screen.getSize());

        manager.merge(screenFromDB);

    }

}
