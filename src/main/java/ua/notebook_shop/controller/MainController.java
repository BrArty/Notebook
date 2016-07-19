package ua.notebook_shop.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.notebook_shop.model.Notebook;
import ua.notebook_shop.service.ElementService;
import ua.notebook_shop.service.NotebookService;
import ua.notebook_shop.service.NotebookValidator;

import javax.validation.Valid;

@Controller
@SessionAttributes(value = "notebook")
public class MainController {

    private final Logger LOG = Logger.getLogger(MainController.class);

    private NotebookValidator validator;
    private NotebookService notebookService;
    private ElementService elementService;

    @Autowired
    public MainController(NotebookValidator validator, NotebookService notebookService,
                          ElementService elementService) {
        this.validator = validator;
        this.notebookService = notebookService;
        this.elementService = elementService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String firstGet(Model model) {
        LOG.info("***In firstGet method");
        model.addAttribute("notebook", new Notebook());
        model.addAttribute("allNotes", notebookService.getAllNotebooks());
        LOG.info("After firstGet method***");
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String firstPost(@Valid @ModelAttribute Notebook notebook,
                            BindingResult result, Model model) {
        LOG.info("***In firstPost method");
        validator.validate(notebook, result);
        LOG.info("Binding result " + result.toString());
        if (result.hasErrors()) {
            return "index";
        } else {
            Notebook note = notebookService.getNotebook(notebook.getId());
            model.addAttribute(note);
            return "info";
        }
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String infoGet(@RequestParam int id, Model model) {
        LOG.info("***In infoGet method");
        Notebook notebook = notebookService.getNotebook(id);
        model.addAttribute(notebook);
        LOG.info("After infoGet method***Success");
        return "info";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editGet(@RequestParam int id, Model model) {
        LOG.info("***In editGet method");
        model.addAttribute(notebookService.getNotebook(id));
        model.addAttribute("models", elementService.getAllElements(ua.notebook_shop.model.Model.class));
        model.addAttribute("hdds", elementService.getAllElements(ua.notebook_shop.model.Hdd.class));
        model.addAttribute("proces", elementService.getAllElements(ua.notebook_shop.model.Processor.class));
        model.addAttribute("rams", elementService.getAllElements(ua.notebook_shop.model.Ram.class));
        model.addAttribute("screens", elementService.getAllElements(ua.notebook_shop.model.Screen.class));
        model.addAttribute("videos", elementService.getAllElements(ua.notebook_shop.model.VideoMemory.class));
        LOG.info("After editGet method***");
        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editPost(@RequestParam int id, @ModelAttribute Notebook notebook, Model model) {
        LOG.info("***In editPost method");
        notebookService.setScreen(notebook.getScreen(), id);
        notebookService.setHdd(notebook.getHdd(), id);
        notebookService.setModel(notebook.getModel(), id);
        notebookService.setProcessor(notebook.getProcessor(), id);
        notebookService.setRam(notebook.getRam(), id);
        notebookService.setVideo(notebook.getVideo(), id);
        model.addAttribute(notebook);
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
