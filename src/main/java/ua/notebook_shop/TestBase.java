package ua.notebook_shop;

import ua.notebook_shop.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestBase {
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

        HDD hdd = new HDD(500);
        HDD hdd3 = new HDD(750);

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

        model1.getNotebook().add(Asus);
        hdd.getNotebook().add(Asus);
        screen.getNotebook().add(Asus);
        processor3.getNotebook().add(Asus);
        video.getNotebook().add(Asus);
        ram.getNotebook().add(Asus);

//        Asus.setHdd(hdd500).setScreen(screen).setModel(model1).setProcessor(processor3).setVideo(video).setRam(ram);
        Asus.setHdd(hdd);
        Asus.setScreen(screen);
        Asus.setModel(model1);
        Asus.setProcessor(processor3);
        Asus.setVideo(video);
        Asus.setRam(ram);

        model2.getNotebook().add(Lenovo);
        hdd.getNotebook().add(Lenovo);
        screen.getNotebook().add(Lenovo);
        processor.getNotebook().add(Lenovo);
        video1.getNotebook().add(Lenovo);
        ram1.getNotebook().add(Lenovo);

//        Lenovo.setHdd(hdd500).setScreen(screen).setModel(model2).setProcessor(processor).setVideo(video1).setRam(ram1);
        Lenovo.setHdd(hdd);
        Lenovo.setScreen(screen);
        Lenovo.setModel(model2);
        Lenovo.setProcessor(processor);
        Lenovo.setVideo(video1);
        Lenovo.setRam(ram1);

        model3.getNotebook().add(Dell);
        hdd.getNotebook().add(Dell);
        screen.getNotebook().add(Dell);
        processor1.getNotebook().add(Dell);
        video2.getNotebook().add(Dell);
        ram1.getNotebook().add(Dell);

//        Dell.setHdd(hdd500).setScreen(screen).setModel(model3).setProcessor(processor1).setVideo(video2).setRam(ram1);
        Dell.setHdd(hdd);
        Dell.setScreen(screen);
        Dell.setModel(model3);
        Dell.setProcessor(processor1);
        Dell.setVideo(video2);
        Dell.setRam(ram1);

        model4.getNotebook().add(Asus1);
        hdd3.getNotebook().add(Asus1);
        screen.getNotebook().add(Asus1);
        processor2.getNotebook().add(Asus1);
        video3.getNotebook().add(Asus1);
        ram1.getNotebook().add(Asus1);

//        Asus1.setHdd(hdd750).setScreen(screen).setModel(model4).setProcessor(processor2).setVideo(video3).setRam(ram1);
        Asus1.setHdd(hdd3);
        Asus1.setScreen(screen);
        Asus1.setModel(model4);
        Asus1.setProcessor(processor2);
        Asus1.setVideo(video3);
        Asus1.setRam(ram1);

        try {
            transaction.begin();
            manager.persist(Asus);      //X540SA
            manager.persist(Lenovo);    //Idea-Pad
            manager.persist(Dell);      //Inspiron
            manager.persist(Asus1);     //K55VM
            manager.persist(hdd);
            manager.persist(hdd3);
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
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
        }
        EntityManager manager1 = entityManagerFactory.createEntityManager();

        String note = String.valueOf(manager1.find(Notebook.class, 1));
        String note1 = String.valueOf(manager1.find(Notebook.class, 2));
        String note2 = String.valueOf(manager1.find(Notebook.class, 3));
        String note3 = String.valueOf(manager1.find(Notebook.class, 4));
        System.out.println(note);
        System.out.println(note1);
        System.out.println(note2);
        System.out.println(note3);
    }
}
