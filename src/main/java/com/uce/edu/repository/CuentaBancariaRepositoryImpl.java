package com.uce.edu.repository;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.CuentaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CuentaBancaria seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CuentaBancaria.class, id);
	}

	@Override
	public void insertar(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		this.entityManager.persist(bancaria);
	}

	@Override
	public void actualizar(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(bancaria);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		CuentaBancaria bancaria = this.seleccionar(id);
		this.entityManager.remove(bancaria);
	}

	@Override
	public CuentaBancaria obtenerNoCuenta(String noCuenta) {
		// TODO Auto-generated method stub
		TypedQuery<CuentaBancaria> mQ = this.entityManager
				.createQuery("SELECT cb FROM CuentaBancaria cb WHERE cb.numero = : variable", CuentaBancaria.class);
		mQ.setParameter("variable", noCuenta);
		return mQ.getSingleResult();
	}

	@Override
	public CuentaBancaria obtenerSaldo(BigDecimal saldo) {
		// TODO Auto-generated method stub
		TypedQuery<CuentaBancaria> mQ = this.entityManager
				.createQuery("SELECT cb FROM CuentaBancaria cb WHERE cb.saldo = : variable", CuentaBancaria.class);
		mQ.setParameter("variable", saldo);
		return mQ.getSingleResult();
	}

	@Override
	public CuentaBancaria realizarTranferencia(String noCuentoOrigen, String noCuentaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		return null;
	}

}
