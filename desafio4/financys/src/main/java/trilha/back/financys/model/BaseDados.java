package trilha.back.financys.model;
import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class BaseDados implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(nullable = false)
    protected String name;
    @Column(nullable = false)
    protected String description;

    //Construtor Vazio
    public BaseDados() { }
    //Construtor Completo
    public BaseDados(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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
    @Override
    public String toString(){
        return "Id: "+getId()
                +",\nNome: "+getName()
                +",\nDescription: "+getDescription();
    }
}
