package com.uce.edu.service;

import java.math.BigDecimal;

import com.uce.edu.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
//CRUD
	public CuentaBancaria buscar(Integer id);

	public void guardar(CuentaBancaria bancaria);

	public void actualizar(CuentaBancaria bancaria);

	public void eliminar(Integer id);

	public void realizarTranferencia(String noCuentaOrigen, String noCuentaDestino, BigDecimal monto);

}
