package ua.notebook_shop.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.notebook_shop.exceptions.AlreadyExistsException;
import ua.notebook_shop.model.WarehouseItem;
import ua.notebook_shop.service.ElementService;
import ua.notebook_shop.service.NotebookService;
import ua.notebook_shop.service.WarehouseService;

@Controller
public class StockController extends BasicController {

    private static final Logger LOG = Logger.getLogger(StockController.class);

    @Autowired
    WarehouseService warehouseService;

    public StockController(NotebookService notebookService, ElementService elementService) {
        super(notebookService, elementService);
    }

    @RequestMapping(value = "/stock", method = RequestMethod.GET)
    public String mainPage(Model model) {
        LOG.info("***In mainPage method");
        model.addAttribute("item", new WarehouseItem());
        model.addAttribute("debitItem", new WarehouseItem());
        model.addAttribute("notebooks", notebookService.getAllNotebooks());
        model.addAttribute("list", warehouseService.getAll());
        LOG.info("After mainPage method***");
        return "stock";
    }

    @RequestMapping(value = "/stock", method = RequestMethod.POST)
    public String mainPagePost(@ModelAttribute(value = "item") WarehouseItem item) throws AlreadyExistsException {
        LOG.info("***In mainPagePost method");
        WarehouseItem warehouseItem = new WarehouseItem(item.getPrice(),
                notebookService.getNotebook(item.getNotebook().getId()), item.getAmount());
        warehouseService.takeNotebooks(warehouseItem);
        LOG.info("After mainPagePost method***");
        return "redirect:/stock";
    }

    @RequestMapping(value = "/stock/debit", method = RequestMethod.POST)
    public String debitNotebooks(@ModelAttribute(value = "debitItem") WarehouseItem item,
                                 @ModelAttribute(value = "amount") int amount) {
        LOG.info("***In debitNotebooks method");
        WarehouseItem wi = warehouseService.getWarehouseItem(item.getId());
        warehouseService.debitNotebooks(wi.getNotebook(), amount);
        LOG.info("After debitNotebooks method***");
        return "redirect:/stock";
    }


}
