package ua.notebook_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.notebook_shop.dao.*;
import ua.notebook_shop.model.*;

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

    public void addElements(int noteId, Model model, Hdd hdd, Processor processor, Ram ram, Screen screen, VideoMemory videoMemory) {
        notebookDao.chooseElements(noteId, model, hdd, processor, ram, screen, videoMemory);
    }

    public Model getModel(int idModel) {
        return modelDao.findModel(idModel);
    }

    public Hdd getHdd(int idHdd) {
        return hddDao.findHDD(idHdd);
    }

    public Processor getProcessor(int idProcessor) {
        return processorDao.findProcessor(idProcessor);
    }

    public Ram getRam(int idRam) {
        return ramDao.findRam(idRam);
    }

    public Screen getScreen(int idScreen) {
        return screenDao.findScreen(idScreen);
    }

    public VideoMemory getVideo(int idVideo) {
        return videoMemoryDao.findVideo(idVideo);
    }
}
