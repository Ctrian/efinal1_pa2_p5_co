package com.uce.edu.repository;

import java.math.BigDecimal;

import com.uce.edu.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {
//CRUD
	public CuentaBancaria seleccionar(Integer id);

	public void insertar(CuentaBancaria bancaria);

	public void actualizar(CuentaBancaria bancaria);

	public void eliminar(Integer id);

	public CuentaBancaria obtenerNoCuenta(String noCuenta);

	public CuentaBancaria obtenerSaldo(BigDecimal saldo);

	public CuentaBancaria realizarTranferencia(String noCuentaOrigen, String noCuentaDestino, BigDecimal monto);
}
