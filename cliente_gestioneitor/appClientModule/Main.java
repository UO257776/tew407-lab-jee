import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.json.simple.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://datos.gijon.es/doc/transporte/busgijontr.json");
		String result = target.request().get().readEntity(String.class);
		System.out.println(result);

	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}
	
}