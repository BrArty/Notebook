package ua.notebook_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.notebook_shop.service.NotebookService;

@Controller
public class MainController {

    @Autowired
    NotebookService notebookService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String firstPage(@PathVariable int id, Model model) {
        model.addAttribute("notebook", notebookService.getNotebook(id));
        return "index";
    }


}
