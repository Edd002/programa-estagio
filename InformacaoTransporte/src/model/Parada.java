package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Eduardo Augusto
 *
 * Classe Parada.
 */
@Entity(name="Parada")
@Table(name="Parada")
public class Parada {
	@Id
	@Column(name="id", updatable=false, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="name", nullable=false, columnDefinition="varchar(255)")
	private String name;

	@Column(name="latitude", nullable=false)
	private double latitude;

	@Column(name="longitude", nullable=false)
	private double longitude;

	public Parada() {
	}

	public Parada(String name, double latitude, double longitude) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
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
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Parada [id=" + id + ", name=" + name + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
}