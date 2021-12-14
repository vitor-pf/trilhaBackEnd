package trilha.back.financys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.financys.model.Categoria;

import java.util.ArrayList;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    ArrayList<Categoria> findByName(String name);

}

