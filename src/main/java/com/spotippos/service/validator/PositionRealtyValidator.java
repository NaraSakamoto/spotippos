package com.spotippos.service.validator;

import org.springframework.stereotype.Component;

import com.spotippos.exception.InvalidRealtyException;
import com.spotippos.model.Realty;

@Component
public class PositionRealtyValidator implements RealtyValidator{

	@Override
	public void validate(Realty imovel) throws InvalidRealtyException {
		if(imovel.getX() < 0 || imovel.getX() > 1400){
			throw new InvalidRealtyException("Parâmetro X deve ser um número entre 0 e 1400.");
		}
		
		if(imovel.getY() < 0 || imovel.getY() > 1000){
			throw new InvalidRealtyException("Parâmetro Y deve ser um número entre 0 e 1000.");
		}
	}

}
