package ua.notebook_shop.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import ua.notebook_shop.exceptions.CreateException;
import ua.notebook_shop.model.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@EnableTransactionManagement
public class NotebookDaoImpl implements NotebookDao {

    @PersistenceContext
    private EntityManager manager;

    private static final Logger LOG = Logger.getLogger(NotebookDaoImpl.class);

    public NotebookDaoImpl() {
    }

    @Override
    @Transactional
    public void saveNotebook(Notebook notebook) throws CreateException {
        try {
            String query = "SELECT n FROM Notebook n WHERE n.notebook_name = :name AND n.hdd.id = :hdd AND " +
                    "n.model.id = :model AND n.processor.id = :proc AND n.ram.id = :ram AND n.screen.id = :screen AND " +
                    "n.video.id = :video";
            Notebook noteToCheck = (Notebook) manager.createQuery(query).setParameter("name", notebook.getNotebook_name())
                    .setParameter("hdd", notebook.getHdd().getId()).setParameter("model", notebook.getModel().getId())
                    .setParameter("proc", notebook.getProcessor().getId()).setParameter("ram", notebook.getRam().getId())
                    .setParameter("screen", notebook.getScreen().getId()).setParameter("video", notebook.getVideo().getId())
                    .getSingleResult();
            if (noteToCheck.equals(notebook)) {
                throw new CreateException("This notebook is already persisted!");
            }
        } catch (NoResultException nre) {
            LOG.info("Notebook not found");
            manager.persist(notebook);
            LOG.info("Successfully persisted");
        }
    }

    @Override
    @Transactional
    public List findNotebook(String notebookName) {
        return manager.createQuery("Select n FROM Notebook n WHERE n.notebook_name = :name")
                .setParameter("name", notebookName).getResultList();
    }

    @Override
    @Transactional
    public Notebook findNotebook(int idNotebook) {
//        return (Notebook) manager.createQuery("SELECT n FROM Notebook n WHERE id = :id").setParameter("id", idNotebook);
        return manager.find(Notebook.class, idNotebook);
    }

    public boolean checkForDuplicate(String notebook_name, int model, int hdd,
                                     int processor, int screen, int video, int ram, Notebook noteToCheck) {
        String query = "SELECT Notebook FROM Notebook WHERE notebook_name = :name AND model.id = :model " +
                "AND hdd.id = :hdd AND processor.id = :processor AND screen.id = :screen AND video.id = :video " +
                "AND ram.id = :ram";
        Notebook notebook = (Notebook) manager.createQuery(query).setParameter("name", notebook_name)
                .setParameter("model", model).setParameter("hdd", hdd).setParameter("processor", processor)
                .setParameter("screen", screen).setParameter("video", video).setParameter("ram", ram).getSingleResult();
        return true;
    }

    @Override
    @Transactional
    public void deleteNotebook(int idNotebook) {
        Notebook notebook = manager.find(Notebook.class, idNotebook);
        manager.createQuery("DELETE FROM Notebook WHERE id = :id").setParameter("id", notebook.getId()).executeUpdate();
    }

    @Override
    @Transactional
    public void setModel(Model model) {
        Model modelFromDb = manager.find(Model.class, model.getId());
        if (modelFromDb == null) return;
        Notebook notebook = (Notebook) manager.createQuery("SELECT n FROM Notebook n WHERE Model = :model")
                .setParameter("model", model);
        notebook.setModel(modelFromDb);
    }

    @Override
    @Transactional
    public void setProcessor(Processor processor) {
        Processor processorFromDb = manager.find(Processor.class, processor.getId());
        if (processorFromDb == null) return;
        Notebook notebook = (Notebook) manager.createQuery("SELECT n FROM Notebook n WHERE Processor = :processor")
                .setParameter("processor", processor);
        notebook.setProcessor(processorFromDb);
    }

    @Override
    @Transactional
    public void setRam(Ram ram) {
        Ram ramFromDb = manager.find(Ram.class, ram.getId());
        if (ramFromDb == null) return;
        Notebook notebook = (Notebook) manager.createQuery("SELECT n FROM Notebook n WHERE Ram = :ram")
                .setParameter("ram", ram);
        notebook.setRam(ramFromDb);
    }

    @Override
    @Transactional
    public Screen setScreen(Screen screen) {
        Screen screenFromDb = manager.find(Screen.class, screen.getId());
        if (screenFromDb == null) return null;
        Notebook notebook = (Notebook) manager.createQuery("SELECT n FROM Notebook n WHERE Screen = :screen")
                .setParameter("screen", screen);
        notebook.setScreen(screenFromDb);
        return screenFromDb;
    }

    @Override
    @Transactional
    public Screen setScreen(int screenId) {
        Screen screenFromDb = manager.find(Screen.class, screenId);
        if (screenFromDb == null) return null;
        return (Screen) manager.createQuery("SELECT s FROM Screen s WHERE Screen.id = :screenId")
                .setParameter("screenId", screenId);
    }

    @Override
    @Transactional
    public void setVideo(VideoMemory video) {
        VideoMemory videoFromDb = manager.find(VideoMemory.class, video.getId());
        if (videoFromDb == null) return;
        Notebook notebook = (Notebook) manager.createQuery("SELECT n FROM Notebook n WHERE VideoMemory = :video")
                .setParameter("video", video);
        notebook.setVideo(videoFromDb);
    }

    @Override
    @Transactional
    public void setHdd(Hdd hdd) {
        Hdd hddFromDb = manager.find(Hdd.class, hdd.getId());
        if (hddFromDb == null) return;
        Notebook notebook = (Notebook) manager.createQuery("SELECT n FROM Notebook n WHERE Hdd = :hdd")
                .setParameter("hdd", hdd);
        notebook.setHdd(hddFromDb);
    }

    @Override
    @Transactional
    public Hdd getHdd(int notebookId) {
        Notebook notebook = manager.find(Notebook.class, notebookId);
        Hdd hdd = notebook.getHdd();
        return manager.find(Hdd.class, hdd.getId());
    }

    @Override
    @Transactional
    public Model getModel(int notebookId) {
        Notebook notebook = manager.find(Notebook.class, notebookId);
        Model model = notebook.getModel();
        return manager.find(Model.class, model.getId());
    }

    @Override
    @Transactional
    public Processor getProcessor(int notebookId) {
        Notebook notebook = manager.find(Notebook.class, notebookId);
        Processor processor = notebook.getProcessor();
        return manager.find(Processor.class, processor.getId());
    }

    @Override
    @Transactional
    public Ram getRam(int notebookId) {
        Notebook notebook = manager.find(Notebook.class, notebookId);
        Ram ram = notebook.getRam();
        return manager.find(Ram.class, ram.getId());
    }

    @Override
    @Transactional
    public VideoMemory getVideo(int notebookId) {
        Notebook notebook = manager.find(Notebook.class, notebookId);
        VideoMemory videoMemory = notebook.getVideo();
        return manager.find(VideoMemory.class, videoMemory.getId());
    }

    @Override
    @Transactional
    public Screen getScreen(int notebookId) {
        Notebook notebook = manager.find(Notebook.class, notebookId);
        Screen screen = notebook.getScreen();
        return manager.find(Screen.class, screen.getId());
    }

    @Override
    @Transactional
    public Notebook removeNotebook(int idNotebook) {
        Notebook notebook = manager.find(Notebook.class, idNotebook);
        manager.remove(notebook);
        return notebook;
    }

    @Override
    @Transactional
    public List getAll() {
        return manager.createQuery("SELECT n FROM Notebook n").getResultList();
    }

    @Override
    @Transactional
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
