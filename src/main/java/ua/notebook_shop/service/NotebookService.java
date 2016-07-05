package ua.notebook_shop.service;

import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.notebook_shop.dao.NotebookDao;
import ua.notebook_shop.model.*;

@Service
public class NotebookService {

    @Autowired
    NotebookDao notebookDao;

    public Notebook getNotebook(int idNotebook) {
        return notebookDao.findNotebook(idNotebook);
    }

    public void addNotebook(Notebook notebook) {
        Notebook notebookFromDB = notebookDao.findNotebook(notebook.getId());
        if (notebookFromDB == null) notebookDao.saveNotebook(notebook);
        else notebookDao.updateNotebook(notebook);
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
}
