package ua.notebook_shop.model;

import javax.persistence.*;

@Entity
@Table
public class Notebook extends IdGenerate {
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Model model;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Hdd hdd;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Processor processor;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Screen screen;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private VideoMemory video;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Ram ram;
    @Column
    private String notebook_name;

    public Notebook() {
    }

    public Model setModel(Model model) {
        this.model = model;
        return model;
    }

    public Model getModel() {
        return model;
    }

    public String getNotebook_name() {
        return notebook_name;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Screen getScreen() {
        return screen;
    }

    public Hdd setHdd(Hdd hdd) {
        this.hdd = hdd;
        return hdd;
    }

    public Hdd getHdd() {
        return hdd;
    }

    public Processor setProcessor(Processor processor) {
        this.processor = processor;
        return processor;
    }

    public Processor getProcessor() {
        return processor;
    }

    public Ram setRam(Ram ram) {
        this.ram = ram;
        return ram;
    }

    public Ram getRam() {
        return ram;
    }

    public VideoMemory setVideo(VideoMemory video) {
        this.video = video;
        return video;
    }

    public VideoMemory getVideo() {
        return video;
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
                ", notebook_name: " + notebook_name;
    }
}
