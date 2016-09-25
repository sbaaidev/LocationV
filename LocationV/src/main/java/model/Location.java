 package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Location implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long nbLocation;
	String dateLocation;
	String dateDebut;
	String dateFin;
	String typePayement;
	double Montant;
	@ManyToOne
	@JoinColumn(name="idVoiture")
	Voiture voiture;
	@ManyToOne
	@JoinColumn(name="idClient")
	Client client;
	public Long getNbLocation() {
		return nbLocation;
	}
	public void setNbLocation(Long nbLocation) {
		this.nbLocation = nbLocation;
	}
	public String getDateLocation() {
		return dateLocation;
	}
	public void setDateLocation(String dateLocation) {
		this.dateLocation = dateLocation;
	}
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	public String getTypePayement() {
		return typePayement;
	}
	public void setTypePayement(String typePayement) {
		this.typePayement = typePayement;
	}
	public double getMontant() {
		return Montant;
	}
	public void setMontant(double montant) {
		Montant = montant;
	}
	public Voiture getVoiture() {
		return voiture;
	}
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Location(String dateLocation, String dateDebut, String dateFin, String typePayement, double montant,
			Voiture voiture, Client client) {
		super();
		this.dateLocation = dateLocation;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.typePayement = typePayement;
		Montant = montant;
		this.voiture = voiture;
		this.client = client;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(nbLocation);
	}
	

}
