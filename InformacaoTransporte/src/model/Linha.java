package model;

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
import javax.persistence.Table;

/**
 * @author Eduardo Augusto
 *
 * Classe Linha.
 */
@Entity(name="Linha")
@Table(name="Linha")
public class Linha {
	@Id
	@Column(name="id", updatable=false, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="name", nullable=false, columnDefinition="varchar(255)")
	private String name;

	@OneToMany(targetEntity=Parada.class, fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="id")
	private List<Parada> paradas;

	public Linha() {
	}

	public Linha(String name, List<Parada> paradas) {
		this.name = name;
		this.paradas = paradas;
	}

	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Parada> getParadas() {
		return paradas;
	}
	public void setParadas(List<Parada> paradas) {
		this.paradas = paradas;
	}

	@Override
	public String toString() {
		return "Linha [id=" + id + ", name=" + name + ", paradas=" + paradas + "]";
	}
}