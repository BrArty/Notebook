package ua.notebook_shop.dao_interfaces;

import ua.notebook_shop.model.Processor;

public interface ProcessorDao {

    void persistProcessor(Processor processor);

    Processor findProcessor(int idProcessor);

    Processor removeProcessor(int idProcessor);

    void updateProcessor(Processor processor);

}
