package com.spotippos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotippos.exception.CouldNotInsertRealtyException;
import com.spotippos.exception.InvalidRealtyException;
import com.spotippos.model.Realty;
import com.spotippos.model.enumx.Provinces;
import com.spotippos.repository.RealtyRepository;
import com.spotippos.service.validator.RealtyValidator;

/**
 * Serviço para inserir somente imóveis válidos.
 * 
 * @author Nara
 *
 */
@Service
public class RealtyInsertService {

	@Autowired
	private RealtyRepository repository;

	@Autowired
	private List<RealtyValidator> validators;
	
	/**
	 * Valida o imóvel e caso seja válido, salva.
	 * 
	 * @param realty o imóvel para validar. 
	 * @throws CouldNotInsertRealtyException caso o imóvel não possa ser armazenado.
	 */
	public void insert(Realty realty) throws CouldNotInsertRealtyException {
		if(realty == null) {
			throw new IllegalArgumentException("Imóvel nulo! Impossível ser armazenado.");
		}
		
		List<InvalidRealtyException> exceptions = validateRealty(realty);

		if (!exceptions.isEmpty()) {
			throw new CouldNotInsertRealtyException("Imóvel não pôde ser inserido por problemas durante validação de dados.",
					exceptions);
		}
		
		List<Provinces> provinces = Provinces.getProvincesByPosition(realty.getX(), realty.getY());
		realty.setProvinces(provinces);
		
		repository.insert(realty);
	}

	/**
	 * Valida os dados do Imóvel.
	 * 
	 * @param realty o imóvel a ser cadastrados.
	 * @return Lista de exceções.
	 */
	private List<InvalidRealtyException> validateRealty(Realty realty) {
		List<InvalidRealtyException> exceptions = new ArrayList<>();
		validators.forEach(validator -> {
			try {
				validator.validate(realty);
			} catch (InvalidRealtyException e) {
				exceptions.add(e);
			}
		});
		return exceptions;
	}
}
