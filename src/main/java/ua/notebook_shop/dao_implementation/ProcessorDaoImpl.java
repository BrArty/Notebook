package ua.notebook_shop.dao_implementation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.notebook_shop.model.Processor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by dexter on 29.04.16.
 */
@Service
@Transactional
public class ProcessorDaoImpl {


    @PersistenceContext
    private EntityManager manager;


    public void persistProcessor(Processor processor) {
        manager.persist(processor);
    }

    public Processor findProcessor(int idProcessor) {
        return manager.find(Processor.class, idProcessor);
    }

    public Processor removeProcessor(int idProcessor) {
        Processor processor = manager.find(Processor.class, idProcessor);
        manager.remove(processor);
        return processor;
    }

    public void updateProcessor(Processor processor) {

        Processor processorFromDB = manager.find(Processor.class, processor.getId());

        if(processorFromDB == null) return;

        processorFromDB.setFrequency(processor.getFrequency());
        processorFromDB.setModel(processor.getModel());

        manager.merge(processorFromDB);

    }
}
