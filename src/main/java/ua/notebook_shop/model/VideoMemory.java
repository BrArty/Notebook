package ua.notebook_shop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class VideoMemory extends Element{

    @OneToMany(mappedBy = "video", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<Notebook> notebook = new ArrayList<>();
    @Column
    @NotNull
    private String manufacturer;
    @Column
    @NotNull
    private String memoryInGb;

    public VideoMemory() {
    }

    public VideoMemory(String manufacturer, String memoryInGb) {
        this.manufacturer = manufacturer;
        this.memoryInGb = memoryInGb;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        VideoMemory that = (VideoMemory) o;

        if (manufacturer != null ? !manufacturer.equals(that.manufacturer) : that.manufacturer != null) return false;
        return memoryInGb != null ? memoryInGb.equals(that.memoryInGb) : that.memoryInGb == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (memoryInGb != null ? memoryInGb.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "manufacturer: " + manufacturer +
                ", memory, Gb: " + memoryInGb;
    }
}
