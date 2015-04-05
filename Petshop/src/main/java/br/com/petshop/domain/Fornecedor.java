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
@Table(name="fornecedor")
public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="for_id", nullable=false)
	private Long codigo;
	
	@Column(name="for_nome", nullable=false, length=50)
	private String nome;
	
	@Column(name="for_cnpj", nullable=false, length=18, unique=true)
	private String cnpj;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="for_endereco", referencedColumnName="end_id", nullable=false)
	private Endereco endereco;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="fornecedor")
	private List<Telefone> telefones;
}
