package ua.notebook_shop.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table
public class Notebook extends IdGenerate implements Serializable {
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @NotNull
    private Model model;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @NotNull
    private Hdd hdd;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @NotNull
    private Processor processor;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @NotNull
    private Screen screen;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @NotNull
    private VideoMemory video;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @NotNull
    private Ram ram;
    @Column
    @NotNull
    private String notebook_name;


    public Notebook() {
    }

    public Notebook(String notebook_name, Model model, Hdd hdd,
                    Processor processor, Screen screen, VideoMemory video, Ram ram) {
        this.notebook_name = notebook_name;
        this.model = model;
        this.hdd = hdd;
        this.processor = processor;
        this.screen = screen;
        this.video = video;
        this.ram = ram;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public String getNotebook_name() {
        return notebook_name;
    }

    public void setNotebook_name(String notebook_name) {
        this.notebook_name = notebook_name;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setHdd(Hdd hdd) {
        this.hdd = hdd;
    }

    public Hdd getHdd() {
        return hdd;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Ram getRam() {
        return ram;
    }

    public void setVideo(VideoMemory video) {
        this.video = video;
    }

    public VideoMemory getVideo() {
        return video;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getId();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Notebook other = (Notebook) o;
        if (notebook_name != other.notebook_name && model != other.model && processor != other.processor &&
                ram != other.ram && hdd != other.hdd && screen != other.screen && video != other.video)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Notebook: " +
                model +
                ", " + hdd +
                ", " + processor +
                ", " + screen +
                ", " + video +
                ", " + ram +
                ", notebook_name: " + notebook_name + ", id: " + getId();
    }
}
