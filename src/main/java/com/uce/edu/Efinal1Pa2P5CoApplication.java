package com.uce.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.CuentaBancaria;
import com.uce.edu.repository.modelo.Propietario;
import com.uce.edu.service.ICuentaBancariaService;

@SpringBootApplication
public class Efinal1Pa2P5CoApplication implements CommandLineRunner {

	@Autowired
	private ICuentaBancariaService bancariaService;

	public static void main(String[] args) {
		SpringApplication.run(Efinal1Pa2P5CoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// 1
		CuentaBancaria bancaria1 = new CuentaBancaria();
		bancaria1.setNumero(123);
		bancaria1.setSaldo(new BigDecimal(50));
		bancaria1.setTipo("ahorros");

		Propietario propietario1 = new Propietario();
		propietario1.setNombre("Andres");
		propietario1.setApellido("Oli");
		propietario1.setCedula("1750");

		bancaria1.setPropietario(propietario1);

		// this.bancariaService.guardar(bancaria1);

		CuentaBancaria bancaria2 = new CuentaBancaria();
		bancaria2.setNumero(333);
		bancaria2.setSaldo(new BigDecimal(50));
		bancaria2.setTipo("corriente");

		Propietario propietario2 = new Propietario();
		propietario2.setNombre("Cristian");
		propietario2.setApellido("Calvache");
		propietario2.setCedula("1720");

		bancaria2.setPropietario(propietario2);

		this.bancariaService.guardar(bancaria2);

		this.bancariaService.realizarTranferencia("123", "333", new BigDecimal(20));

	}

}
