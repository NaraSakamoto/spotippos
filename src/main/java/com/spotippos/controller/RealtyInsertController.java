package com.spotippos.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spotippos.exception.CouldNotInsertRealtyException;
import com.spotippos.model.Realty;
import com.spotippos.service.RealtyInsertService;

/**
 * Recebe as requisições
 * 
 * @author Nara
 *
 */
@RestController
@RequestMapping("properties")
public class RealtyInsertController {

	private static Logger LOG = Logger.getLogger(RealtyInsertController.class.getName());
	
	@Autowired
	private RealtyInsertService servico;
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public String insert(@RequestBody @Valid Realty imovel) throws CouldNotInsertRealtyException{
		LOG.info("Iniciando inclusão de imóvel " + imovel.getTitle());
		
		servico.insert(imovel);
		
		LOG.info("Imóvel " + imovel.getTitle() + " inserido com sucesso!");

		//TODO - pensar melhor no retorno (Será que String é o melhor?)
		return "Imóvel " + imovel.getTitle() + " inserido com sucesso!";
	}
}
