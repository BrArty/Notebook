package ua.notebook_shop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Ram extends IdGenerate {

    @OneToMany(mappedBy = "ram", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<Notebook> notebook = new ArrayList<>();
    @Column(name = "memory_Gb")
    private String memoryInGb;

    public Ram() {
    }

    public Ram(String memoryInGb) {
        this.memoryInGb = memoryInGb;
    }

    public void setNotebook(List<Notebook> notebook) {
        this.notebook = notebook;
    }

    public List<Notebook> getNotebook() {
        return notebook;
    }

    public String getMemoryInGb() {
        return memoryInGb;
    }

    public void setMemoryInGb(String memoryInGb) {
        this.memoryInGb = memoryInGb;
    }

    @Override
    public String toString() {
        return "Ram{" +
                "memoryInGb=" + memoryInGb +
                '}';
    }
}
