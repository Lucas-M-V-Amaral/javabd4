package com.aulabd2.aulabd2.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
    
	@Autowired
	ContaDAO cdao;
	
	public void inserirConta(Conta c) {
		cdao.inserirConta(c);
	}

    public List<Map<String, Object>> listarContas() {
		return cdao.listarContas();
	}

	public void atualizarConta(int id, Conta conta){
		cdao.atualizarConta(id, conta);
	}

	public List<Map<String, Object>> obterConta(int id){
		return cdao.obterConta(id);
	}

	public void apagarConta(int id){
		cdao.apagarConta(id);
	}


	// @Autowired
	// ContaDAO cdao;
	
	// public void inserirConta(Conta c) {
	// 	cdao.inserirConta(c);
	// }

    // public List<Map<String, Object>> listarContas() {
	// 	return cdao.listarContas();
	// }

	// public void atualizarConta(int id, Conta conta){
	// 	cdao.atualizarConta(id, conta);
	// }

	// public List<Map<String, Object>> obterConta(int id){
	// 	return cdao.obterConta(id);
	// }

	// public void apagarConta(int id){
	// 	cdao.apagarConta(id);
	// }


    // @Autowired
    // ContaDAO cdao;

    // public void inserirConta(Conta c) {
	// 	cdao.inserirConta(c);
	// }

    // public List<Map<String, Object>> listarContas() {
	// 	return cdao.listarContas();
	// }

	// public void atualizarConta(int id, Conta conta){
	// 	cdao.atualizarConta(id, conta);
	// }

	// public List<Map<String, Object>> obterConta(int id){
	// 	return cdao.obterConta(id);
	// }

	// public void apagarConta(int id){
	// 	cdao.apagarConta(id);
	// }

}
