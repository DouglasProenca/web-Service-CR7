package com.webServiceCR7Imports.webServiceCR7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webServiceCR7Imports.webServiceCR7.model.Country;
import com.webServiceCR7Imports.webServiceCR7.repository.CountryRepository;



@Service
public class CountryService {

	
	@Autowired
	CountryRepository repository;
	
	public List<Country> findAll() {
		return repository.retornaUsuario();
	}

}
