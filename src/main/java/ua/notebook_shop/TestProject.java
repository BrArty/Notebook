package ua.notebook_shop;

import ua.notebook_shop.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestProject {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("project");

        EntityManager manager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = manager.getTransaction();

        Model model1 = new Model("X540SA");
        Model model2 = new Model("Idea-Pad 100-15");
        Model model3 = new Model("Inspiron 3543");
        Model model4 = new Model("K55VM");

        Notebook Asus = new Notebook("Asus");
        Notebook Lenovo = new Notebook("Lenovo");
        Notebook Dell = new Notebook("Dell");
        Notebook Asus1 = new Notebook("Asus");

        Screen screen = new Screen(15.6);

        HDD hdd500 = new HDD(500);
        HDD hdd750 = new HDD(750);

        Processor processor = new Processor("1.9", "Intel Pentium 3825U");
        Processor processor1 = new Processor("1.9", "Intel Pentium 3805U");
        Processor processor2 = new Processor("2.5", "Intel Core i5-3210M");
        Processor processor3 = new Processor("2.1", "Intel Celeron N3050");

        VideoMemory video = new VideoMemory("Intel HD Graphics", 512);
        VideoMemory video1 = new VideoMemory("nVidia GeForce GT 920M", 1);
        VideoMemory video2 = new VideoMemory("nVidia GeForce 820M", 2);
        VideoMemory video3 = new VideoMemory("NVIDIA GeForce GT 630M", 2);

        RAM ram = new RAM(2);
        RAM ram1 = new RAM(4);

        screen.setNotebook(Asus);
        screen.setNotebook(Asus1);
        screen.setNotebook(Dell);
        screen.setNotebook(Lenovo);

        model1.setNotebook(Asus);
        model2.setNotebook(Lenovo);
        model3.setNotebook(Dell);
        model4.setNotebook(Asus1);

        Asus.setHdd(hdd500).setScreen(screen).setModel(model1).setProcessor(processor3).setVideo(video).setRam(ram);
        Lenovo.setHdd(hdd500).setScreen(screen).setModel(model2).setProcessor(processor).setVideo(video1).setRam(ram1);
        Dell.setHdd(hdd500).setScreen(screen).setModel(model3).setProcessor(processor1).setVideo(video2).setRam(ram1);
        Asus1.setHdd(hdd750).setScreen(screen).setModel(model4).setProcessor(processor2).setVideo(video3).setRam(ram1);

        try {
            transaction.begin();
            manager.persist(model1);
            manager.persist(model2);
            manager.persist(model3);
            manager.persist(model4);
            manager.persist(screen);
            manager.persist(ram);
            manager.persist(ram1);
            manager.persist(processor);
            manager.persist(processor2);
            manager.persist(processor1);
            manager.persist(processor3);
            manager.persist(video);
            manager.persist(video1);
            manager.persist(video2);
            manager.persist(video3);
            manager.persist(hdd500);
            manager.persist(hdd750);
            manager.persist(Asus);      //X540SA
            manager.persist(Lenovo);    //Idea-Pad
            manager.persist(Dell);      //Inspiron
            manager.persist(Asus1);     //K55VM
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
        }
    }
}
