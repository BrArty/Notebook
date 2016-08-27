package ua.notebook_shop.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.notebook_shop.dao.NotebookDao;
import ua.notebook_shop.exceptions.CreateException;
import ua.notebook_shop.model.*;

import java.util.List;

@Service
public class NotebookServiceImpl implements NotebookService {

    private static final Logger LOG = Logger.getLogger(NotebookServiceImpl.class);

    private NotebookDao notebookDao;

    @Autowired
    public NotebookServiceImpl(NotebookDao notebookDao) {
        this.notebookDao = notebookDao;
    }

    public Notebook getNotebook(int idNotebook) {
        return notebookDao.findNotebook(idNotebook);
    }

    public void addNotebook(Notebook notebook) throws CreateException {
        if (!isNullElements(notebook)) {
            notebookDao.saveNotebook(notebook);
        } else throw new CreateException("Choose all elements!");
    }

    public List getAllNotebooks() {
        return notebookDao.getAll();
    }

    public void deleteNotebook(Notebook notebook) {
        notebookDao.deleteNotebook(notebook.getId());
    }

    public void setModel(Model model, int notebookId) {
        Notebook notebook = notebookDao.findNotebook(notebookId);
        notebook.setModel(model);
        notebookDao.updateNotebook(notebook);
    }

    public Model getModel(int notebookId) {
        Notebook notebook = notebookDao.findNotebook(notebookId);
        return notebook.getModel();
    }

    public void setScreen(Screen screen, int notebookId) {
        Notebook notebook = notebookDao.findNotebook(notebookId);
        notebook.setScreen(screen);
        notebookDao.updateNotebook(notebook);
    }

    public Screen getScreen(int notebookId) {
        Notebook notebook = notebookDao.findNotebook(notebookId);
        return notebook.getScreen();
    }

    public Hdd getHdd(int notebookId) {
        Notebook notebook = notebookDao.findNotebook(notebookId);
        return notebook.getHdd();
    }

    public void setHdd(Hdd hdd, int notebookId) {
        Notebook notebook = notebookDao.findNotebook(notebookId);
        notebook.setHdd(hdd);
        notebookDao.updateNotebook(notebook);
    }

    public Processor getProcessor(int notebookId) {
        Notebook notebook = notebookDao.findNotebook(notebookId);
        return notebook.getProcessor();
    }

    public void setProcessor(Processor processor, int notebookId) {
        Notebook notebook = notebookDao.findNotebook(notebookId);
        notebook.setProcessor(processor);
        notebookDao.updateNotebook(notebook);
    }

    public Ram getRam(int notebookId) {
        Notebook notebook = notebookDao.findNotebook(notebookId);
        return notebook.getRam();
    }

    public void setRam(Ram ram, int notebookId) {
        Notebook notebook = notebookDao.findNotebook(notebookId);
        notebook.setRam(ram);
        notebookDao.updateNotebook(notebook);
    }

    public VideoMemory getVideo(int notebookId) {
        Notebook notebook = notebookDao.findNotebook(notebookId);
        return notebook.getVideo();
    }

    public void setVideo(VideoMemory videoMemory, int notebookId) {
        Notebook notebook = notebookDao.findNotebook(notebookId);
        notebook.setVideo(videoMemory);
        notebookDao.updateNotebook(notebook);
    }

    public boolean isNullElements(Notebook notebook) {
        return notebook.getScreen() == null || notebook.getVideo() == null ||
                notebook.getRam() == null || notebook.getProcessor() == null ||
                notebook.getModel() == null || notebook.getNotebook_name().trim().equals("");
    }
}