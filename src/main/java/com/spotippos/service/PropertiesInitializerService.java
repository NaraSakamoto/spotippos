package com.spotippos.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spotippos.model.Properties;
import com.spotippos.model.Realty;
import com.spotippos.model.enumx.Provinces;
import com.spotippos.repository.RealtyRepository;

/**
 * Serviço que lê as imóveis do arquivo.
 * 
 * @author Nara
 *
 */
@Service
public class PropertiesInitializerService {

	private static final String TITTLE = "Imóvel código %d, com %d quartos e %d banheiros";

	@Value("${properties.file.path}")
	private String path;

	@Autowired
	private RealtyRepository repository;

	/**
	 * Carrega para a memória e preenche os dados que estão faltando.
	 * 
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@PostConstruct
	public void read() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Properties properties = mapper.readValue(getFileContent(), Properties.class);

		for (Realty realty : properties.getProperties()) {
			realty.setTitle(String.format(TITTLE, realty.getId(), realty.getBeds(), realty.getBaths()));
			List<Provinces> provinces = Provinces.getProvincesByPosition(realty.getX(), realty.getY());
			realty.setProvinces(provinces);
			repository.insert(realty);
		}
	}

	/**
	 * Recupera o arquivo com o Json dos imóveis para carregar na memória.
	 * 
	 * @return o arquivo dos imóveis.
	 * @throws IOException Caso ocorra algum erro.
	 */
	private InputStream getFileContent() throws IOException {
		ClassPathResource resource = new ClassPathResource(path);
		return resource.getInputStream();
	}

}
