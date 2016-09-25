package model;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Client implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
Long idClient;
String nomPrenom;
String numCNI;
String Address;
String Tel;
String imagePermis;
@OneToMany(fetch=FetchType.LAZY,mappedBy="client",cascade = CascadeType.ALL)
List<Location> location;
public Long getIdClient() {
	return idClient;
}
public void setIdClient(Long idClient) {
	this.idClient = idClient;
}
public String getNomPrenom() {
	return nomPrenom;
}
public void setNomPrenom(String nomPrenom) {
	this.nomPrenom = nomPrenom;
}
public String getNumCNI() {
	return numCNI;
}
public void setNumCNI(String numCNI) {
	this.numCNI = numCNI;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getTel() {
	return Tel;
}
public void setTel(String tel) {
	Tel = tel;
}
public String getImagePermis() {
	return imagePermis;
}
public void setImagePermis(String imagePermis) {
	this.imagePermis = imagePermis;
}


public List<Location> getLocation() {
	return location;
}
public void setLocation(List<Location> location) {
	this.location = location;
}
public Client(String nomPrenom, String numCNI, String address, String tel, String imagePermis) {
	super();
	this.nomPrenom = nomPrenom;
	this.numCNI = numCNI;
	Address = address;
	Tel = tel;
	this.imagePermis = imagePermis;
}
public Client() {
	super();
	
}

@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nomPrenom;
	}


}
