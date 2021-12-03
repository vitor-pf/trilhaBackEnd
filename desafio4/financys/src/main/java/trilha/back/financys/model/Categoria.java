package trilha.back.financys.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categoria")
public class Categoria extends BaseDados implements Serializable {
    private static final long serialVersionUID = 1L;

    public Categoria() { }
    public Categoria(Long id, String name, String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }
}
