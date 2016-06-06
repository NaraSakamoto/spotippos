package com.spotippos.service.validator;

import com.spotippos.exception.InvalidRealtyException;
import com.spotippos.model.Realty;

public interface RealtyValidator {

	public void validate(Realty imovel) throws InvalidRealtyException;
}
