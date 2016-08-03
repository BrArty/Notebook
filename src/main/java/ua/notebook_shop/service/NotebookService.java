package ua.notebook_shop.service;


import ua.notebook_shop.exceptions.CreateException;
import ua.notebook_shop.model.*;

import java.util.List;

public interface NotebookService {
    Notebook getNotebook(int idNotebook);
    void addNotebook(Notebook notebook) throws CreateException;
    List getAllNotebooks();
    void deleteNotebook(Notebook notebook);
    void setModel(Model model, int notebookId);
    Model getModel(int notebookId);
    void setScreen(Screen screen, int notebookId);
    Screen getScreen(int notebookId);
    Hdd getHdd(int notebookId);
    void setHdd(Hdd hdd, int notebookId);
    Processor getProcessor(int notebookId);
    void setProcessor(Processor processor, int notebookId);
    Ram getRam(int notebookId);
    void setRam(Ram ram, int notebookId);
    VideoMemory getVideo(int notebookId);
    void setVideo(VideoMemory videoMemory, int notebookId);
}
