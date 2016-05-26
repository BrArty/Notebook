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

    public Notebook(String notebook_name) {
        this.notebook_name = notebook_name;
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
    public String toString() {
        return "Notebook{" +
                "model=" + model +
                ", hdd=" + hdd +
                ", processor=" + processor +
                ", screen=" + screen +
                ", video=" + video +
                ", ram=" + ram +
                ", notebook_name='" + notebook_name + '\'' +
                '}';
    }
}
