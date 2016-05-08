package ua.notebook_shop.dao_implementation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.notebook_shop.dao_interfaces.ProcessorDao;
import ua.notebook_shop.model.Processor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class ProcessorDaoImpl implements ProcessorDao {


    @PersistenceContext
    private EntityManager manager;

    @Override
    public void persistProcessor(Processor processor) {
        manager.persist(processor);
    }

    @Override
    public Processor findProcessor(int idProcessor) {
        return manager.find(Processor.class, idProcessor);
    }

    @Override
    public Processor removeProcessor(int idProcessor) {
        Processor processor = manager.find(Processor.class, idProcessor);
        manager.remove(processor);
        return processor;
    }

    @Override
    public void updateProcessor(Processor processor) {

        Processor processorFromDB = manager.find(Processor.class, processor.getId());

        if (processorFromDB == null) return;

        processorFromDB.setFrequency(processor.getFrequency());
        processorFromDB.setModel(processor.getModel());

        manager.merge(processorFromDB);

    }
}
