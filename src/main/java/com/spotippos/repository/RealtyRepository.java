package com.spotippos.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.spotippos.exception.RealtyNotFoundException;
import com.spotippos.model.Properties;
import com.spotippos.model.Realty;

/**
 * Armazena os imóveis em um mapa cuja chave é o próprio id.
 * 
 * @author Nara
 *
 */
@Repository
public class RealtyRepository {

	private Map<Integer, Realty> realtyMapById = new HashMap<>();

	private Map<Integer, List<Realty>> realtyMapByXPosition = new HashMap<>();

	/**
	 * Insere o imóvel no mapa. Chave: Id (tamanho mapa + 1).
	 * Insere o imóvel no mapa onde a Chave é a coordenada X dos imóveis e o Valor é o próprio imóvel.
	 * 
	 * @param realty o imóvel a ser armazenado.
	 */
	public void insert(Realty realty) {
		if (realty == null) {
			throw new IllegalArgumentException("Imóvel nulo! Impossível ser armazenado.");
		}

		int id = this.realtyMapById.size() + 1;
		realty.setId(id);

		this.realtyMapById.put(id, realty);
		List<Realty> list = this.realtyMapByXPosition.get(realty.getX());
		if (list == null) {
			list = new ArrayList<>();
		}
		list.add(realty);
		realtyMapByXPosition.put(realty.getX(), list);
	}

	/**
	 * Encontra um imóvel pelo seu id
	 * 
	 * @param id o id do imóvel
	 * @return O imóvel encontrado.
	 * @throws RealtyNotFoundException caso não seja encontrado nenhum imóvel.
	 */
	public Realty findById(int id) throws RealtyNotFoundException {
		Realty realty = this.realtyMapById.get(id);
		if (realty == null) {
			throw new RealtyNotFoundException("Não foi encontrado imóvel com id: " + id);
		}
		return realty;
	}

	/**
	 * Encontra um imóvel por uma área delimitada pelos pontos A e B, sendo que A(ax, ay) e B(bx, by).
	 * Primeiro este método descobre em um mapa organizado pelas coordadas x dos imóveis quais são todos 
	 * os imóveis que possuem a coordenada x entre ax e bx, ou seja, que estejam dentro do limite. 
	 * Depois, filtra aqueles imóveis que a coordenada y não esteja de acordo com o critério, ou seja, 
	 * que não estejam entre ay e by. 
	 * 
	 * @param ax coordenada x
	 * @param ay coordenada y
	 * @param bx coordenada x
	 * @param by coordenada y
	 * @return Os imóveis encontrados.
	 */
	public Properties findByArea(int ax, int ay, int bx, int by) {
		Set<Integer> keys = realtyMapByXPosition.keySet();
		List<Realty> possibleResult = new ArrayList<>();
		keys.forEach(key -> {
			if (key > ax && key < bx) {
				possibleResult.addAll(realtyMapByXPosition.get(key));
			}
		});
		Properties properties = new Properties();
		properties.setProperties(
				possibleResult.stream().filter(realty -> realty.getY() < ay && realty.getY() > by).collect(Collectors.toList()));
		return properties;
	}
}
