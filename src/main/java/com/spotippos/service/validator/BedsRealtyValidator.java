package com.spotippos.service.validator;

import org.springframework.stereotype.Component;

import com.spotippos.exception.InvalidRealtyException;
import com.spotippos.model.Realty;

/**
 * Valida a propriedade Beds do imóvel.
 * 
 * @author Nara
 *
 */
@Component
public class BedsRealtyValidator implements RealtyValidator{

	@Override
	public void validate(Realty imovel) throws InvalidRealtyException {
		if(imovel.getBeds() > 5 || imovel.getBeds() < 1){
			throw new InvalidRealtyException("Parâmetro Beds deve ser um número entre 1 e 5.");
		}
	}
}
