package com.spotippos.service.validator;

import org.springframework.stereotype.Component;

import com.spotippos.exception.InvalidRealtyException;
import com.spotippos.model.Realty;

@Component
public class SquareMetersRealtyValidator implements RealtyValidator{

	@Override
	public void validate(Realty imovel) throws InvalidRealtyException {
		if(imovel.getSquareMeters() > 240 || imovel.getSquareMeters() < 20){
			throw new InvalidRealtyException("Parâmetro SquareMeters deve ser um número entre 20 e 240.");
		}
	}
	
}
