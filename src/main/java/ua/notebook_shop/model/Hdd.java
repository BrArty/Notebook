package ua.notebook_shop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Hdd extends Element{

    @OneToMany(mappedBy = "hdd", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<Notebook> notebook = new ArrayList<>();

    @Column(name = "memory_Gb")
    @NotNull
    private String memoryInGb;

    public Hdd() {
    }

    public Hdd(String memoryInGb) {
        this.memoryInGb = memoryInGb;
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

        Hdd hdd = (Hdd) o;

        return memoryInGb != null ? memoryInGb.equals(hdd.memoryInGb) : hdd.memoryInGb == null;

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
