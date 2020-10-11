package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Address;
import model.AddressList;

public class AddressListHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AddressBookWebUser");

	public void insertAddressList(AddressList myAddressList) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(myAddressList);
		em.getTransaction().commit();
		em.close();
	}

	public List<AddressList> showAllAddressLists() {
		EntityManager em = emfactory.createEntityManager();
		List<AddressList> allAddressList = em.createQuery("SELECT s FROM AddressList s").getResultList();
		return allAddressList;
		}
	

	public List<AddressList> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<AddressList> allDetails = em.createQuery("SELECT d FROM AddressList d").getResultList();
		return allDetails;
	}

	public void deleteItem(AddressList toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		System.out.println("Delete:"+toDelete.toString());
		TypedQuery<AddressList> typedQuery = em
				.createQuery("select d from AddressList d where d.listId = :selectedId", AddressList.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getListId());
		// we only want one result
		typedQuery.setMaxResults(1);
		// get the result and save it into a new list item
		AddressList result = typedQuery.getSingleResult();
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public AddressList searchForItemById(int idToEdit)	{
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		AddressList found	=	em.find(AddressList.class,idToEdit);
		em.close();
		return	found;
	}

	public void updateList(AddressList toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
