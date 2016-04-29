package ua.notebook_shop.dao_interfaces;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.notebook_shop.model.Processor;

/**
 * Created by ARTEM on 27.04.2016.
 */
public interface ProcessorDao {

    void persistProcessor(Processor processor);
    Processor findProcessor(int idProcessor);
    Processor removeProcessor(int idProcessor);
    void updateProcessor(Processor processor);

}
