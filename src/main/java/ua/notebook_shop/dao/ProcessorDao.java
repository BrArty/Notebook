package ua.notebook_shop.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.notebook_shop.exceptions.AlreadyExistsException;
import ua.notebook_shop.model.Processor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
public class ProcessorDao {

    @PersistenceContext
    private EntityManager manager;

    public ProcessorDao() {
    }

    public void saveProcessor(Processor processor) throws AlreadyExistsException {
        if (manager.find(Processor.class, processor.getId()) == null) {
            manager.persist(processor);
        } else throw new AlreadyExistsException("This processor is already exists");
    }

    public Processor findProcessor(int idProcessor) {
        return manager.find(Processor.class, idProcessor);
    }

    public Processor removeProcessor(int idProcessor) {
        Processor processor = manager.find(Processor.class, idProcessor);
        manager.remove(processor);
        return processor;
    }

    public List getAll() {
        return manager.createQuery("SELECT p FROM Processor p").getResultList();
    }

    public void updateProcessor(Processor processor) {

        Processor processorFromDB = manager.find(Processor.class, processor.getId());

        if (processorFromDB == null) return;

        processorFromDB.setFrequency(processor.getFrequency());
        processorFromDB.setModel(processor.getModel());

        manager.merge(processorFromDB);

    }
}
