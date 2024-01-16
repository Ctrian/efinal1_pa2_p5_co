package com.uce.edu.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ICuentaBancariaRepository;
import com.uce.edu.repository.IPropietarioRepository;
import com.uce.edu.repository.modelo.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {

	@Autowired
	private ICuentaBancariaRepository bancariaRepository;

	@Autowired
	private IPropietarioRepository iPropietarioRepository;

	@Override
	public CuentaBancaria buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionar(id);
	}

	@Override
	public void guardar(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepository.insertar(bancaria);
	}

	@Override
	public void actualizar(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepository.actualizar(bancaria);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.bancariaRepository.eliminar(id);
	}

	@Override
	public void realizarTranferencia(String noCuentaOrigen, String noCuentaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		CuentaBancaria origen = this.bancariaRepository.obtenerNoCuenta(noCuentaOrigen);
		CuentaBancaria destino = this.bancariaRepository.obtenerNoCuenta(noCuentaDestino);
	
		BigDecimal comision = monto.multiply(new BigDecimal(0.1));
		origen.setSaldo(monto.subtract(comision));
		
		destino.setSaldo(destino.getSaldo().add(monto));
		
		this.bancariaRepository.actualizar(origen);
	}

}
