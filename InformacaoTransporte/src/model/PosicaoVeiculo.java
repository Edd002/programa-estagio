package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Eduardo Augusto
 *
 * Classe PosicaoVeiculo.
 */
@Entity(name="PosicaoVeiculo")
@Table(name="PosicaoVeiculo")
public class PosicaoVeiculo {
	@Id
	@Column(name="id", updatable=false, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="latitude", nullable=false)
	private double latitude;

	@Column(name="longitude", nullable=false)
	private double longitude;

	@MapsId
	@OneToOne
	@JoinColumn(name="id_veiculo", referencedColumnName="id")
	private Veiculo veiculo;

	public PosicaoVeiculo() {
	}

	public PosicaoVeiculo(double latitude, double longitude, Veiculo veiculo) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.veiculo = veiculo;
	}

	public long getId() {
		return id;
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
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	@Override
	public String toString() {
		return "PosicaoVeiculo [latitude=" + latitude + ", longitude=" + longitude + ", veiculo=" + veiculo + "]";
	}
}