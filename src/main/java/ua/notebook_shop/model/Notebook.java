package ua.notebook_shop.model;

import javax.persistence.*;

@Entity
@Table
public class Notebook extends IdGenerate{
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Model model;
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Screen screen;
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
     HDD hdd;
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Processor processor;
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private RAM ram;
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private VideoMemory video;
    @Column
    private String notebook_name;

    public Notebook() {
    }

    public Notebook(String notebook_name) {
        this.notebook_name = notebook_name;
    }

    public Model getModel() {
        return model;
    }

    public Notebook setModel(Model model) {
        this.model = model;
        return this;
    }

    public Screen getScreen() {
        return screen;
    }

    public Notebook setScreen(Screen screen) {
        this.screen = screen;
        return this;
    }

    public String getNotebook_name() {
        return notebook_name;
    }

    public Notebook setNotebook_name(String notebook_name) {
        this.notebook_name = notebook_name;
        return this;
    }

    public HDD getHdd() {
        return hdd;
    }

    public Notebook setHdd(HDD hdd) {
        this.hdd = hdd;
        return this;
    }

    public Processor getProcessor() {
        return processor;
    }

    public Notebook setProcessor(Processor processor) {
        this.processor = processor;
        return this;
    }

    public RAM getRam() {
        return ram;
    }

    public Notebook setRam(RAM ram) {
        this.ram = ram;
        return this;
    }

    public VideoMemory getVideo() {
        return video;
    }

    public Notebook setVideo(VideoMemory video) {
        this.video = video;
        return this;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", model=" + model +
                ", screen=" + screen +
                ", hdd=" + hdd +
                ", processor=" + processor +
                ", ram=" + ram +
                ", video=" + video +
                ", notebook_name='" + notebook_name + '\'' +
                '}';
    }
}
