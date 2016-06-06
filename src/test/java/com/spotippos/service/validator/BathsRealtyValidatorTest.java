package com.spotippos.service.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.spotippos.exception.InvalidRealtyException;
import com.spotippos.model.Realty;

@RunWith(MockitoJUnitRunner.class)
public class BathsRealtyValidatorTest {

	@InjectMocks
	private BathsRealtyValidator validator;
	
	@Test(expected=InvalidRealtyException.class)
	public void shouldThrowExceptionBecauseBathsIsGreaterThen4() throws InvalidRealtyException{
		//GIVEN
		Realty realty = new Realty();
		realty.setBaths(5);
		
		//WHEN
		validator.validate(realty);
		
		//THEN - throw InvalidRealtyException
	}
	
	@Test(expected=InvalidRealtyException.class)
	public void shouldThrowExceptionBecauseBathsIsShorterThen1() throws InvalidRealtyException{
		//GIVEN
		Realty realty = new Realty();
		realty.setBaths(0);
		
		//WHEN
		validator.validate(realty);
		
		//THEN - throw InvalidRealtyException
	}
	
	@Test
	public void shouldBeOK() throws InvalidRealtyException{
		//GIVEN
		Realty realty = new Realty();
		realty.setX(222);
		realty.setY(444);
		realty.setBaths(3);
		realty.setBeds(4);
		realty.setTitle("Imóvel código 1, com 5 quartos e 4 banheiros");
		realty.setPrice(1250000);
		realty.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		realty.setSquareMeters(210);
		
		//WHEN
		validator.validate(realty);
		
		//THEN - OK
	}
}
