package trilha.back.financys.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private Double amount;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private boolean paid;

    @ManyToOne
    private Categoria category;

    //Construtor Vazio
    public Lancamento() { }
    //Construtor Completo
    public Lancamento(String name, String description,String type,
                      Double amount, String date, boolean paid, Categoria category) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.paid = paid;
        this.category = category;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
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
    public Categoria getCategory() {
        return category;
    }
    public void setCategory(Categoria category) {
        this.category = category;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
                +",\nCategoryId: "+getCategory();
    }
}