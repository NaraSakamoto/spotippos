package com.spotippos.service.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.spotippos.exception.InvalidRealtyException;
import com.spotippos.model.Realty;

@RunWith(MockitoJUnitRunner.class)
public class PositionRealtyValidatorTest {

	@InjectMocks
	private PositionRealtyValidator validator;
	
	@Test(expected=InvalidRealtyException.class)
	public void shouldThrowExceptionBecauseXPositionIsGreaterThen1400() throws InvalidRealtyException{
		//GIVEN
		Realty realty = new Realty();
		realty.setX(1401);
		
		//WHEN
		validator.validate(realty);
		
		//THEN - throw InvalidRealtyException
	}
	
	@Test(expected=InvalidRealtyException.class)
	public void shouldThrowExceptionBecauseXPositionIsShorterThen0() throws InvalidRealtyException{
		//GIVEN
		Realty realty = new Realty();
		realty.setX(-1);
		
		//WHEN
		validator.validate(realty);
		
		//THEN - throw InvalidRealtyException
	}
	
	@Test(expected=InvalidRealtyException.class)
	public void shouldThrowExceptionBecauseYPositionIsGreaterThen1000() throws InvalidRealtyException{
		//GIVEN
		Realty realty = new Realty();
		realty.setY(1001);
		
		//WHEN
		validator.validate(realty);
		
		//THEN - throw InvalidRealtyException
	}
	
	@Test(expected=InvalidRealtyException.class)
	public void shouldThrowExceptionBecauseYPositionIsShorterThen0() throws InvalidRealtyException{
		//GIVEN
		Realty realty = new Realty();
		realty.setY(-1);
		
		//WHEN
		validator.validate(realty);
		
		//THEN - throw InvalidRealtyException
	}
	
	@Test
	public void shouldBeOK() throws InvalidRealtyException{
		//GIVEN
		Realty realty = new Realty();
		realty.setX(150);
		realty.setY(200);
		
		//WHEN
		validator.validate(realty);
		
		//THEN - OK
	}
}
