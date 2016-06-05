package com.spotippos.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spotippos.model.Realty;

/**
 * Armazena os imóveis em um mapa cuja chave é o próprio id.
 * 
 * @author Nara
 *
 */
@Repository
public class RealtyRepository {

	private Map<Integer, Realty> map = new HashMap<>();
	
	/**
	 * Insere um imóvel no mapa. Chave: Id (tamanho mapa + 1).
	 * 
	 * @param realty o imóvel a ser armazenado.
	 */
	public void insert(Realty realty){
		if(realty == null) {
			throw new IllegalArgumentException("Imóvel nulo! Impossível ser armazenado.");
		}
		map.put(map.size() + 1, realty);
	}
}
