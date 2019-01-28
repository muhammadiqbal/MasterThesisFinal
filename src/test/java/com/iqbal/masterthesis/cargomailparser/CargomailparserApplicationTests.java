package com.iqbal.masterthesis.cargomailparser;

import java.io.IOException;
import java.util.List;

import com.iqbal.masterthesis.cargomailparser.model.Cargo;
import com.iqbal.masterthesis.cargomailparser.model.Email;
import com.iqbal.masterthesis.cargomailparser.repositories.EmailRepository;
import com.iqbal.masterthesis.cargomailparser.service.ParseService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CargomailparserApplicationTests {
	
	@Autowired
	EmailRepository emailRepository;
	
	@Test
	public void contextLoads() throws ClassNotFoundException {
		List<Email> emails = emailRepository.findAll();
		for (Email email : emails) {
			try {
				assertEmail(email);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void assertEmail(Email email) throws IOException {
		Cargo cargo = ParseService.parseEmail(email.getBody());
		List<Cargo> cargoTests = email.getCargo();
		for (Cargo cargoTest : cargoTests) {
			Assert.assertEquals(cargo.getCommision(),cargoTest.getCommision());
			Assert.assertEquals(cargo.getDischarging_port(), cargoTest.getDischarging_port());
			Assert.assertEquals(cargo.getDischarging_rate(), cargoTest.getDischarging_rate());
			Assert.assertEquals(cargo.getDischarging_rate_type(), cargoTest.getDischarging_rate_type());
			Assert.assertEquals(cargo.getLoading_port(), cargoTest.getLoading_port());
			Assert.assertEquals(cargo.getLoading_rate(), cargoTest.getLoading_rate());
			Assert.assertEquals(cargo.getLoading_rate_type(), cargoTest.getLoading_rate_type());
			Assert.assertEquals(cargo.getQuantity(), cargoTest.getQuantity());
			Assert.assertEquals(cargo.getLaycan_first(), cargoTest.getLaycan_first());
			Assert.assertEquals(cargo.getLaycan_last(), cargoTest.getLaycan_last());
			Assert.assertEquals(cargo.getStowage_factor(), cargoTest.getQuantity());			
		}
		Assert.assertNotNull(cargo);
	}

}
