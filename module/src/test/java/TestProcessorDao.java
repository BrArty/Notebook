/*
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import DropAllTables;
import ua.notebook_shop.dao.ProcessorDao;
import ua.notebook_shop.model.Processor;

import javax.persistence.PersistenceException;
import java.sql.SQLException;

public class TestProcessorDao {

    private static int UNEXPECTED_ID = 10000;

    private static Logger LOG = Logger.getLogger(TestProcessorDao.class);

    private final ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
    private final ProcessorDao dao = context.getBean(ProcessorDao.class);

    private Processor processor;

    @Before
    public void before() {
        processor = new Processor("frequency", "model");
        dao.persistProcessor(processor);
        LOG.info("***Processor was persisted");
    }

    @After
    public void after() {
        try {
            DropAllTables.drop();
            LOG.info("***All tables were removed");
        } catch (SQLException ignore) {*/
/*NOP*//*
}
    }


    @Test(expected = PersistenceException.class)
    public void testPersistProcessorNegativeDuplicate() {
        LOG.info("***In testPersistProcessorNegativeDuplicate");
        dao.persistProcessor(processor);
        LOG.info("***Processor was persisted second time");
    }

    @Test
    public void testFindProcessor() {
        LOG.info("***In testFindProcessor");
        Processor processorFromDB = dao.findProcessor(processor.getId());
        Assert.assertEquals(processor.getFrequency(), processorFromDB.getFrequency());
    }

    @Test
    public void testFindProcessorNegative() {
        LOG.info("***In testFindProcessorNegative");
        Processor processorFromDB = dao.findProcessor(UNEXPECTED_ID);
        Assert.assertNull(processorFromDB);
    }


    @Test
    public void testRemoveProcessor() {
        LOG.info("***In testRemoveProcessor");
        dao.removeProcessor(processor.getId());
        LOG.info("***Processor was removed");
        Processor processorFromDB = dao.findProcessor(processor.getId());
        Assert.assertNull(processorFromDB);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveProcessorNegative() {
        LOG.info("***In testRemoveProcessorNegative");
        dao.removeProcessor(UNEXPECTED_ID);
    }

    @Test
    public void testUpdateProcessor() {
        LOG.info("***In testUpdateProcessor");
        String newFrequency = "some change";
        processor = dao.findProcessor(processor.getId());
        processor.setFrequency(newFrequency);
        dao.updateProcessor(processor);
        processor = dao.findProcessor(processor.getId());
        Assert.assertEquals(newFrequency, processor.getFrequency());
    }

    @Test
    public void testUpdateProcessorNegative() {
        LOG.info("***In testUpdateProcessorNegative");
        dao.updateProcessor(new Processor()); // no exception.. but and no changes too (if you want, you can create exception... for understanding why was no change in db)
    }
}
*/
