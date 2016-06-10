package com.spotippos.service.validator;

import com.spotippos.exception.InvalidRealtyException;
import com.spotippos.model.Realty;

/**
 * Interface para validadores das propriedados dos imóveis.
 * 
 * @author Nara
 *
 */
public interface RealtyValidator {

	/**
	 * Valida o imóvel.
	 * 
	 * @param imovel o imóvel a ser validado.
	 * @throws InvalidRealtyException caso não esteja válido.
	 */
	public void validate(Realty imovel) throws InvalidRealtyException;
}
