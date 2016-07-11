package ua.notebook_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.notebook_shop.dao.*;
import ua.notebook_shop.exceptions.AlreadyExistsException;
import ua.notebook_shop.model.*;

import java.util.List;

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

    public void addElement(Element element) {
        try {
            if ( element instanceof Hdd) {
                hddDao.saveHDD((Hdd) element);
            } else if (element instanceof Model) {
                modelDao.saveModel((Model) element);
            } else if (element instanceof Processor) {
                processorDao.saveProcessor((Processor) element);
            } else if (element instanceof Ram) {
                ramDao.saveRam((Ram) element);
            } else if (element instanceof Screen) {
                screenDao.saveScreen((Screen) element);
            } else if (element instanceof VideoMemory) {
                videoMemoryDao.saveVideo((VideoMemory) element);
            } else throw new ClassCastException("Cannot cast this class " + this.getClass());
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
