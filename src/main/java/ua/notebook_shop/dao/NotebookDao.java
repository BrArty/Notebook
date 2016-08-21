package ua.notebook_shop.dao;


import ua.notebook_shop.exceptions.CreateException;
import ua.notebook_shop.model.*;

import java.util.List;

public interface NotebookDao {
    void saveNotebook(Notebook notebook) throws CreateException;

    List findNotebook(String noteName);

    Notebook findNotebook(int idNotebook);

    void deleteNotebook(int idNotebook);

    void setModel(Model model);

    void setProcessor(Processor processor);

    void setRam(Ram ram);

    Screen setScreen(Screen screen);

    Screen setScreen(int screenId);

    void setVideo(VideoMemory video);

    void setHdd(Hdd hdd);

    Hdd getHdd(int notebookId);

    Model getModel(int notebookId);

    Processor getProcessor(int notebookId);

    Ram getRam(int notebookId);

    VideoMemory getVideo(int notebookId);

    Screen getScreen(int notebookId);

    Notebook removeNotebook(int idNotebook);

    List getAll();

    Notebook updateNotebook(Notebook notebook);
}
