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

    public void deleteNotebook(int idNotebook) {
        Notebook notebook = manager.find(Notebook.class, idNotebook);
        manager.createQuery("DELETE FROM Notebook WHERE id = :id").setParameter("id", notebook.getId()).executeUpdate();
    }

    public void setModel(Model model) {
        Model modelFromDb = manager.find(Model.class, model.getId());
        if (modelFromDb == null) return;
        Notebook notebook = (Notebook) manager.createQuery("SELECT n FROM Notebook n WHERE Model = :model")
                .setParameter("model", model);
        notebook.setModel(modelFromDb);
    }

    public void setProcessor(Processor processor) {
        Processor processorFromDb = manager.find(Processor.class, processor.getId());
        if (processorFromDb == null) return;
        Notebook notebook = (Notebook) manager.createQuery("SELECT n FROM Notebook n WHERE Processor = :processor")
                .setParameter("processor", processor);
        notebook.setProcessor(processorFromDb);
    }

    public void setRam(Ram ram) {
        Ram ramFromDb = manager.find(Ram.class, ram.getId());
        if (ramFromDb == null) return;
        Notebook notebook = (Notebook) manager.createQuery("SELECT n FROM Notebook n WHERE Ram = :ram")
                .setParameter("ram", ram);
        notebook.setRam(ramFromDb);
    }

    public Screen setScreen(Screen screen) {
        Screen screenFromDb = manager.find(Screen.class, screen.getId());
        if (screenFromDb == null) return null;
        Notebook notebook = (Notebook) manager.createQuery("SELECT n FROM Notebook n WHERE Screen = :screen")
                .setParameter("screen", screen);
        notebook.setScreen(screenFromDb);
        return screenFromDb;
    }

    public Screen setScreen(int screenId) {
        Screen screenFromDb = manager.find(Screen.class, screenId);
        if (screenFromDb == null) return null;
        return (Screen) manager.createQuery("SELECT s FROM Screen s WHERE Screen.id = :screenId")
                .setParameter("screenId", screenId);
    }

    public void setVideo(VideoMemory video) {
        VideoMemory videoFromDb = manager.find(VideoMemory.class, video.getId());
        if (videoFromDb == null) return;
        Notebook notebook = (Notebook) manager.createQuery("SELECT n FROM Notebook n WHERE VideoMemory = :video")
                .setParameter("video", video);
        notebook.setVideo(videoFromDb);
    }

    public void setHdd(Hdd hdd) {
        Hdd hddFromDb = manager.find(Hdd.class, hdd.getId());
        if (hddFromDb == null) return;
        Notebook notebook = (Notebook) manager.createQuery("SELECT n FROM Notebook n WHERE Hdd = :hdd")
                .setParameter("hdd", hdd);
        notebook.setHdd(hddFromDb);
    }

    public Hdd getHdd(int notebookId) {
        Notebook notebook = manager.find(Notebook.class, notebookId);
        Hdd hdd = notebook.getHdd();
        return manager.find(Hdd.class, hdd.getId());
    }

    public Model getModel(int notebookId) {
        Notebook notebook = manager.find(Notebook.class, notebookId);
        Model model = notebook.getModel();
        return manager.find(Model.class, model.getId());
    }

    public Processor getProcessor(int notebookId) {
        Notebook notebook = manager.find(Notebook.class, notebookId);
        Processor processor = notebook.getProcessor();
        return manager.find(Processor.class, processor.getId());
    }

    public Ram getRam(int notebookId) {
        Notebook notebook = manager.find(Notebook.class, notebookId);
        Ram ram = notebook.getRam();
        return manager.find(Ram.class, ram.getId());
    }

    public VideoMemory getVideo(int notebookId) {
        Notebook notebook = manager.find(Notebook.class, notebookId);
        VideoMemory videoMemory = notebook.getVideo();
        return manager.find(VideoMemory.class, videoMemory.getId());
    }

    public Screen getScreen(int notebookId) {
        Notebook notebook = manager.find(Notebook.class, notebookId);
        Screen screen = notebook.getScreen();
        return manager.find(Screen.class, screen.getId());
    }

    public Notebook removeNotebook(int idNotebook) {
        Notebook notebook = manager.find(Notebook.class, idNotebook);
        manager.remove(notebook);
        return notebook;
    }

    public List getAll() {
        return manager.createQuery("SELECT m FROM Notebook m").getResultList();
    }

    public Notebook updateNotebook(Notebook notebook) {

        Notebook notebookFromDB = manager.find(Notebook.class, notebook.getId());

        if (notebookFromDB == null) return null;

        notebookFromDB.setVideo(notebook.getVideo());
        notebookFromDB.setRam(notebook.getRam());
        notebookFromDB.setScreen(notebook.getScreen());
        notebookFromDB.setModel(notebook.getModel());
        notebookFromDB.setHdd(notebook.getHdd());
        notebookFromDB.setProcessor(notebook.getProcessor());

        manager.merge(notebookFromDB);
        return notebookFromDB;
    }
}
