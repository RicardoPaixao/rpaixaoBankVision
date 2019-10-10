package com.rpaixao;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.rpaixao.models.User;
import com.rpaixao.repositories.UserRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={RpaixaoBankVisionApplication.class})
@SpringBootTest
public class RpaixaoBankVisionApplicationTests {

	    @Autowired
	    private UserRepository userRepo;

	    @Test
	    public void test1() {
	    	userRepo.deleteAll();
	        userRepo.save(new User("Alice", "Smith", "CC", "123456789", "a@a.com", "12344321"));
	        userRepo.save(new User("Ricardo", "Paixao", "CE", "908565", "ricardo.s.paixao@gmail.com", "3212431483"));
			assertEquals(2, userRepo.findAll().size());
	    }
	    
	    @Test
	    public void test2() {
	    	userRepo.deleteAll();
	        userRepo.save(new User("Alice", "Smith", "CC", "123456789", "a@a.com", "12344321"));
	        assertThat("a@a.com", equalTo( userRepo.findByCorreo("a@a.com").getCorreo()));
	    }
	    
	    @Test
	    public void test3() {
	    	userRepo.deleteAll();
	        userRepo.save(new User("Alice", "Smith", "CC", "123456789", "a@a.com", "12344321"));
	        userRepo.save(new User("Ricardo", "Paixao", "CE", "908565", "ricardo.s.paixao@gmail.com", "3212431483"));
	        assertThat("908565", equalTo( userRepo.findByDocumento("908565").getDocumento()));
	    }
}
