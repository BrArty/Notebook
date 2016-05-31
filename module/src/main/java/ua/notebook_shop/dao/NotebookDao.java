package ua.notebook_shop.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.notebook_shop.model.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
public class NotebookDao {

    @PersistenceContext
    private EntityManager manager;

    public NotebookDao() {

    }

    public void saveNotebook(Notebook notebook) {
        manager.persist(notebook);
    }

    public Notebook findNotebook(int idNotebook) {
        return manager.find(Notebook.class, idNotebook);
    }

    public void chooseElements(int notebookId, Model model, Hdd hdd, Processor processor, Ram ram, Screen screen, VideoMemory videoMemory) {
        manager.createQuery("UPDATE Notebook SET model = :model, processor = :processor, " +
                "ram = :ram, screen = :screen, videoMemory = :video, hdd = :hdd WHERE id = :id", Notebook.class)
                .setParameter("model", model).setParameter("processor", processor)
                .setParameter("ram", ram).setParameter("screen", screen).setParameter("video", videoMemory)
                .setParameter("hdd", hdd).setParameter("id", notebookId).executeUpdate();
    }

    public Notebook removeNotebook(int idNotebook) {
        Notebook notebook = manager.find(Notebook.class, idNotebook);
        manager.remove(notebook);
        return notebook;
    }

    public List getAll() {
        return manager.createQuery("SELECT m FROM Notebook m").getResultList();
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
