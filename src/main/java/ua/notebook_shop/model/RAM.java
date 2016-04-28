package ua.notebook_shop.model;

import javax.persistence.*;

@Entity
@Table
public class RAM extends IdGenerate{
    @OneToOne(mappedBy = "ram")
    private Notebook notebook;
    @Transient
    private String type;
    @Column(nullable = false)
    private int memoryInGb;

    public RAM() {
    }

    public RAM(int memoryInGb) {
        this.memoryInGb = memoryInGb;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMemoryInGb() {
        return memoryInGb;
    }

    public void setMemoryInGb(int memoryInGb) {
        this.memoryInGb = memoryInGb;
    }

    @Override
    public String toString() {
        return "RAM{" +
                "id=" + id +
                ", notebook=" + notebook +
                ", type='" + type + '\'' +
                ", memoryInGb=" + memoryInGb +
                '}';
    }
}
