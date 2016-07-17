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
        List models = elementService.getAllElements(ua.notebook_shop.model.Model.class);
        model.addAttribute("models", models);
        List hdds = elementService.getAllElements(ua.notebook_shop.model.Hdd.class);
        model.addAttribute("hdds", hdds);
        List proces = elementService.getAllElements(ua.notebook_shop.model.Processor.class);
        model.addAttribute("proces", proces);
        List rams = elementService.getAllElements(ua.notebook_shop.model.Ram.class);
        model.addAttribute("rams", rams);
        List screens = elementService.getAllElements(ua.notebook_shop.model.Screen.class);
        model.addAttribute("screens", screens);
        List videos = elementService.getAllElements(ua.notebook_shop.model.VideoMemory.class);
        model.addAttribute("videos", videos);
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
        List models = elementService.getAllElements(ua.notebook_shop.model.Model.class);
        model.addAttribute("models", models);
        List hdds = elementService.getAllElements(ua.notebook_shop.model.Hdd.class);
        model.addAttribute("hdds", hdds);
        List proces = elementService.getAllElements(ua.notebook_shop.model.Processor.class);
        model.addAttribute("proces", proces);
        List rams = elementService.getAllElements(ua.notebook_shop.model.Ram.class);
        model.addAttribute("rams", rams);
        List screens = elementService.getAllElements(ua.notebook_shop.model.Screen.class);
        model.addAttribute("screens", screens);
        List videos = elementService.getAllElements(ua.notebook_shop.model.VideoMemory.class);
        model.addAttribute("videos", videos);
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
    public String createScreenPost(@ModelAttribute(value = "screen") Screen screen,
                                   Model model) {
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
        Element element_type = new ua.notebook_shop.model.Model();
        model.addAttribute("model", element_type);
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
        Element element_type = new Hdd();
        model.addAttribute("hdd", element_type);
        LOG.info("After createHddGet method***");
        return "hdd_create";
    }

    @RequestMapping(value = "/element_create/Hdd", method = RequestMethod.POST)
    public String createHddPost(@ModelAttribute(value = "hdd") Hdd hdd,
                                Model model) {
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
        Element element_type = new Processor();
        model.addAttribute("processor", element_type);
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
        Element element_type = new Ram();
        model.addAttribute("ram", element_type);
        LOG.info("After createRamGet method***");
        return "ram_create";
    }

    @RequestMapping(value = "/element_create/Ram", method = RequestMethod.POST)
    public String createRamPost(@ModelAttribute(value = "ram") Ram ram,
                                Model model) {
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
        Element element_type = new VideoMemory();
        model.addAttribute("video", element_type);
        LOG.info("After createVideoGet method***");
        return "video_create";
    }

    @RequestMapping(value = "/element_create/Video", method = RequestMethod.POST)
    public String createVideoPost(@ModelAttribute(value = "video") VideoMemory video,
                                  Model model) {
        LOG.info("***In createVideoPost method");
        VideoMemory newVideo = new VideoMemory(video.getMemoryInGb(), video.getManufacturer());
        elementService.addElement(newVideo);
        model.addAttribute("video", newVideo);
        LOG.info("After createVideoPost method***");
        return "video_create";
    }
}
