package test;
import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import model.Client;
import model.Location;
import model.Marque;
import model.Modelv;
import model.Voiture;
import services.InterServices;
import services.ServiceClass;

public class TestUnit {

	@Before
	public void setUp() throws Exception {
		System.out.println("ddddd");
	}

	@Test
	public void test() {
		InterServices services=ServiceClass.getService();
		/*services.addMarque(new Marque("fiat"));
		services.addModelv(new Modelv("e560a"));
		services.addVoiture(new Voiture("cc528d", "noire", 205.5, false, 1000,services.getMarqueById(1)));
		services.addVoiture(new Voiture("cc528dd", "rouge", 205.5, false, 1000,services.getMarqueById(1)));
		services.addClient(new Client("hamza sbaai", "jt31410", "ouled teima", "0652544875", "image"));
		services.addClient(new Client("ahmed elwasifi", "a25845", "chamaaya", "065878542", "image"));
	Client c=services.getClientById(1l);
		c.setNomPrenom("mohamed adil");
		c.setNumCNI("te587568");
		services.updateClient(c);
		for(Client cc:services.getAllClients()){
			System.out.println(cc.getNumCNI());
		}
		
*/
/*Location loc=new Location();
		loc.setDateDebut(LocalDate.now().toString());
		loc.setDateFin(LocalDate.now().plusDays(5).toString());
		loc.setDateLocation(LocalDate.now().toString());
		loc.setVoiture(services.getVoitureByMat("cc528d"));
		loc.setClient(services.getClientById(1l));
		loc.setTypePayement("cheque");
		loc.setMontant(3000.50);
		services.addLocation(loc);	*/
		
		//services.deleteLocation(2L);
//	for(Location l:services.getAllLocations()){
	//		System.out.println(l.getDateDebut()+"--"+l.getDateFin()+"---"+l.getNbLocation()+"cl:"+l.getClient().getNomPrenom()+"-Voit :"+l.getVoiture().getMarque().getName()+" mod :"+l.getVoiture().getMarque().getModel().get(0).getName());
	//	}
				
	}

}
