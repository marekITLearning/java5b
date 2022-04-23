package sk.itlearning.java5.webservice;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sk.itlearning.java5.webservicejpa.Zakaznik;
import sk.itlearning.java5.webservicejpa.ZakaznikService;

@Path("catalog")
public class CatalogApi {

	@Inject
	private ZakaznikService zs;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Zakaznik> getCatalog() {
		return zs.getAll();
	}

}
