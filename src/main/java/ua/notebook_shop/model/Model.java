package ua.notebook_shop.model;

import javax.persistence.*;

@Entity
@Table
public class Model extends IdGenerate{
    @OneToOne(mappedBy = "model")
    private Notebook notebook;
    @Column(nullable = false)
    private String model;

    public Model() {
    }

    public Model(String model_name) {
        this.model = model_name;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
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
                "id=" + id +
                ", notebook=" + notebook +
                ", model_name='" + model + '\'' +
                '}';
    }
}
