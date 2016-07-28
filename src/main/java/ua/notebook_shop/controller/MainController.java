package ua.notebook_shop.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.notebook_shop.model.*;
import ua.notebook_shop.service.ElementService;
import ua.notebook_shop.service.NotebookService;


@Controller
//@SessionAttributes(value = "notebook")
public class MainController {

    private final Logger LOG = Logger.getLogger(MainController.class);

    private NotebookService notebookService;
    private ElementService elementService;

    @Autowired
    public MainController(NotebookService notebookService,
                          ElementService elementService) {
        this.notebookService = notebookService;
        this.elementService = elementService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String firstGet(Model model) {
        LOG.info("***In firstGet method");
        model.addAttribute("notebook", new Notebook());
        model.addAttribute("notebooks", notebookService.getAllNotebooks());
        LOG.info("After firstGet method***");
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String firstPost(@ModelAttribute(value = "notebook") Notebook notebook, Model model) {
        LOG.info("***In firstPost method");
        model.addAttribute("notebooks", notebookService.getAllNotebooks());
        if (notebook.getId() == 0) {
            model.addAttribute("error", "Choose notebook first!");
            return "index";
        }
        Notebook note = notebookService.getNotebook(notebook.getId());
        model.addAttribute("notebook", note);
        LOG.info("After firstPost method***");
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
        model.addAttribute("notebook", notebookService.getNotebook(id));
        model.addAttribute("models", elementService.getAllElements(ua.notebook_shop.model.Model.class));
        model.addAttribute("hdds", elementService.getAllElements(Hdd.class));
        model.addAttribute("proces", elementService.getAllElements(Processor.class));
        model.addAttribute("rams", elementService.getAllElements(Ram.class));
        model.addAttribute("screens", elementService.getAllElements(Screen.class));
        model.addAttribute("videos", elementService.getAllElements(VideoMemory.class));
        LOG.info("After editGet method***");
        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editPost(@RequestParam int id, @ModelAttribute(value = "notebook") Notebook notebook, Model model) {
        LOG.info("***In editPost method");
        model.addAttribute("notebook", notebook);
        notebookService.setScreen(notebook.getScreen(), id);
        notebookService.setHdd(notebook.getHdd(), id);
        notebookService.setModel(notebook.getModel(), id);
        notebookService.setProcessor(notebook.getProcessor(), id);
        notebookService.setRam(notebook.getRam(), id);
        notebookService.setVideo(notebook.getVideo(), id);
        LOG.info("After editPost method***");
        return "redirect:/edit?id=" + notebook.getId();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String editDelete(@RequestParam int id) {
        LOG.info("***In editDelete method");
        Notebook notebook = notebookService.getNotebook(id);
        notebookService.deleteNotebook(notebook);
        return "redirect:/";
    }
}
