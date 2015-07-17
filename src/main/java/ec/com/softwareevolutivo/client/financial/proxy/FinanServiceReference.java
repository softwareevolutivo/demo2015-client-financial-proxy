package ec.com.softwareevolutivo.client.financial.proxy;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/financial")

public interface FinanServiceReference {
	@Path("/{identification}")
	@GET
	@Produces({ "application/json" })
	@Consumes(value = MediaType.TEXT_PLAIN)
	public Map<String, Object> liabilities(
			@PathParam("identification") String identification);

}
