package com.soa.produit_electro.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soa.produit_electro.model.Produit;
import com.soa.produit_electro.service.ProduitService;

@RequestMapping("api/soa/produit")
@RestController
public class ProduitController {
	private final ProduitService produitService;
	@Autowired
	public ProduitController(ProduitService produitService) {
		this.produitService=produitService;
		
	}
	@PostMapping
	public void addProduit(@RequestBody Produit produit) {
		produitService.addProduit( produit);
	}
	@GetMapping
	public List<Produit> getAllProduit(){
		return produitService.getAllProduit();
	}
	@GetMapping(path="{id}")
	public Produit getProduitById(@PathVariable("id")UUID id) {
		return produitService.getProduitById(id).orElse(null);
	}
	@DeleteMapping(path="{id}")
	public void deleteProduitById(@PathVariable("id")UUID id) {
		produitService.deleteProduit(id);
	}
	@PutMapping(path="{id}")
	public void updateProduit(@PathVariable("id")UUID id,@RequestBody Produit produitToUpdate) {
		produitService.updateProduit(id, produitToUpdate);
	}
	

}
