package com.soa.produit_electro.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.soa.produit_electro.dao.ProduitDao;
import com.soa.produit_electro.model.Produit;
@Service
public class ProduitService {
	private final ProduitDao produitDao;
	@Autowired
	public ProduitService(@Qualifier("Dao")ProduitDao produitDao) {
		this.produitDao=produitDao;
		
	}
	public int addProduit(Produit produit) {
		return produitDao.insertProduit( produit);
		
	}
	public List<Produit> getAllProduit(){
		return produitDao.selectAllProduit();
	}
	public Optional<Produit> getProduitById(UUID id){
		return produitDao.selectProduitById(id);
	}
	public int deleteProduit(UUID id) {
		return produitDao.deleteProduitById(id);
	}
	public int updateProduit(UUID id, Produit newProduit) {
		return produitDao.updateProduitById(id, newProduit);
	}

}
