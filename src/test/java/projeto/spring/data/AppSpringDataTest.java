package projeto.spring.data;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.dao.InterfaceSpringDataUser;
import projeto.spring.data.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTest {

	@Autowired
	InterfaceSpringDataUser interfaceSpringDataUser;
	
	@Test
	public void testeInsert() {	
		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		usuarioSpringData.setLogin("admin");
		usuarioSpringData.setSenha("123");
		usuarioSpringData.setNome("nuss");
		usuarioSpringData.setIdade("23");
		usuarioSpringData.setEmail("jhonatan@gmail.com");
		
		interfaceSpringDataUser.save(usuarioSpringData);
		
		System.out.println("Usuarios cadastrados: " + interfaceSpringDataUser.count());
	}
	
	@Test
	public void testeConsulta() {	

		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);
		
		System.out.println(usuarioSpringData.get().getNome());
		System.out.println(usuarioSpringData.get().getIdade());
		System.out.println(usuarioSpringData.get().getLogin());
		System.out.println(usuarioSpringData.get().getSenha());
		System.out.println(usuarioSpringData.get().getEmail());
		System.out.println(usuarioSpringData.get().getId());		
		
	}
	
	@Test
	public void testeConsultaTodos() {
		Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();
		
		for (UsuarioSpringData usuarioSpringData : lista) {
			System.out.println(usuarioSpringData.getId());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println("------------------------------------------------------------");
			
		}
		
	}
	
	
	@Test
	public void testeUpdate() {
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);
		
		UsuarioSpringData data = usuarioSpringData.get();
	
		data.setNome("NomeModificado");
		
		interfaceSpringDataUser.save(data);
		
	}
	

	@Test
	public void testeDelete() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(13L);

		interfaceSpringDataUser.delete(usuarioSpringData.get());
		
	}
	
	@Test
	public void testeDeleteAll() {
		
		interfaceSpringDataUser.deleteAll();
		
	}
	
	
	@Test
	public void testeConsultaNome() {
		
		List<UsuarioSpringData> list = interfaceSpringDataUser.buscaPorNome("Nuss");
		
		for (UsuarioSpringData usuarioSpringData : list) {
			System.out.println(usuarioSpringData.getId());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println("------------------------------------------------------------");
			
		}

	}
	
	@Test
	public void testeConsultaNomeParam() {
		
		UsuarioSpringData usuarioSpringData = interfaceSpringDataUser.buscaPorNomeParam("Nuss");
		
			System.out.println(usuarioSpringData.getId());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getEmail());
			System.out.println("------------------------------------------------------------");
			
	}
	
	@Test
	public void testeDeletePorNome() {
		interfaceSpringDataUser.deletePorNome("Nuss");
		
	}
	
	@Test
	public void testeUpdateEmailPorNome() {
		
		interfaceSpringDataUser.updateEmailPorNome("teste@gmail.com", "nuss");
	}
	
}
