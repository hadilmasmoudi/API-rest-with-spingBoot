package com.soa.produit_electro.model;



import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Produit {
	private final UUID id;
	private final String name;
	private final double prix;
	public Produit(@JsonProperty("id")UUID id ,@JsonProperty("name")String name, @JsonProperty("prix")double prix) {
		this.id=id;
		this.name=name;
		this.prix=prix;
		
	}
	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Double getPrix() {
		return prix;
	}
	

}
