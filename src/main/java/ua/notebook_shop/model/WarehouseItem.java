package ua.notebook_shop.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "warehouse")
public class WarehouseItem extends IdGenerate {

    @Column
    private double price;
    @OneToOne
    @JoinColumn(name = "notebook_id")
    private Notebook notebook;
    @Column
    private String date;
    @Column
    private int amount;

    public WarehouseItem() {
    }

    public WarehouseItem(double price, Notebook notebook, int amount) {
        this.price = price;
        this.notebook = notebook;
        this.date = LocalDate.now() + " " + LocalTime.now();
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public String getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return notebook.getNotebook_name() +
                ", " + notebook.getModel().getModel() +
                ", price:" + price +
                ", date:" + date +
                ", amount:" + amount;
    }
}
