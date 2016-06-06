package com.spotippos.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.spotippos.exception.CouldNotInsertRealtyException;
import com.spotippos.exception.InvalidRealtyException;
import com.spotippos.model.Realty;
import com.spotippos.repository.RealtyRepository;
import com.spotippos.service.validator.RealtyValidator;

@RunWith(MockitoJUnitRunner.class)
public class RealtyInsertServiceTest {

	@InjectMocks
	private RealtyInsertService service;
	@Mock
	private RealtyRepository repository;

	@Mock
	private RealtyValidator validator;

	private List<RealtyValidator> validators;
	
	
	@Before
	public void init(){
		validators = Arrays.asList(validator);
		ReflectionTestUtils.setField(service, "validators", validators);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionBecauseRealtyIsNull() throws CouldNotInsertRealtyException {
		// GIVEN
		Realty realty = null;

		// WHEN
		service.insert(realty);

		// THEN - throw IllegalArgumentException
	}

	@Test(expected = CouldNotInsertRealtyException.class)
	public void shouldThrowExceptionBecauseRealtyIsInvalid() throws CouldNotInsertRealtyException, InvalidRealtyException {
		// GIVEN
		Realty realty = new Realty();
		Mockito.doThrow(InvalidRealtyException.class).when(validator).validate(realty);
		
		// WHEN
		service.insert(realty);

		// THEN - throw CouldNotInsertRealtyException
	}

	@Test
	public void shouldInsertRealty() throws InvalidRealtyException, CouldNotInsertRealtyException {
		//GIVEN
		Realty realty = new Realty();
		realty.setX(222);
		realty.setY(444);
		realty.setBaths(2);
		realty.setBeds(4);
		realty.setTitle("Imóvel código 1, com 5 quartos e 4 banheiros");
		realty.setPrice(1250000);
		realty.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		realty.setSquareMeters(18);
		
		Mockito.doNothing().when(validator).validate(realty);

		//WHEN
		service.insert(realty);
		
		//THEN
		Mockito.verify(validator, Mockito.times(1)).validate(realty);
		Mockito.verify(repository, Mockito.times(1)).insert(realty);
	}
}
