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
import org.springframework.ui.Model;
@Entity
public class Marque implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idMarque;
	String name;
	@OneToMany(fetch=FetchType.EAGER,mappedBy="marque",cascade = CascadeType.ALL)
	List<Modelv> model;
	@OneToMany(fetch=FetchType.LAZY,mappedBy="marque",cascade = CascadeType.ALL)
	List<Voiture> voitures;
	
	public int getIdMarque() {
		return idMarque;
	}
	public void setIdMarque(int idMarque) {
		this.idMarque = idMarque;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Modelv> getModel() {
		return model;
	}
	public void setModel(List<Modelv> model) {
		this.model = model;
	}
	public List<Voiture> getVoitures() {
		return voitures;
	}
	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}
	public Marque() {
		super();
		
	}
	
	
	
	public Marque(String name) {
		this.name=name;
	}
	public String toString() {
		return name;
	}
	
	
	

}
