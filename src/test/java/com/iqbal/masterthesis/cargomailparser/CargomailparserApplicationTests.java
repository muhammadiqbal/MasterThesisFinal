package com.iqbal.masterthesis.cargomailparser;

import com.iqbal.masterthesis.cargomailparser.repositories.EmailRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CargomailparserApplicationTests {
	
	@Autowired
	EmailRepository emailRepository;
	
	@Test
	public void contextLoads() throws ClassNotFoundException {

	}

}
