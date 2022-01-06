package trilha.back.financys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.financys.entity.CategoriaEntity;

import java.util.ArrayList;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

    ArrayList<CategoriaEntity> findByNameCategoria(String nameCategoria);

}

