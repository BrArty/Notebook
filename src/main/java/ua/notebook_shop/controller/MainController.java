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
    public String editDelete(@RequestParam int id) {
        LOG.info("***In editDelete method");
        Notebook notebook = notebookService.getNotebook(id);
        LOG.info("before delete");
        try {
            notebookService.deleteNotebook(notebook);
            LOG.info("after delete");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
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
                notebook.getHdd(), notebook.getProcessor(),
                notebook.getScreen(), notebook.getVideo(), notebook.getRam());
        notebookService.addNotebook(newNote);
        LOG.info("After createPost method***");
        return "create";
    }

    @RequestMapping(value = "/element_create", method = RequestMethod.GET)
    public String createElementGet(@RequestParam String element, Model model) {
        LOG.info("***In createElementGet method");
        switch (element) {
            case "Screen":
                model.addAttribute("screen", new Screen());
//                model.addAttribute("element", "Screen");
                break;
            case "Model":
//                model.addAttribute("element", new ua.notebook_shop.model.Model());
                model.addAttribute("element", "Model");
                break;
            case "Hdd":
//                model.addAttribute("element", new Hdd());
                model.addAttribute("element", "Hdd");
                break;
            case "Processor":
//                model.addAttribute("element", new Processor());
                model.addAttribute("element", "Processor");
                break;
            case "Ram":
//                model.addAttribute("element", new Ram());
                model.addAttribute("element", "Ram");
                break;
            case "VideoMemory":
//                model.addAttribute("element", new VideoMemory());
                model.addAttribute("element", "VideoMemory");
                break;
        }
        LOG.info("After createElementGet method***");
        return "element";
    }

    @RequestMapping(value = "/element_create", method = RequestMethod.POST)
    public String createElementPost(@RequestParam String element,
                                    @ModelAttribute(value = "screen") Element element_type,
                                    Model model) {
        LOG.info("***In createElementPost method");
        switch (element) {
            case "Screen":
                element_type = new Screen();
                elementService.addElement(element_type);
                break;
            case "Model":
                model.addAttribute("element", Model.class);
                break;
            case "Hdd":
                model.addAttribute("element", Hdd.class);
                break;
            case "Processor":
                model.addAttribute("element", Processor.class);
                break;
            case "Ram":
                model.addAttribute("element", Ram.class);
                break;
            case "VideoMemory":
                model.addAttribute("element", VideoMemory.class);
                break;
        }
        LOG.info("After createElementPost method***");
        return "element";
    }
}
