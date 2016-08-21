package ua.notebook_shop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Processor extends Element {

    @OneToMany(mappedBy = "processor", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<Notebook> notebook = new ArrayList<>();
    @Column(name = "proc_model")
    @NotNull
    private String model;

    @Column(name = "frequency_Gb")
    @NotNull
    private String frequency;

    public Processor() {
    }

    public Processor(String model, String frequency) {
        this.model = model;
        this.frequency = frequency;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
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

        Processor processor = (Processor) o;

        if (model != null ? !model.equals(processor.model) : processor.model != null) return false;
        return frequency != null ? frequency.equals(processor.frequency) : processor.frequency == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (frequency != null ? frequency.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "model: " + model +
                ", frequency: " + frequency;
    }
}
