package com.spotippos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spotippos.exception.RealtyNotFoundException;
import com.spotippos.model.Properties;
import com.spotippos.model.Realty;
import com.spotippos.repository.RealtyRepository;

/**
 * Recebe requisições de busca.
 * 
 * @author Nara
 *
 */
@RestController
@RequestMapping("properties")
public class RealtySearchController {

	@Autowired
	private RealtyRepository repository;

	/**
	 * Encontra imóvel pelo id
	 * 
	 * @param id o id para procurar
	 * @return o imóvel do id correspondente.
	 * @throws RealtyNotFoundException Caso não encontre o imóvel desejado.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Realty findById(@PathVariable int id) throws RealtyNotFoundException {
		return repository.findById(id);
	}

	/**
	 * Encontra os imóveis de uma determinada área A x B sendo que A e B são pontos de coordenada (x,y).
	 * 
	 * @param ax coordenada x do ponto A
	 * @param ay coordenada y do ponto A
	 * @param bx coordenada x do ponto B
	 * @param by coordenada y do ponto B
	 * @return Imoveis encontrados dentro dá área delimitada pelos pontos A e B.
	 * @throws RealtyNotFoundException Caso não encontre imóveis.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Properties findByArea(@RequestParam(required = true) int ax, @RequestParam(required = true) int ay,
			@RequestParam(required = true) int bx, @RequestParam(required = true) int by) throws RealtyNotFoundException {
		return repository.findByArea(ax, ay, bx, by);
	}
}
