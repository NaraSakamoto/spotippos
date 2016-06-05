package com.spotippos.repository;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.spotippos.model.Realty;

@RunWith(MockitoJUnitRunner.class)
public class RealtyRepositoryTest {
	
	@InjectMocks
	private RealtyRepository respository;
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowException(){
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
		ReflectionTestUtils.setField(respository, "map", map);
		
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
}
