package com.spotippos.service.validator;

import org.springframework.stereotype.Component;

import com.spotippos.exception.InvalidRealtyException;
import com.spotippos.model.Realty;

/**
 * Valida a propriedade Baths do imóvel
 * 
 * @author Nara
 *
 */
@Component
public class BathsRealtyValidator implements RealtyValidator{

	@Override
	public void validate(Realty realty) throws InvalidRealtyException {
		if(realty.getBaths() > 4 || realty.getBaths() < 1){
			throw new InvalidRealtyException("Parâmetro Baths deve ser um número entre 1 e 4.");
		}
	}

}
