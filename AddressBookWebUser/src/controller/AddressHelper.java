package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Address;

public class AddressHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AddressBookWebUser");

	public void insertAddress(Address myAddress) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(myAddress);
		em.getTransaction().commit();
		em.close();
	}

	public List<Address> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<Address> allAddressess = em.createQuery("SELECT d FROM Address d").getResultList();
		return allAddressess;
	}

	public Address searchForItemById(int idToEdit)	{
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		Address found	=	em.find(Address.class,idToEdit);
		em.close();
		return	found;
	}
	
	public	void	deleteItem(Address	toDelete)	{
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		System.out.println("Delete:"+toDelete.toString());
		TypedQuery<Address> typedQuery	= em.createQuery("select li	from Address li where li.addressId = :selectedAddressId",	Address.class);
		//Substitute	parameter	with	actual	data	from	the	toDelete	item
		typedQuery.setParameter("selectedAddressId",	toDelete.getAddressId());
		//we	only	want	one	result
		typedQuery.setMaxResults(1);
		//get	the	result	and	save	it	into	a	new	list	item
		Address	result	=	typedQuery.getSingleResult();
		//remove	it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}
	
	


}
