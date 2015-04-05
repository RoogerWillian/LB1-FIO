package br.com.petshop.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cli_id", nullable=false)
	private Long codigo;
	
	@Column(name="cli_nome", nullable=false , length=50)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="cli_data_nascimento", nullable=false)
	private Date dataNasimento;
	
	@Column(name="cli_tipo_pessoa", length=10)
	private String tipoPessoa;
	
	@Column(name="cli_cpf", length=14, unique=true)
	private String cpf;
	
	@Column(name="cli_cnpj", length=18, unique=true)
	private String cnpj;
	
	@Column(name="cli_razao_social", length=50)
	private String razaoSocial;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="cli_empresa", referencedColumnName="emp_id", nullable=false)
	private Empresa empresa;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="cli_endereco", referencedColumnName="end_id", nullable=false)
	private Endereco endereco;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL, mappedBy="cliente")
	private List<Telefone> telefones;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL, mappedBy="dono")
	private List<Animal> animais;
}
