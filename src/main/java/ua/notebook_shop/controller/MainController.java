package ua.notebook_shop.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ua.notebook_shop.service.NotebookService;

import java.util.Map;

@Controller
public class MainController {

    private static final Logger LOGGER = Logger.getLogger(MainController.class);

    @Autowired
    NotebookService notebookService;

    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    public String firstPage(Map<String, Object> model) {
        LOG.debug("In first page method");
        model.put("notebook1", notebookService.getNotebook(1));
        model.put("processor", notebookService.getProcessor(1));
        return "index";
    }*/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String firstPage(Map<String, Object> model) {
        LOGGER.debug("Trying to alive");
        return "index";
    }



}
