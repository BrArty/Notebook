package ua.notebook_shop.model;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
public class Component extends IdGenerate{
    @OneToMany(mappedBy = ???, cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private List<Notebook> notebook = new ArrayList<>();

    public void setNotebook(List<Notebook> notebook) {
        this.notebook = notebook;
    }

    public List<Notebook> getNotebook() {
        return notebook;
    }
}
