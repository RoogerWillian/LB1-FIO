package br.com.petshop.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Animal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ani_id", nullable=false)
	private Long codigo;
	
	@Column(name="ani_nome", nullable=false, length=30)
	private String nome;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	@JoinColumn(name="ani_raca", referencedColumnName="rac_id", nullable=false)
	private Raca raca;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	@JoinColumn(name="ani_dono", referencedColumnName="cli_id", nullable=false)
	private Cliente dono;

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

	public Raca getRaca() {
		return raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
	}

	public Cliente getDono() {
		return dono;
	}

	public void setDono(Cliente dono) {
		this.dono = dono;
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
		Animal other = (Animal) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
