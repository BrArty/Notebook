package ua.notebook_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.notebook_shop.dao.*;
import ua.notebook_shop.model.*;

import java.util.List;

@Service
public class NotebookService {

    @Autowired
    NotebookDao notebookDao;
    @Autowired
    HddDao hddDao;
    @Autowired
    ModelDao modelDao;
    @Autowired
    ProcessorDao processorDao;
    @Autowired
    RamDao ramDao;
    @Autowired
    ScreenDao screenDao;
    @Autowired
    VideoMemoryDao videoMemoryDao;

    public Notebook getNotebook(int idNotebook) {
        return notebookDao.findNotebook(idNotebook);
    }

    public void addNotebook(Notebook notebook) {
        Notebook notebookFromDB = notebookDao.findNotebook(notebook.getId());
        if (notebookFromDB == null) notebookDao.saveNotebook(notebook);
        else notebookDao.updateNotebook(notebook);
    }

    public Model getModel(int notebookId) {
        Notebook notebook = notebookDao.findNotebook(notebookId);
        return notebook.getModel();
    }

    public Notebook setScreen(Screen screen, int notebookId) {
        Notebook notebook = notebookDao.findNotebook(notebookId);
        notebook.setScreen(screen);
        notebookDao.updateNotebook(notebook);
        return notebook;
    }

    public Hdd getHdd(int notebookId) {
        Notebook notebook = notebookDao.findNotebook(notebookId);
        return notebook.getHdd();
    }

    public Processor getProcessor(int notebookId) {
        Notebook notebook = notebookDao.findNotebook(notebookId);
        return notebook.getProcessor();
    }

    public Ram getRam(int notebookId) {
        Notebook notebook = notebookDao.findNotebook(notebookId);
        return notebook.getRam();
    }

    public Screen getScreen(int notebookId) {
        Notebook notebook = notebookDao.findNotebook(notebookId);
        return notebook.getScreen();
    }

    public VideoMemory getVideo(int notebookId) {
        Notebook notebook = notebookDao.findNotebook(notebookId);
        return notebook.getVideo();
    }

    public List getAllScreens() {
        return screenDao.getAll();
    }
}
