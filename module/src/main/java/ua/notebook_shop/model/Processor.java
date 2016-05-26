package ua.notebook_shop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Processor extends IdGenerate {

    @OneToMany(mappedBy = "processor", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<Notebook> notebook = new ArrayList<>();
    @Column(name = "proc_model", nullable = false)
    private String model;
    @Column(name = "frequency_Gb", nullable = false)
    private String frequency;

    public Processor() {
    }

    public Processor(String frequency, String model) {
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
    public String toString() {
        return "Processor{" +
                "model='" + model + '\'' +
                ", frequency='" + frequency + '\'' +
                '}';
    }
}
