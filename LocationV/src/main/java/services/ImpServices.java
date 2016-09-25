package services;

import database.InterOperations;
import model.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by it4omanHamza on 02/06/2016.
 */
@Transactional
class ImpServices implements InterServices{
    private InterOperations iop;

    public void setIop(InterOperations iop) {

        this.iop = iop;
    }

	@Override
	public Modelv addModelv(Modelv mv) {
		// TODO Auto-generated method stub
		return iop.addModelv(mv);
	}

	@Override
	public Modelv getModelvById(Long id) {
		// TODO Auto-generated method stub
		return iop.getModelvById(id);
	}

	@Override
	public Marque addMarque(Marque m) {
		// TODO Auto-generated method stub
		return iop.addMarque(m);
	}

	@Override
	public Marque getMarqueById(int id) {
		// TODO Auto-generated method stub
		return iop.getMarqueById(id);
	}

	@Override
	public Voiture addVoiture(Voiture v) {
		// TODO Auto-generated method stub
		return iop.addVoiture(v);
	}

	@Override
	public Voiture getVoitureByMat(String mat) {
		// TODO Auto-generated method stub
		return iop.getVoitureByMat(mat);
	}

	@Override
	public void deleteModel(Long id) {
		iop.deleteModel(id);
		
	}

	@Override
	public void updateModel(Modelv mv) {
		iop.updateModel(mv);
		
	}

	@Override
	public void deleteMarque(int id) {
		iop.deleteMarque(id);
		
	}

	@Override
	public void updateMarque(Marque m) {
		iop.updateMarque(m);
		
	}

	@Override
	public List<Voiture> getAllVoitures() {
		
		return iop.getAllVoitures();
	}

	@Override
	public List<Voiture> getVoituresByMarque(Marque marque) {
		
		return iop.getVoituresByMarque(marque);
	}

	@Override
	public List<Voiture> getVoituresByModel(Modelv model) {
		
		return iop.getVoituresByModel(model);
	}



	@Override
	public void updateVoiture(Voiture v) {
		iop.updateVoiture(v);
		
	}

	@Override
	public Client addClient(Client c) {
		
		return iop.addClient(c);
	}

	@Override
	public Client getClientById(Long id) {
		// TODO Auto-generated method stub
		return iop.getClientById(id);
	}

	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return iop.getAllClients();
	}

	@Override
	public List<Client> getClientByCNI(String cni) {
		// TODO Auto-generated method stub
		return iop.getClientByCNI(cni);
	}

	@Override
	public void deleteClient(Long id) {
		iop.deleteClient(id);
		
	}

	
	@Override
	public void updateClient(Client c) {
		iop.updateClient(c);
		
	}

	@Override
	public Location addLocation(Location l) {
		// TODO Auto-generated method stub
		return iop.addLocation(l);
	}

	@Override
	public Location getLocationById(Long id) {
		// TODO Auto-generated method stub
		return iop.getLocationById(id);
	}

	@Override
	public List<Location> getAllLocations() {
		// TODO Auto-generated method stub
		return iop.getAllLocations();
	}

	@Override
	public List<Location> getLocationsByDate(String str) {
		// TODO Auto-generated method stub
		return iop.getLocationsByDate(str);
	}

	@Override
	public List<Location> getLocationsByClient(Client c) {
		// TODO Auto-generated method stub
		return iop.getLocationsByClient(c);
	}

	@Override
	public List<Location> getLocationsByVoiture(Voiture v) {
		// TODO Auto-generated method stub
		return iop.getLocationsByVoiture(v);
	}

	@Override
	public void deleteLocation(Long id) {
		iop.deleteLocation(id);
		
	}

	@Override
	public void updateLocation(Location l) {
		iop.updateLocation(l);
		
	}

	@Override
	public List<Marque> getAllMarque() {
		
		return iop.getAllMarque();
	}

	@Override
	public List<Modelv> getAllModel() {
		
		return iop.getAllModel();
	}

	@Override
	public void deleteVoiture(Long id) {
		iop.deleteVoiture(id);
		
	}


	

   
}
