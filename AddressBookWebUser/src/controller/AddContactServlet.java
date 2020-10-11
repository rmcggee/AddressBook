package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;
import model.AddressList;

/**
 * Servlet implementation class AddContactServlet
 */
@WebServlet("/addContactServlet")
public class AddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String myFirstName = request.getParameter("fName");
		String myLastName = request.getParameter("lName");
		AddressList myAddressList = new AddressList(myFirstName, myLastName);
		AddressListHelper alh = new AddressListHelper();
		alh.insertAddressList(myAddressList);
		//List<AddressList> allAddressList = alh.showAllAddressLists();
		String myAddressLine1 = request.getParameter("addressLine1");
		String myAddressLine2 = request.getParameter("addressLine2");
		String myAddressLine3 = request.getParameter("addressLine3");
		String myCity = request.getParameter("city");
		String myState = request.getParameter("state");
		String myPostal = request.getParameter("postal");
		AddressHelper ah = new AddressHelper();
		Address myContact = new Address(myAddressLine1, myAddressLine2, myAddressLine3, myCity, myState, myPostal, myAddressList);
		ah.insertAddress(myContact);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
