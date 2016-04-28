package ua.notebook_shop.model;

import javax.persistence.*;

@Entity
@Table
public class Screen extends IdGenerate{
    @OneToOne(mappedBy = "screen")
    private Notebook notebook;
    @Column(nullable = false)
    private double size;

    public Screen() {
    }

    public Screen(double size) {
        this.size = size;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "id=" + id +
                ", notebook=" + notebook +
                ", size=" + size +
                '}';
    }
}
