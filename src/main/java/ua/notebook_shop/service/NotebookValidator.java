package ua.notebook_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.notebook_shop.dao.NotebookDao;
import ua.notebook_shop.model.Notebook;

@Component
public class NotebookValidator implements Validator {

    @Autowired
    NotebookDao dao;

    @Override
    public boolean supports(Class<?> clazz) {
        return Notebook.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Notebook notebook = (Notebook) target;
        if (notebook.getId() == '\u0000') {
            ValidationUtils.rejectIfEmpty(errors, "id", "empty.id");
        } else if (notebook.getId() < 0) {
            errors.rejectValue("id", "incorrect.id");
        } else if (dao.findNotebook(notebook.getId()) == null) {
            errors.rejectValue("id", "notebook.not.exist");
        }
    }
}
