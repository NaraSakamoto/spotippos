package com.spotippos.service.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.spotippos.exception.InvalidRealtyException;
import com.spotippos.model.Realty;

@RunWith(MockitoJUnitRunner.class)
public class BedsRealtyValidatorTest {

	@InjectMocks
	private BedsRealtyValidator validator;
	
	@Test(expected=InvalidRealtyException.class)
	public void shouldThrowExceptionBecauseBedssIsGreaterThen5() throws InvalidRealtyException{
		//GIVEN
		Realty realty = new Realty();
		realty.setBeds(6);
		
		//WHEN
		validator.validate(realty);
		
		//THEN - throw InvalidRealtyException
	}
	
	@Test(expected=InvalidRealtyException.class)
	public void shouldThrowExceptionBecauseBedsIsShorterThen1() throws InvalidRealtyException{
		//GIVEN
		Realty realty = new Realty();
		realty.setBeds(0);
		
		//WHEN
		validator.validate(realty);
		
		//THEN - throw InvalidRealtyException
	}
	
	@Test
	public void shouldBeOK() throws InvalidRealtyException{
		//GIVEN
		Realty realty = new Realty();
		realty.setBeds(4);
		
		//WHEN
		validator.validate(realty);
		
		//THEN - OK
	}
}
