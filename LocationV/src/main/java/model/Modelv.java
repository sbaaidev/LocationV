package model;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Modelv implements Serializable{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
Long idModelv;
String name;
@ManyToOne
@JoinColumn(name="idMarque")
Marque marque;
public Modelv(String name) {
	super();
	this.name = name;
}
public Long getIdModelv() {
	return idModelv;
}
public void setIdModelv(Long idModelv) {
	this.idModelv = idModelv;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


public Marque getMarque() {
	return marque;
}
public void setMarque(Marque marque) {
	this.marque = marque;
}
public Modelv() {
	super();
	// TODO Auto-generated constructor stub
}

public Modelv(String name,Marque marque) {
	this.marque = marque;
	this.name=name;
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return name;
}


}
