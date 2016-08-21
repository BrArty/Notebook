package ua.notebook_shop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Ram extends Element {

    @OneToMany(mappedBy = "ram", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<Notebook> notebook = new ArrayList<>();

    @Column(name = "memory_Gb")
    @NotNull
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Ram ram = (Ram) o;

        return memoryInGb != null ? memoryInGb.equals(ram.memoryInGb) : ram.memoryInGb == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (memoryInGb != null ? memoryInGb.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "memory, Gb: " + memoryInGb;
    }
}
