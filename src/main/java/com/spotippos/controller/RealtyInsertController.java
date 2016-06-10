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
	
	/**
	 * Insere um imovel
	 * 
	 * @param imovel o imovel a ser inserido
	 * @return mensagem de sucesso.
	 * @throws CouldNotInsertRealtyException caso o imóvel não seja inserido.
	 */
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public String insert(@RequestBody @Valid Realty imovel) throws CouldNotInsertRealtyException{
		LOG.info("Iniciando inclusão de imóvel " + imovel.getTitle());
		
		servico.insert(imovel);
		
		LOG.info(imovel.getTitle() + " inserido com sucesso!");

		return imovel.getTitle() + " inserido com sucesso!";
	}
}
