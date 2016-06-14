package ua.notebook_shop.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.notebook_shop.dao.ModelDao;
import ua.notebook_shop.model.Notebook;
import ua.notebook_shop.service.NotebookService;

@Controller
public class MainController {

    private final Logger LOG = Logger.getLogger(MainController.class);


    @Autowired
    NotebookService notebookService;

    @Autowired
    ModelDao modelDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String firstGet(Model model) {
        LOG.info("***In firstGet method");
        model.addAttribute("notebook", new Notebook());
        return "index";
    }

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public String infoPost(@ModelAttribute(value = "notebook") Notebook notebook, Model model) {
        LOG.info("***In infoPost method");
        Notebook newNotebook = notebookService.getNotebook(notebook.getId());
        model.addAttribute("newNotebook", newNotebook);
        return "info";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editGet(@PathVariable int id, Model model) {
        LOG.info("***In editGet method");
        model.addAttribute("notebook", notebookService.getNotebook(id));
        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editPost(@ModelAttribute(value = "notebook") Notebook notebook) {
        LOG.info("***In editPost method");
        Notebook someNote = notebookService.getNotebook(notebook.getId());
        notebookService.setScreen(notebook.getScreen(), someNote.getId());
        LOG.info("***After editPost method");
        return "edit";
    }

}
