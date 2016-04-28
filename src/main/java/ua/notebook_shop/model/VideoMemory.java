package ua.notebook_shop.model;

import javax.persistence.*;

@Entity
@Table
public class VideoMemory extends IdGenerate{
    @OneToOne(mappedBy = "video")
    private Notebook notebook;
    @Column(nullable = false)
    private String manufacturer;
    @Column(nullable = false)
    private int memoryInGb;

    public VideoMemory() {
    }

    public VideoMemory(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public VideoMemory(String manufacturer, int memoryInGb) {
        this.manufacturer = manufacturer;
        this.memoryInGb = memoryInGb;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
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
        return "VideoMemory{" +
                "id=" + id +
                ", notebook=" + notebook +
                ", manufacturer='" + manufacturer + '\'' +
                ", memoryInGb=" + memoryInGb +
                '}';
    }
}
