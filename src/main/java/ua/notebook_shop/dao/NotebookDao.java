package ua.notebook_shop.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.notebook_shop.model.Notebook;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class NotebookDao {

    @PersistenceContext
    private EntityManager manager;

    public void persistNotebook(Notebook notebook) {
        manager.persist(notebook);
    }

    public Notebook findNotebook(int idNotebook) {
        return manager.find(Notebook.class, idNotebook);
    }

    public Notebook removeNotebook(int idNotebook) {
        Notebook notebook = manager.find(Notebook.class, idNotebook);
        manager.remove(notebook);
        return notebook;
    }

    public void updateNotebook(Notebook notebook) {

        Notebook notebookFromDB = manager.find(Notebook.class, notebook.getId());

        if (notebookFromDB == null) return;

        notebookFromDB.setVideo(notebook.getVideo());
        notebookFromDB.setRam(notebook.getRam());
        notebookFromDB.setScreen(notebook.getScreen());
        notebookFromDB.setModel(notebook.getModel());
        notebookFromDB.setHdd(notebook.getHdd());
        notebookFromDB.setProcessor(notebook.getProcessor());

        manager.merge(notebookFromDB);
    }
}
