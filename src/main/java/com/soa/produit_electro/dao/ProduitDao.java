package com.soa.produit_electro.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.soa.produit_electro.model.Produit;

public interface ProduitDao {
	int insertProduit(UUID id,Produit produit);
	default int insertProduit(Produit produit) {
		UUID id=UUID.randomUUID();
		return insertProduit(id,produit);
		
	}
	List<Produit>selectAllProduit();
	Optional<Produit> selectProduitById(UUID id);
	 int deleteProduitById(UUID id);
	 
	 int updateProduitById(UUID id,Produit produit);
	 

}
