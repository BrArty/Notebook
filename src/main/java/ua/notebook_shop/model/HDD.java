package ua.notebook_shop.model;

import javax.persistence.*;

@Entity
@Table
public class HDD extends IdGenerate{
    @OneToOne(mappedBy = "hdd")
    private Notebook notebook;
    @Column(name = "memory_Gb", nullable = false)
    private int memoryInGb;

    public HDD() {
    }

    public HDD(int memoryInGb) {
        this.memoryInGb = memoryInGb;
    }

    public int getMemoryInGb() {
        return memoryInGb;
    }

    public void setMemoryInGb(int memoryInGb) {
        this.memoryInGb = memoryInGb;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    @Override
    public String toString() {
        return "HDD{" +
                "id=" + id +
                ", notebook=" + notebook +
                ", memoryInGb=" + memoryInGb +
                '}';
    }
}
