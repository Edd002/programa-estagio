package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Eduardo Augusto
 *
 * Classe Veiculo.
 */
@Entity(name="Veiculo")
@Table(name="Veiculo")
public class Veiculo {
	@Id
	@Column(name="id", updatable=false, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="name", nullable=false, columnDefinition="varchar(255)")
	private String name;

	@Column(name="modelo", nullable=false, columnDefinition="varchar(255)")
	private String modelo;

	@ManyToOne(optional=false)
	@JoinColumn(name="id_linha", referencedColumnName="id")
	private Linha linha;

	public Veiculo() {
	}

	public Veiculo(String name, String modelo, Linha linha) {
		this.name = name;
		this.modelo = modelo;
		this.linha = linha;
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
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Linha getLinha() {
		return linha;
	}
	public void setLinha(Linha linha) {
		this.linha = linha;
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", name=" + name + ", modelo=" + modelo + ", linha=" + linha + "]";
	}
}