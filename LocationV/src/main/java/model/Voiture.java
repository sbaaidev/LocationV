package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.ui.Model;
@Entity
public class Voiture implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long idVoiture;
	String mat;
	String coleur;
	double puissance;
	boolean Reserved;
	double prix;
	String image;
	Integer compteur;
	Integer frein;
	@ManyToOne
	@JoinColumn(name="idMarque")
	Marque marque;
	
	Modelv model;
	@OneToMany(mappedBy="voiture",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	List<Location >location;
	
	public List<Location> getLocation() {
		return location;
	}
	public void setLocation(List<Location> location) {
		this.location = location;
	}
	public Long getIdVoiture() {
		return idVoiture;
	}
	public void setIdVoiture(Long idVoiture) {
		this.idVoiture = idVoiture;
	}
	public String getMat() {
		return mat;
	}
	public void setMat(String mat) {
		this.mat = mat;
	}
	public String getColeur() {
		return coleur;
	}
	public void setColeur(String coleur) {
		this.coleur = coleur;
	}
	public double getPuissance() {
		return puissance;
	}
	public void setPuissance(double puissance) {
		this.puissance = puissance;
	}
	public Marque getMarque() {
		return marque;
	}
	public void setMarque(Marque marque) {
		this.marque = marque;
	}
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public boolean isReserved() {
		return Reserved;
	}
	public void setReserved(boolean reserved) {
		Reserved = reserved;
	}
	
	
	
	public Integer getCompteur() {
		return compteur;
	}
	public void setCompteur(Integer compteur) {
		this.compteur = compteur;
	}
	
	
	public Integer getFrein() {
		return frein;
	}
	public void setFrein(Integer frein) {
		this.frein = frein;
	}
	
	
	public Modelv getModelv() {
		return model;
	}
	public void setModelv(Modelv model) {
		this.model = model;
	}
	public Voiture(String mat, String coleur, double puissance, boolean reserved, double prix, Marque marque) {
		super();
		this.mat = mat;
		this.coleur = coleur;
		this.puissance = puissance;
		Reserved = reserved;
		this.prix = prix;
		this.marque = marque;
	}
	public Voiture() {
		super();
		
	}
	
	public String toString() {
		return mat;
	}
	
	
	
	

}
