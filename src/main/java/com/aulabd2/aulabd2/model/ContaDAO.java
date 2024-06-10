package com.aulabd2.aulabd2.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ContaDAO {

	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void inserirConta(Conta conta) {
		String sql = "INSERT INTO conta(add1,add2)" +
	                 " VALUES (?,?)";
		Object[] obj = new Object[2];
		//primeiro ?
		obj[0] = conta.getAdd1();
		//segundo ?
		obj[1] = conta.getAdd2();
		jdbc.update(sql, obj);
	}

    public List<Map<String, Object>> listarContas() {
    	String sql = "SELECT * FROM conta";
    	return jdbc.queryForList(sql);
    }

	//Lista de 1
	public List<Map<String,Object>> obterConta(int id){
		String sql = "SELECT * FROM conta where id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		return jdbc.queryForList(sql, obj);
	}

	public void atualizarConta(int id, Conta conta){
		String sql = "UPDATE conta SET add1 = ?," + 
		             "add2 = ? WHERE id = ?";
		Object[] obj = new Object[3];
		obj[0] = conta.getAdd1();
		obj[1] = conta.getAdd2();
		obj[2] = id;
		jdbc.update(sql, obj);
	}

	public void apagarConta(int id){
		String sql = "DELETE FROM conta WHERE id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		jdbc.update(sql, obj);
	}


    // @Autowired
	// DataSource dataSource;
	
	// JdbcTemplate jdbc;
	
	// @PostConstruct
	// private void initialize() {
	// 	jdbc = new JdbcTemplate(dataSource);
	// }
	
	// public void inserirConta(Conta conta) {
	// 	String sql = "INSERT INTO conta(add1,add2)" +
	//                  " VALUES (?,?)";
	// 	Object[] obj = new Object[2];
	// 	//primeiro ?
	// 	obj[0] = conta.getAdd1();
	// 	//segundo ?
	// 	obj[1] = conta.getAdd2();
	// 	jdbc.update(sql, obj);
	// }

    // public List<Map<String, Object>> listarContas() {
    // 	String sql = "SELECT * FROM conta";
    // 	return jdbc.queryForList(sql);
    // }

	// //Lista de 1
	// public List<Map<String,Object>> obterConta(int id){
	// 	String sql = "SELECT * FROM conta where id = ?";
	// 	Object[] obj = new Object[1];
	// 	obj[0] = id;
	// 	return jdbc.queryForList(sql, obj);
	// }

	// public void atualizarConta(int id, Conta conta){
	// 	String sql = "UPDATE conta SET add1 = ?," + 
	// 	             "add2 = ? WHERE id = ?";
	// 	Object[] obj = new Object[3];
	// 	obj[0] = conta.getAdd1();
	// 	obj[1] = conta.getAdd2();
	// 	obj[2] = id;
	// 	jdbc.update(sql, obj);
	// }

	// public void apagarConta(int id){
	// 	String sql = "DELETE FROM conta WHERE id = ?";
	// 	Object[] obj = new Object[1];
	// 	obj[0] = id;
	// 	jdbc.update(sql, obj);
	// }

    

    
    // @Autowired
    // DataSource dataSource;

    // JdbcTemplate jdbc;

    // @PostConstruct
    // private void initialize(){
    //     jdbc = new JdbcTemplate(dataSource);
    // }

    // public void inserirConta(Conta conta){
    //     String sql = "INSERT INTO conta(cla,genero,nivel,valor,add1,add2)"
    //                  + " VALUES (?,?,?,?,?,?)";
    //     Object[] obj = new Object[6];
    //     //primeiro ?
    //     obj[0] = conta.getCla();
    //     //segundo ?
    //     obj[1] = conta.getGenero();
    //     //terceiro ?
    //     obj[2] = conta.getNivel();
    //     obj[3] = conta.getValor();
    //     obj[4] = conta.getAdd1();
    //     obj[5] = conta.getAdd2();
    //     jdbc.update(sql, obj);
    // }

    // public List<Map<String, Object>> listarContas(){
    //     String sql = "SELECT * FROM conta";
    //     return jdbc.queryForList(sql);
    // }

    // public List<Map<String,Object>> obterConta(int id){
    //     String sql = "SELECT * FROM conta where id = ?";
	// 	Object[] obj = new Object[1];
	// 	obj[0] = id;
	// 	return jdbc.queryForList(sql, obj);
    // }

    // public void atualizarConta(int id, Conta conta){
    //     String sql = "UPDATE conta SET cla = ?, genero = ?, nivel = ?, valor = ?, add1 = ?, add2 = ? WHERE id = ?";
    //     Object[] obj = new Object[7];
    //     obj[0] = conta.getCla();
    //     obj[1] = conta.getGenero();
    //     obj[2] = conta.getNivel();
    //     obj[3] = conta.getValor();
    //     obj[4] = conta.getAdd1();
    //     obj[5] = conta.getAdd2();
    //     obj[6] = id;
    //     jdbc.update(sql, obj);
    // }

    // public void apagarConta(int id){
	// 	String sql = "DELETE FROM conta WHERE id = ?";
	// 	Object[] obj = new Object[1];
	// 	obj[0] = id;
	// 	jdbc.update(sql, obj);
	// }



}
