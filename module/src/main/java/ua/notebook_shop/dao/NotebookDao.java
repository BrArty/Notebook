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

    public void setModel(Model model) {
        Model modelFromDb = manager.find(Model.class, model.getId());
        if (modelFromDb == null) return;
        Notebook notebook = (Notebook) manager.createQuery("SELECT n FROM Notebook n WHERE model = :model")
                .setParameter("model", model);
        notebook.setModel(modelFromDb);
    }

    public void setProcessor(Processor processor) {
        Processor processorFromDb = manager.find(Processor.class, processor.getId());
        if (processorFromDb == null) return;
        Notebook notebook = (Notebook) manager.createQuery("SELECT n FROM Notebook n WHERE processor = :processor")
                .setParameter("processor", processor);
        notebook.setProcessor(processorFromDb);
    }

    public void setRam(Ram ram) {
        Ram ramFromDb = manager.find(Ram.class, ram.getId());
        if (ramFromDb == null) return;
        Notebook notebook = (Notebook) manager.createQuery("SELECT n FROM Notebook n WHERE ram = :ram")
                .setParameter("ram", ram);
        notebook.setRam(ramFromDb);
    }

    public Screen setScreen(Screen screen) {
        Screen screenFromDb = manager.find(Screen.class, screen.getId());
        if (screenFromDb == null) return null;
        Notebook notebook = (Notebook) manager.createQuery("SELECT n FROM Notebook n WHERE screen = :screen")
                .setParameter("screen", screen);
        notebook.setScreen(screenFromDb);
        return screenFromDb;
    }

    public Screen getScreen() {
        return (Screen) manager.createQuery("SELECT Screen FROM Notebook").getSingleResult();
    }

    public Screen setScreen(int screenId) {
        Screen screenFromDb = manager.find(Screen.class, screenId);
        if (screenFromDb == null) return null;
        Screen screen = (Screen) manager.createQuery("SELECT s FROM Screen s WHERE id = :screenId")
                .setParameter("screenId", screenId);
        return screen;
    }

    public void setVideo(VideoMemory video) {
        VideoMemory videoFromDb = manager.find(VideoMemory.class, video.getId());
        if (videoFromDb == null) return;
        Notebook notebook = (Notebook) manager.createQuery("SELECT n FROM Notebook n WHERE Video = :video")
                .setParameter("video", video);
        notebook.setVideo(videoFromDb);
    }

    public void setHdd(Hdd hdd) {
        Hdd hddFromDb = manager.find(Hdd.class, hdd.getId());
        if (hddFromDb == null) return;
        Notebook notebook = (Notebook) manager.createQuery("SELECT n FROM Notebook n WHERE hdd = :hdd")
                .setParameter("hdd", hdd);
        notebook.setHdd(hddFromDb);
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
