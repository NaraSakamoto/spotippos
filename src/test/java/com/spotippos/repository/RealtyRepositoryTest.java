package com.spotippos.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.spotippos.exception.RealtyNotFoundException;
import com.spotippos.model.Properties;
import com.spotippos.model.Realty;

@RunWith(MockitoJUnitRunner.class)
public class RealtyRepositoryTest {
	
	@InjectMocks
	private RealtyRepository respository;
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionBecauseRealtyIsNull(){
		//GIVEN
		Realty realty = null;
		
		//WHEN
		respository.insert(realty);
		
		//THEN - Throw Exception
	}
	
	@Test
	public void shouldInsertRealty(){
		//GIVEN
		Map<Integer, Realty> map = new HashMap<>();
		ReflectionTestUtils.setField(respository, "realtyMapById", map);
		
		Realty realty = new Realty();
		realty.setX(222);
		realty.setY(444);
		realty.setBaths(3);
		realty.setBeds(4);
		realty.setTitle("Imóvel código 1, com 5 quartos e 4 banheiros");
		realty.setPrice(1250000);
		realty.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		realty.setSquareMeters(210);
		
		Realty anotherRealty = new Realty();
		anotherRealty.setX(230);
		anotherRealty.setY(450);
		anotherRealty.setBaths(3);
		anotherRealty.setBeds(6);
		anotherRealty.setTitle("Imóvel código 2, com 6 quartos e 3 banheiros");
		anotherRealty.setPrice(1270000);
		anotherRealty.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		anotherRealty.setSquareMeters(300);
		
		//WHEN
		respository.insert(realty);
		respository.insert(anotherRealty);

		//THEN
		Assert.assertEquals(2, map.size());
		Assert.assertNotNull(map.get(1));
		Assert.assertNotNull(map.get(2));
		Assert.assertNull(map.get(0));
	}
	
	@Test(expected=RealtyNotFoundException.class)
	public void shouldThrowExceptionBecauseRealtyWasNotFound() throws RealtyNotFoundException{
		//GIVEN
		int id = 764;
		
		//WHEN
		respository.findById(id);
		
		//THEN - RealtyNotFoundException
	}
	
	@Test
	public void shouldFindRealtyById() throws RealtyNotFoundException{
		//GIVEN
		int id = 1;
		
		Realty realty = new Realty();
		realty.setX(222);
		realty.setY(444);
		realty.setBaths(3);
		realty.setBeds(4);
		realty.setTitle("Imóvel código 1, com 5 quartos e 4 banheiros");
		realty.setPrice(1250000);
		realty.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		realty.setSquareMeters(210);
		
		respository.insert(realty);
		
		//WHEN
		Realty result = respository.findById(id);
		
		//THEN
		Assert.assertEquals(id, result.getId());
	}
	
	@Test
	public void deveEncontrarRealtyDentroDaArea(){
		int ax = 2;
		int bx = 10;
		int ay = 8;
		int by = 0;
		
		Realty realty = new Realty();
		realty.setX(8);
		realty.setY(1);
		realty.setBaths(3);
		realty.setBeds(4);
		realty.setTitle("Imóvel código 1, com 5 quartos e 4 banheiros");
		realty.setPrice(1250000);
		realty.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		realty.setSquareMeters(210);
		respository.insert(realty);
		
		Properties properties = respository.findByArea(ax, ay, bx, by);
		
		Assert.assertEquals(1, properties.getProperties().size());
	}
	
	

}
