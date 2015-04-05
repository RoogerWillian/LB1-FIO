package br.com.petshop.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriarTabelas {
	public static void main(String[] args) {
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("PetshopPU");
		createEntityManagerFactory.close();
	}
}
