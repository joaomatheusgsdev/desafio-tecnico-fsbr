package br.desafio.fsbr.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.desafio.fsbr.dao.DaoCliente;
import br.desafio.fsbr.entidades.Cliente;

@RequestScoped
@ManagedBean(name = "clienteBean")
public class ClienteBean {
	
		
	private Cliente cliente = new Cliente();
	
	private DaoCliente daoCliente = new DaoCliente<Cliente>();
	
	private List<Cliente> clientes = new ArrayList<>();
	
	
	public String salvar() {
		
		
		System.out.println(cliente.getId());
		
		daoCliente.salvar(cliente);
		
		return "";
	}
	
	public String update(Cliente c) {
		
        
    System.out.println(c.getId());
    	
		return "";
		
	}
	
	public String deletar(Long id) {
		
		daoCliente.deletePorID(id);
		
		return "listarClientes.xhmtl?faces-redirect=true";
	}
	
	@PostConstruct
	public void carregarClientes() {
		
		clientes = daoCliente.listarClientes();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public DaoCliente getDaoCliente() {
		return daoCliente;
	}

	public void setDaoCliente(DaoCliente daoCliente) {
		this.daoCliente = daoCliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	

}
