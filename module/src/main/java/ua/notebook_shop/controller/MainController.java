package ua.notebook_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.notebook_shop.dao.ModelDao;
import ua.notebook_shop.service.NotebookService;

@Controller
@RequestMapping(value = "/")
public class MainController {

    @Autowired
    NotebookService notebookService;

    @Autowired
    ModelDao modelDao;

    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public String firstPage(@RequestParam(value = "id", required = false, defaultValue = "1") int id, Model model) {
        model.addAttribute("notebook", notebookService.getNotebook(id));
        return "index";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("modelName", new ua.notebook_shop.model.Model());
        return "/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String createNotebook(@ModelAttribute(value = "modelName") ua.notebook_shop.model.Model modelName, Model model) {
        ua.notebook_shop.model.Model model1 = new ua.notebook_shop.model.Model(modelName.getModel());
        model.addAttribute("modelName", modelDao.saveModel(model1));
        return "edit";
    }


}
