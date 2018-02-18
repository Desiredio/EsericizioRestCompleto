package rest.service;

import java.text.ParseException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import dao.DAOBilancio;
import dao.DAOUtente;
import model.Bilancio;
import model.Utente;
import rest.service.model.Messaggio;

@Path("utente")
public class UtenteResource {

	@GET
	@Path("/allutenti")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUtenti() {
		List<Utente> utenti = DAOUtente.getListaUtente();
		return Response.ok(utenti).build();
	}

	@GET
	@Path("/allbilancio")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBilancio() {
		List<Bilancio> bilancio = null;
		try {
			bilancio = DAOBilancio.getListaBilancio();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok(bilancio).build();
	}

	@POST
	@Path("/messaggio")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postUtente(Messaggio messaggio) {
		messaggio.setMessaggio(messaggio.getMessaggio().toUpperCase());
		return Response.status(Status.OK).entity(messaggio).build();
	}

	@DELETE
	@Path("/person/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePerson(@PathParam("id") int id) {

		try {

			DAOUtente.cancUtente(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(200).entity("Completato").build();
	}

	@POST
	@Path("/insert/{nome}/{cognome}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertUtente(@PathParam("nome") String nome, @PathParam("cognome") String cognome) {
		try {

			DAOUtente.insUtente(nome, cognome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(200).entity("Inserimento Utente avvenuto con successo").build();

	}

	@PUT
	@Path("/modifica/{id}/{nome}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response putUtente(@PathParam("id") int id, @PathParam("nome") String nome) {
		try {
			DAOUtente.putUtente(id, nome);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Response.status(Status.OK).entity("Put ESEGUITO").build();
	}

}
