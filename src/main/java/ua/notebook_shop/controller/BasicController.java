package ua.notebook_shop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import ua.notebook_shop.model.*;
import ua.notebook_shop.service.ElementService;
import ua.notebook_shop.service.NotebookService;

import java.util.HashMap;
import java.util.List;

public class BasicController {

    NotebookService notebookService;
    ElementService elementService;

    @Autowired
    public BasicController(NotebookService notebookService, ElementService elementService) {
        this.notebookService = notebookService;
        this.elementService = elementService;
    }

    java.util.Map<String, List> getMapOfElements() {
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
