package trilha.back.financys.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lancamento")
public class Lancamento extends BaseDados implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String amount;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private boolean paid;
    @Column(nullable = false)
    private Long categoryId;

    //Construtor Vazio
    public Lancamento() { }
    //Construtor Completo
    public Lancamento(Long id, String name, String description,String type, String amount, String date, boolean paid, Long categoryId) {
        setId(id);
        setName(name);
        setDescription(description);
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.paid = paid;
        this.categoryId = categoryId;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public boolean getPaid() {
        return paid;
    }
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    public Long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Long categoryId){
        this.categoryId = categoryId;
    }
    @Override
    public String toString(){
        return "Id: "+getId()
                +",\nNome: "+getName()
                +",\nDescription: "+getDescription()
                +",\nType: "+getType()
                +",\nAmount: "+getAmount()
                +",\nDate: "+getDate()
                + ",\nPaid: "+getPaid()
                +",\nCategoryId: "+getCategoryId();
    }
}
