package trilha.back.financys.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.financys.entity.LancamentoEntity;

@Repository
public interface LancamentoRepository extends JpaRepository<LancamentoEntity, Long> {

}
