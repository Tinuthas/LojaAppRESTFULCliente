import javax.swing.JOptionPane;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MainGetId {

	public static void main(String[] args) {
		Client client = Client.create();
		int id = Integer.parseInt(JOptionPane.showInputDialog("Pesquisar Id"));
		WebResource resource = client.resource("http://localhost:8080/LojaApp/rest/produto/"+id);
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if (response.getStatus() == 200) {
			ProdutoTO produto = response.getEntity(ProdutoTO.class);
			System.out.println(produto.getTitulo());
		} else {
			System.out.println("Erro - HTTP Status: " + response.getStatus());
		}

	}

}
