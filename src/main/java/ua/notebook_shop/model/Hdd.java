package ua.notebook_shop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Hdd extends IdGenerate {

    @OneToMany(mappedBy = "hdd", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<Notebook> notebook = new ArrayList<>();
    @Column(name = "memory_Gb", nullable = false)
    private String memoryInGb;

    public Hdd() {
    }

    public String getMemoryInGb() {
        return memoryInGb;
    }

    public void setMemoryInGb(String memoryInGb) {
        this.memoryInGb = memoryInGb;
    }

    public void setNotebook(List<Notebook> notebook) {
        this.notebook = notebook;
    }

    public List<Notebook> getNotebook() {
        return notebook;
    }

    @Override
    public String toString() {
        return "memory, Gb: " + memoryInGb;
    }
}
