package ua.notebook_shop.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.notebook_shop.exceptions.CreateException;
import ua.notebook_shop.model.*;
import ua.notebook_shop.service.ElementService;
import ua.notebook_shop.service.NotebookService;

import java.util.HashMap;
import java.util.List;

@Controller
public class CreateController {

    private final Logger LOG = Logger.getLogger(MainController.class);

    @Autowired
    private NotebookService notebookService;
    @Autowired
    private ElementService elementService;

    /*@Autowired
    public CreateController(NotebookService notebookService, ElementService elementService) {
        this.notebookService = notebookService;
        this.elementService = elementService;
    }*/

    @RequestMapping(value = "/create_notebook", method = RequestMethod.GET)
    public String createGet(Model model) {
        LOG.info("***In createGet method");
        model.addAttribute("newNotebook", new Notebook());
        model.addAllAttributes(getMapOfElements());
        LOG.info("After createGet method***");
        return "create";
    }

    @RequestMapping(value = "/create_notebook", method = RequestMethod.POST)
    public String createPost(@ModelAttribute(value = "newNotebook") Notebook notebook, Model model) {
        LOG.info("***In createPost method");
        model.addAllAttributes(getMapOfElements());
        try {
            Notebook newNote = new Notebook(notebook.getNotebook_name(), notebook.getModel(), notebook.getHdd(),
                    notebook.getProcessor(), notebook.getScreen(), notebook.getVideo(), notebook.getRam());
            notebookService.addNotebook(newNote);
        } catch (CreateException e) {
            model.addAttribute("error", e.getMessage());
            return "create";
        }
        LOG.info("After createPost method***");
        return "redirect:/create_notebook";
    }

    @RequestMapping(value = "/element_create/Screen", method = RequestMethod.POST)
    public String createScreenPost(@ModelAttribute(value = "screen") Screen screen) {
        LOG.info("***In createScreenPost method");
        double size = screen.getSize();
        if (size != 0.0) {
            elementService.addElement(new Screen(size));
        }
        LOG.info("After createScreenPost method***");
        return "screen_create";
    }

    @RequestMapping(value = "/element_create/Model", method = RequestMethod.POST)
    public String createModelPost(@ModelAttribute(value = "model") ua.notebook_shop.model.Model model) {
        LOG.info("***In createModelPost method");
        String model_name = model.getModel();
        if (model_name != null) {
            elementService.addElement(new ua.notebook_shop.model.Model(model_name));
        }
        LOG.info("After createModelPost method***");
        return "model_create";
    }

    @RequestMapping(value = "/element_create/Hdd", method = RequestMethod.POST)
    public String createHddPost(@ModelAttribute(value = "hdd") Hdd hdd) {
        LOG.info("***In createHddPost method");
        String memory = hdd.getMemoryInGb();
        if (memory != null) {
            elementService.addElement(new Hdd(memory));
        }
        LOG.info("After createHddPost method***");
        return "hdd_create";
    }

    @RequestMapping(value = "/element_create/Processor", method = RequestMethod.POST)
    public String createProcessorPost(@ModelAttribute(value = "processor") Processor processor) {
        LOG.info("***In createProcessorPost method");
        String model = processor.getModel();
        String frequency = processor.getFrequency();
        if (model != null && frequency != null) {
            elementService.addElement(new Processor(model, frequency));
        }
        LOG.info("After createProcessorPost method***");
        return "processor_create";
    }

    @RequestMapping(value = "/element_create/Ram", method = RequestMethod.POST)
    public String createRamPost(@ModelAttribute(value = "ram") Ram ram) {
        LOG.info("***In createRamPost method");
        String memory = ram.getMemoryInGb();
        if (memory != null) {
            elementService.addElement(new Ram(memory));
        }
        LOG.info("After createRamPost method***");
        return "ram_create";
    }

    @RequestMapping(value = "/element_create/Video", method = RequestMethod.POST)
    public String createVideoPost(@ModelAttribute(value = "video") VideoMemory video) {
        LOG.info("***In createVideoPost method");
        String manufacturer = video.getManufacturer();
        String memory = video.getMemoryInGb();
        if (manufacturer != null && memory != null) {
            elementService.addElement(new VideoMemory(manufacturer, memory));
        }
        LOG.info("After createVideoPost method***");
        return "video_create";
    }

    private java.util.Map<String, List> getMapOfElements() {
        java.util.Map<String, List> elements = new HashMap<>();
        elements.put("models", elementService.getAllElements(ua.notebook_shop.model.Model.class));
        elements.put("hdds", elementService.getAllElements(Hdd.class));
        elements.put("proces", elementService.getAllElements(Processor.class));
        elements.put("rams", elementService.getAllElements(Ram.class));
        elements.put("screens", elementService.getAllElements(Screen.class));
        elements.put("videos", elementService.getAllElements(VideoMemory.class));
        return elements;
    }
}
