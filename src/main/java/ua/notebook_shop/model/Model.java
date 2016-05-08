package ua.notebook_shop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Model extends IdGenerate {

    @OneToMany(mappedBy = "model", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<Notebook> notebook = new ArrayList<>();

    @Column(nullable = false)
    private String model;

    public Model() {
    }

    public Model(String model_name) {
        this.model = model_name;
    }

    public void setNotebook(List<Notebook> notebook) {
        this.notebook = notebook;
    }

    public List<Notebook> getNotebook() {
        return notebook;
    }

    public String getModel_name() {
        return model;
    }

    public void setModel_name(String model_name) {
        this.model = model_name;
    }

    @Override
    public String toString() {
        return "Model{" +
                "model='" + model + '\'' +
                '}';
    }
}
