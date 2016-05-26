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
        if (notebookFromDB == null) notebookDao.persistNotebook(notebook);
        else notebookDao.updateNotebook(notebook);
    }

    public Model getModel(int idModel) {
        return modelDao.findModel(idModel);
    }

    public void addModel(Model model) {
        modelDao.updateModel(model);
    }

    public Hdd getHdd(int idHdd) {
        return hddDao.findHDD(idHdd);
    }

    public void addHdd(Hdd hdd) {
        hddDao.persistHDD(hdd);
    }

    public Processor getProcessor(int idProcessor) {
        return processorDao.findProcessor(idProcessor);
    }

    public void addProcessor(Processor processor) {
        processorDao.persistProcessor(processor);
    }

    public Ram getRam(int idRam) {
        return ramDao.findRam(idRam);
    }

    public void addRam(Ram ram) {
        ramDao.persistRam(ram);
    }

    public Screen getScreen(int idScreen) {
        return screenDao.findScreen(idScreen);
    }

    public void addScreen(Screen screen) {
        screenDao.persistScreen(screen);
    }

    public VideoMemory getVideo(int idVideo) {
        return videoMemoryDao.findVideo(idVideo);
    }

    public void addVideo(VideoMemory video) {
        videoMemoryDao.persistVideo(video);
    }
}
