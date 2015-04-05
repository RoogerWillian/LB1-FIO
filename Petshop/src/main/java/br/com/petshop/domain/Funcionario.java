package br.com.petshop.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="funcionario")
public class Funcionario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fun_id", nullable=false)
	private Long codigo;
	
	@Column(name="fun_nome", nullable=false, length=50)
	private String nome;
	
	@Column(name="fun_cpf", nullable=false, length=14, unique=true)
	private String cpf;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	@JoinColumn(name="fun_empresa", referencedColumnName="emp_id", nullable=false)
	private Empresa empresa;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="fun_funcao", referencedColumnName="fun_id", nullable=false)
	private Funcao funcao;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fun_endereco", referencedColumnName="end_id", nullable=false)
	private Endereco endereco;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="funcionario")
	private List<Telefone> telefones;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
