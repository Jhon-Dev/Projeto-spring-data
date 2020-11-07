package projeto.spring.data;

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
		usuarioSpringData.setNome("Nuss");
		usuarioSpringData.setIdade("23");
		usuarioSpringData.setEmail("jhonatan.nuss@gmail.com");
		
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
	
}
