package ua.notebook_shop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Model extends Element {

    @OneToMany(mappedBy = "model", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<Notebook> notebook = new ArrayList<>();

    @Column
    @NotNull
    private String model;

    public Model() {
    }

    public Model(String model) {
        this.model = model;
    }

    public void setNotebook(List<Notebook> notebook) {
        this.notebook = notebook;
    }

    public List<Notebook> getNotebook() {
        return notebook;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Model model1 = (Model) o;

        return model != null ? model.equals(model1.model) : model1.model == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "model: " + model;
    }
}
