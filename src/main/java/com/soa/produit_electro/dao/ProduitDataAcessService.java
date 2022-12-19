package com.soa.produit_electro.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.soa.produit_electro.model.Produit;
@Repository("Dao")
public class ProduitDataAcessService implements ProduitDao{
	
	
	private static List<Produit> DB=new ArrayList<>();

	@Override
	public int insertProduit(UUID id, Produit produit) {
		DB.add(new Produit(id,produit.getName(),produit.getPrix()));
		
		return 1;
	}

	@Override
	public List<Produit> selectAllProduit() {
		
		return DB;
	}

	@Override
	public Optional<Produit> selectProduitById(UUID id) {
		
		return DB.stream().filter(produit -> produit.getId().equals(id)).findFirst();
				}

	@Override
	public int deleteProduitById(UUID id) {
		Optional<Produit> produitMaybe =selectProduitById(id);
		if(produitMaybe.isEmpty()) {
		return 0;
	}
		DB.remove(produitMaybe.get());
		return 1;
}

	@Override
	public int updateProduitById(UUID id, Produit produit) {
		// TODO Auto-generated method stub
		return selectProduitById(id).map(p ->{ int indexOfProduitToUpdate=DB.indexOf(p);
		if(indexOfProduitToUpdate >=0) {
			DB.set(indexOfProduitToUpdate, new Produit(id,produit.getName(),produit.getPrix()));
		}
			return 0;
		})
				.orElse(0);
	}
	 

}
