package com.spotippos.service.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.spotippos.exception.InvalidRealtyException;
import com.spotippos.model.Realty;

@RunWith(MockitoJUnitRunner.class)
public class SquareMetersRealtyValidatorTest {

	@InjectMocks
	private SquareMetersRealtyValidator validator;
	
	@Test(expected=InvalidRealtyException.class)
	public void shouldThrowExceptionBecauseSquareMeterIsGreaterThen240() throws InvalidRealtyException{
		//GIVEN
		Realty realty = new Realty();
		realty.setSquareMeters(241);
		
		//WHEN
		validator.validate(realty);
		
		//THEN - throw InvalidRealtyException
	}
	
	@Test(expected=InvalidRealtyException.class)
	public void shouldThrowExceptionBecauseSquareMeterIsShorterThen20() throws InvalidRealtyException{
		//GIVEN
		Realty realty = new Realty();
		realty.setSquareMeters(0);
		
		//WHEN
		validator.validate(realty);
		
		//THEN - throw InvalidRealtyException
	}
	
	@Test
	public void shouldBeOK() throws InvalidRealtyException{
		//GIVEN
		Realty realty = new Realty();
		realty.setSquareMeters(150);
		
		//WHEN
		validator.validate(realty);
		
		//THEN - OK
	}
}
