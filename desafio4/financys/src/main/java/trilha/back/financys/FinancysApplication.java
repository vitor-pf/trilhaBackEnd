package trilha.back.financys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import trilha.back.financys.model.Categoria;
import trilha.back.financys.model.Lancamento;
import trilha.back.financys.repository.CategoriaRepository;
import trilha.back.financys.repository.LancamentoRepository;

import java.util.Arrays;

@SpringBootApplication
public class FinancysApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository categoriaRepository = null;
	@Autowired
	private LancamentoRepository lancamentoRepository = null;

	public static void main(String[] args) {
		SpringApplication.run(FinancysApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria(null,"Férias","Recebimento das férias");
		Categoria categoria2 = new Categoria(null,"Salário","Recebimento de Salário");
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		System.out.println(categoriaRepository.findAll());

		System.out.println("############################################################");

		Lancamento lancamento1 = new Lancamento(null, "13º", "Adiantamento 13º", "revenue","5000,00","31/12/2021",true,1L);
		Lancamento lancamento2 = new Lancamento(null, "Férias", "Adiantamento Férias", "revenue","5000,00","20/01/2022",false,2L);
		lancamentoRepository.saveAll(Arrays.asList(lancamento1,lancamento2));
		System.out.println(lancamentoRepository.findAll());
	}
}
