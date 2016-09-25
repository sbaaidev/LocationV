package database;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Client;
import model.Location;
import model.Marque;
import model.Modelv;
import model.Voiture;


public class ImpOperations implements InterOperations {
    @PersistenceContext
private EntityManager em;

	@Override
	public Modelv addModelv(Modelv mv) {	
		em.persist(mv);
		return mv;
	}

	@Override
	public Modelv getModelvById(Long id) {
		
		return em.find(Modelv.class, id);
	}

	@Override
	public Marque addMarque(Marque m) {
		em.persist(m);
		return m;
	}

	@Override
	public Marque getMarqueById(int id) {
		
	return em.find(Marque.class, id);
	}

	@Override
	public Voiture addVoiture(Voiture v) {
		em.persist(v);
		return v;
	}

	@Override
	public Voiture getVoitureByMat(String mat) {
		Query req=em.createQuery("select v from Voiture v where v.mat = :x");
		req.setParameter("x", mat);
		return (Voiture) req.getSingleResult();
	}

	@Override
	public void deleteModel(Long id) {
		em.remove(getModelvById(id));
		
	}

	@Override
	public void updateModel(Modelv mv) {
		em.merge(mv);
		
	}

	@Override
	public void deleteMarque(int id) {
		em.remove(getMarqueById(id));
		
	}

	@Override
	public void updateMarque(Marque m) {
		em.merge(m);
		
	}

	@Override
	public List<Voiture> getAllVoitures() {
		Query req=em.createQuery("select v from Voiture v");
		return req.getResultList();
	}

	@Override
	public List<Voiture> getVoituresByMarque(Marque marque) {
		Query req=em.createQuery("select v from Voiture v where v.marque.idMarque =:x");
		req.setParameter("x", marque.getIdMarque());
		return req.getResultList();
	}

	@Override
	public List<Voiture> getVoituresByModel(Modelv model) {
		Query req=em.createQuery("select v from Voiture v where v.marque.model.idModelv =:x");
		req.setParameter("x", model.getIdModelv());
		return req.getResultList();
	}

	

	@Override
	public void updateVoiture(Voiture v) {
		em.merge(v);
		
	}

	@Override
	public Client addClient(Client c) {
		em.persist(c);
		return c;
	}

	@Override
	public Client getClientById(Long id) {		
		return em.find(Client.class, id);
	}

	@Override
	public List<Client> getAllClients() {
		Query req=em.createQuery("select c from Client c");
		return req.getResultList();
	}

	@Override
	public List<Client> getClientByCNI(String cni) {
		Query req=em.createQuery("select c from Client where c.numCNI like :x");
		req.setParameter("x", "%"+cni+"%");
		return req.getResultList();
	}

	@Override
	public void deleteClient(Long id) {
		em.remove(getClientById(id));
		
	}

	@Override
	public void updateClient(Client c) {
		em.merge(c);
		
	}

	@Override
	public Location addLocation(Location l) {
		em.persist(l);
		return l;
	}

	@Override
	public Location getLocationById(Long id) {
		
		return em.find(Location.class, id);
	}

	@Override
	public List<Location> getAllLocations() {
		Query req=em.createQuery("select l from Location l");
		return req.getResultList();
	}

	@Override
	public List<Location> getLocationsByDate(String str) {
		Query req=em.createQuery("select l from Location l where l.dateLocation like :x");
		req.setParameter("x", "%"+str+"%");
		return req.getResultList();
	}

	@Override
	public List<Location> getLocationsByClient(Client c) {
		Query req=em.createQuery("select l from Location l where l.client.idClient like :x");
		req.setParameter("x", "%"+c.getIdClient()+"%");
		return req.getResultList();
	}

	@Override
	public List<Location> getLocationsByVoiture(Voiture v) {
		Query req=em.createQuery("select l from Location l where l.voiture.mat like :x");
		req.setParameter("x", "%"+v.getMat()+"%");
		return req.getResultList();
	}

	@Override
	public void deleteLocation(Long id) {
		em.remove(getLocationById(id));
		
	}

	@Override
	public void updateLocation(Location l) {
		em.merge(l);
		
	}

	@Override
	public List<Marque> getAllMarque() {
		Query req=em.createQuery("select m from Marque m");
		return req.getResultList();
	}

	@Override
	public List<Modelv> getAllModel() {
		Query req=em.createQuery("select m from Modelv m");
		return req.getResultList();
		
	}

	@Override
	public void deleteVoiture(Long id) {
		em.remove(em.find(Voiture.class, id));
		
	}
 
}
