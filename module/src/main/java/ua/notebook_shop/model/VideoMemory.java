package ua.notebook_shop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class VideoMemory extends IdGenerate {

    @OneToMany(mappedBy = "video", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<Notebook> notebook = new ArrayList<>();
    @Column(nullable = false)
    private String manufacturer;
    @Column(nullable = false)
    private String memoryInGb;

    public VideoMemory() {
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
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
        return "VideoMemory: " +
                "manufacturer: " + manufacturer +
                ", memoryInGb: " + memoryInGb;
    }
}
