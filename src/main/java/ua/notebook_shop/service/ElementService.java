package ua.notebook_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.notebook_shop.dao.*;
import ua.notebook_shop.exceptions.AlreadyExistsException;
import ua.notebook_shop.model.*;

import java.util.List;

import static javafx.scene.input.KeyCode.T;

@Service
public class ElementService {
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

    public void addHdd(Hdd hdd) {
        try {
            hddDao.saveHDD(hdd);
        } catch (AlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    public void addModel(Model model) {
        try {
            modelDao.saveModel(model);
        } catch (AlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    public void addProcessor(Processor processor) {
        try {
            processorDao.saveProcessor(processor);
        } catch (AlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    public void addRam(Ram ram) {
        try {
            ramDao.saveRam(ram);
        } catch (AlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    public void addScreen(Screen screen) {
        try {
            screenDao.saveScreen(screen);
        } catch (AlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    public void addVideo(VideoMemory videoMemory) {
        try {
            videoMemoryDao.saveVideo(videoMemory);
        } catch (AlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    public List getAllElements(Class clazz) {
        if (clazz.equals(Model.class)) {
            return modelDao.getAll();
        } else if (clazz.equals(Hdd.class)) {
            return hddDao.getAll();
        } else if (clazz.equals(Processor.class)) {
            return processorDao.getAll();
        } else if (clazz.equals(Ram.class)) {
            return ramDao.getAll();
        } else if (clazz.equals(Screen.class)) {
            return screenDao.getAll();
        } else if (clazz.equals(VideoMemory.class)) {
            return videoMemoryDao.getAll();
        } else throw new IllegalArgumentException("This class is not supported");
    }

}
