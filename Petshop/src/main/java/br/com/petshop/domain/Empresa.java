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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="empresa")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="emp_id", nullable=false)
	private Long codigo;
	
	@Column(name="emp_nome_fantasia", nullable=false, length=40)
	private String nomeFantasia;
	
	@Column(name="emp_razao_social", nullable=false, length=40)
	private String razaoSocial;
	
	@Column(name="emp_cnpj", nullable=false, length=18)
	private String cnpj;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="emp_endereco", referencedColumnName="end_id", nullable=false)
	private Endereco endereco;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="empresa")
	private List<Telefone> telefones;
}
