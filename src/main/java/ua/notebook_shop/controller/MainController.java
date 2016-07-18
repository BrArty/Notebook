package ua.notebook_shop.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.notebook_shop.model.*;
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
    public String firstPost(@Valid @ModelAttribute("notebook") Notebook notebook,
                            BindingResult result, Model model) {
        LOG.info("***In firstPost method");
        validator.validate(notebook, result);
        LOG.info("Binding result " + result.toString());
        if (result.hasErrors()) {
            return "index";
        } else {
            Notebook note = notebookService.getNotebook(notebook.getId());
            model.addAttribute("notebook", note);
            return "info";
        }
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String infoGet(@RequestParam int id, Model model) {
        LOG.info("***In infoGet method");
        Notebook notebook = notebookService.getNotebook(id);
        model.addAttribute("notebook", notebook);
        LOG.info("After infoGet method***Success");
        return "info";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editGet(@RequestParam int id, Model model) {
        LOG.info("***In editGet method");
        model.addAttribute("notebook", notebookService.getNotebook(id));
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
    public String editPost(@RequestParam int id, @ModelAttribute("notebook") Notebook notebook, Model model) {
        LOG.info("***In editPost method");
        notebookService.setScreen(notebook.getScreen(), id);
        notebookService.setHdd(notebook.getHdd(), id);
        notebookService.setModel(notebook.getModel(), id);
        notebookService.setProcessor(notebook.getProcessor(), id);
        notebookService.setRam(notebook.getRam(), id);
        notebookService.setVideo(notebook.getVideo(), id);
        model.addAttribute("notebook", notebook);
        LOG.info("After editPost method***");
        return "redirect:/edit?id="+notebook.getId();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String editDelete(@RequestParam int id, Model model) {
        LOG.info("***In editDelete method");
        Notebook notebook = notebookService.getNotebook(id);
        notebookService.deleteNotebook(notebook);
        model.addAttribute("success", "Notebook was deleted");
        return "redirect:/";
    }

    @RequestMapping(value = "/create_notebook", method = RequestMethod.GET)
    public String createGet(Model model) {
        LOG.info("***In createGet method");
        model.addAttribute("newNotebook", new Notebook());
        model.addAttribute("models", elementService.getAllElements(ua.notebook_shop.model.Model.class));
        model.addAttribute("hdds", elementService.getAllElements(ua.notebook_shop.model.Hdd.class));
        model.addAttribute("proces", elementService.getAllElements(ua.notebook_shop.model.Processor.class));
        model.addAttribute("rams", elementService.getAllElements(ua.notebook_shop.model.Ram.class));
        model.addAttribute("screens", elementService.getAllElements(ua.notebook_shop.model.Screen.class));
        model.addAttribute("videos", elementService.getAllElements(ua.notebook_shop.model.VideoMemory.class));
        LOG.info("After createGet method***");
        return "create";
    }

    @RequestMapping(value = "/create_notebook", method = RequestMethod.POST)
    public String createPost(@ModelAttribute(value = "newNotebook") Notebook notebook) {
        LOG.info("***In createPost method");
        Notebook newNote = new Notebook(notebook.getNotebook_name(), notebook.getModel(),
                notebook.getHdd(), notebook.getProcessor(),
                notebook.getScreen(), notebook.getVideo(), notebook.getRam());
        notebookService.addNotebook(newNote);
        LOG.info("After createPost method***");
        return "create";
    }

    @RequestMapping(value = "/element_create/Screen", method = RequestMethod.GET)
    public String createScreenGet(Model model) {
        LOG.info("***In createScreenGet method");
        model.addAttribute("screen", new Screen());
        LOG.info("After createScreenGet method***");
        return "screen_create";
    }

    @RequestMapping(value = "/element_create/Screen", method = RequestMethod.POST)
    public String createScreenPost(@ModelAttribute(value = "screen") Screen screen, Model model) {
        LOG.info("***In createScreenPost method");
        Screen newScreen = new Screen(screen.getSize());
        elementService.addElement(newScreen);
        model.addAttribute("screen", screen);
        LOG.info("After createScreenPost method***");
        return "screen_create";
    }

    @RequestMapping(value = "/element_create/Model", method = RequestMethod.GET)
    public String createModelGet(Model model) {
        LOG.info("***In createModelGet method");
        model.addAttribute("model", new ua.notebook_shop.model.Model());
        LOG.info("After createModelGet method***");
        return "model_create";
    }

    @RequestMapping(value = "/element_create/Model", method = RequestMethod.POST)
    public String createModelPost(@ModelAttribute(value = "model") ua.notebook_shop.model.Model model_note,
                                  Model model) {
        LOG.info("***In createModelPost method");
        ua.notebook_shop.model.Model newModel = new ua.notebook_shop.model.Model(model_note.getModel());
        elementService.addElement(newModel);
        model.addAttribute("model", newModel);
        LOG.info("After createModelPost method***");
        return "model_create";
    }

    @RequestMapping(value = "/element_create/Hdd", method = RequestMethod.GET)
    public String createHddGet(Model model) {
        LOG.info("***In createHddGet method");
        model.addAttribute("hdd", new Hdd());
        LOG.info("After createHddGet method***");
        return "hdd_create";
    }

    @RequestMapping(value = "/element_create/Hdd", method = RequestMethod.POST)
    public String createHddPost(@ModelAttribute(value = "hdd") Hdd hdd, Model model) {
        LOG.info("***In createHddPost method");
        Hdd newHdd = new Hdd(hdd.getMemoryInGb());
        elementService.addElement(newHdd);
        model.addAttribute("hdd", newHdd);
        LOG.info("After createHddPost method***");
        return "hdd_create";
    }

    @RequestMapping(value = "/element_create/Processor", method = RequestMethod.GET)
    public String createProcessorGet(Model model) {
        LOG.info("***In createProcessorGet method");
        model.addAttribute("processor", new Processor());
        LOG.info("After createProcessorGet method***");
        return "processor_create";
    }

    @RequestMapping(value = "/element_create/Processor", method = RequestMethod.POST)
    public String createProcessorPost(@ModelAttribute(value = "processor") Processor processor,
                                      Model model) {
        LOG.info("***In createProcessorPost method");
        Processor newProcessor = new Processor(processor.getModel(), processor.getFrequency());
        elementService.addElement(newProcessor);
        model.addAttribute("processor", newProcessor);
        LOG.info("After createProcessorPost method***");
        return "processor_create";
    }

    @RequestMapping(value = "/element_create/Ram", method = RequestMethod.GET)
    public String createRamGet(Model model) {
        LOG.info("***In createRamGet method");
        model.addAttribute("ram", new Ram());
        LOG.info("After createRamGet method***");
        return "ram_create";
    }

    @RequestMapping(value = "/element_create/Ram", method = RequestMethod.POST)
    public String createRamPost(@ModelAttribute(value = "ram") Ram ram, Model model) {
        LOG.info("***In createRamPost method");
        Ram newRam = new Ram(ram.getMemoryInGb());
        elementService.addElement(newRam);
        model.addAttribute("ram", ram);
        LOG.info("After createRamPost method***");
        return "ram_create";
    }

    @RequestMapping(value = "/element_create/Video", method = RequestMethod.GET)
    public String createVideoGet(Model model) {
        LOG.info("***In createVideoGet method");
        model.addAttribute("video", new VideoMemory());
        LOG.info("After createVideoGet method***");
        return "video_create";
    }

    @RequestMapping(value = "/element_create/Video", method = RequestMethod.POST)
    public String createVideoPost(@ModelAttribute(value = "video") VideoMemory video, Model model) {
        LOG.info("***In createVideoPost method");
        VideoMemory newVideo = new VideoMemory(video.getMemoryInGb(), video.getManufacturer());
        elementService.addElement(newVideo);
        model.addAttribute("video", newVideo);
        LOG.info("After createVideoPost method***");
        return "video_create";
    }
}
