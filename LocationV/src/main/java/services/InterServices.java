package services;

import model.*;

import java.util.List;

/**
 * Created by it4omanHamza on 02/06/2016.
 */
public interface InterServices {
	//modelV
		public Modelv addModelv(Modelv mv);
		public Modelv getModelvById(Long id);
		public void deleteModel(Long id);
		public void updateModel(Modelv mv);
		public List<Modelv> getAllModel();
		//marqueV
		public Marque addMarque(Marque m);
		public Marque getMarqueById(int id);
		public void deleteMarque(int id);
		public void updateMarque(Marque m);
		public List<Marque> getAllMarque();
		//Voiture
		public Voiture addVoiture(Voiture v);
		public Voiture getVoitureByMat(String mat);
		public List<Voiture> getAllVoitures();
		public List<Voiture> getVoituresByMarque(Marque marque);
		public List<Voiture> getVoituresByModel(Modelv model);
		public void deleteVoiture(Long id);
		public void updateVoiture(Voiture v);

		//Client
		public Client addClient(Client c);
		public Client getClientById(Long id);
		public List<Client> getAllClients();
		public List<Client> getClientByCNI(String cni);
		public void deleteClient(Long id);
		public void updateClient(Client c);
		
		//Location
		public Location addLocation(Location l);
		public Location getLocationById(Long id);
		public List<Location> getAllLocations();
		public List<Location> getLocationsByDate(String str);
		public List<Location> getLocationsByClient(Client c);
		public List<Location> getLocationsByVoiture(Voiture v);
		public void deleteLocation(Long id);
		public void updateLocation(Location l);
}
