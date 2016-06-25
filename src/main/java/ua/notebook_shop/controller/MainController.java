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
import ua.notebook_shop.model.Screen;
import ua.notebook_shop.service.NotebookService;

@Controller
public class MainController {

    private final Logger LOG = Logger.getLogger(MainController.class);

    @Autowired
    NotebookService notebookService;

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
        model.addAttribute("id", notebook.getId());
        LOG.info("After editGet method***");
        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editPost(@RequestParam int id, @ModelAttribute("notebook") Notebook notebook,
                           Model model) {
        LOG.info("***In editPost method");
        model.addAttribute("notebook", notebookService.setScreen(notebook.getScreen(), id));
        model.addAttribute("id", notebook.getId());
        LOG.info("After editPost method***");
        return "edit";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createGet(Model model) {
        LOG.info("***In createGet method");

        return "create";
    }


}
