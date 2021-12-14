package trilha.back.financys.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria extends BaseDados implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "categoryId", orphanRemoval = true, cascade = CascadeType.ALL)
    //@OneToMany
    private List<Lancamento> lancamento;

    public Categoria() { }
    public Categoria(String name, String description) {
        setName(name);
        setDescription(description);
    }
    public List<Lancamento> getLancamento() {
        return lancamento;
    }
    public void setLancamento(List<Lancamento> lancamento) {
        this.lancamento = lancamento;
    }
}