package ua.notebook_shop.model;

import javax.persistence.*;

@Entity
@Table
public class Processor extends IdGenerate{

    @OneToOne(mappedBy = "processor")
    private Notebook notebook;

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

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
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
                "id=" + id +
                ", notebook=" + notebook +
                ", frequency='" + frequency + '\'' +
                '}';
    }
}
