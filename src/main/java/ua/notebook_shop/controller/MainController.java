package ua.notebook_shop.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.notebook_shop.model.Notebook;
import ua.notebook_shop.service.ElementService;
import ua.notebook_shop.service.NotebookService;

import java.util.List;

@Controller
public class MainController {

    private final Logger LOG = Logger.getLogger(MainController.class);

    @Autowired
    NotebookService notebookService;

    @Autowired
    ElementService elementService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String firstGet(Model model) {
        LOG.info("***In firstGet method");
        model.addAttribute("notebook", new Notebook());
        LOG.info("After firstGet method***");
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String firstPost(@ModelAttribute("notebook") Notebook notebook, Model model) {
        LOG.info("***In firstPost method");
        model.addAttribute("notebook", notebookService.getNotebook(notebook.getId()));
        return "info";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String infoGet(@RequestParam int id, Model model) {
        LOG.info("***In infoGet method");
        Notebook notebook = notebookService.getNotebook(id);
        model.addAttribute("notebook", notebook);
        LOG.info("After infoGet method***");
        return "info";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editGet(@RequestParam int id, Model model) {
        LOG.info("***In editGet method");
        Notebook notebook = notebookService.getNotebook(id);
        model.addAttribute("notebook", notebook);
        List list = elementService.getAllElements(ua.notebook_shop.model.Model.class);
        model.addAttribute("list", list);
        LOG.info("After editGet method***");
        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editPost(@RequestParam int id, @ModelAttribute("notebook") Notebook notebook, Model model) {
        LOG.info("***In editPost method");
        notebookService.setScreen(notebook.getScreen(), id);
        notebookService.setHdd(notebook.getHdd(), id);
        notebookService.setModel(notebook.getModel(), id);
        notebookService.setProcessor(notebook.getProcessor(), id);
        notebookService.setRam(notebook.getRam(), id);
        notebookService.setVideo(notebook.getVideo(), id);
        model.addAttribute("notebook", notebook);
        List list = elementService.getAllElements(ua.notebook_shop.model.Model.class);
        model.addAttribute("list", list);
        LOG.info("After editPost method***");
        return "info";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String editDelete(@RequestParam int id, Model model) {
        LOG.info("***In editDelete method");
        final int DEFAULT_ID = 1;
        Notebook notebook = notebookService.getNotebook(id);
        LOG.info("before delete");
        try {
            notebookService.deleteNotebook(notebook);
            LOG.info("after delete");
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("id", DEFAULT_ID);
        return "redirect:/edit";
    }

    @RequestMapping(value = "/create_notebook", method = RequestMethod.GET)
    public String createGet(Model model) {
        LOG.info("***In createGet method");
        model.addAttribute("newNotebook", new Notebook());
        LOG.info("After createGet method***");
        return "create";
    }

    @RequestMapping(value = "/create_notebook", method = RequestMethod.POST)
    public String createPost(@ModelAttribute(value = "newNotebook") Notebook notebook, Model model) {
        LOG.info("***In createPost method");
        Notebook newNote = new Notebook(notebook.getNotebook_name(), notebook.getModel(),
                notebook.getHdd(),notebook.getProcessor(),
                notebook.getScreen(),notebook.getVideo(),notebook.getRam());
        notebookService.addNotebook(newNote);
        LOG.info("After createPost method***");
        return "create";
    }
}
