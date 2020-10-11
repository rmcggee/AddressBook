import model.AddressList;

import java.util.List;

import controller.AddressListHelper;
import model.Address;
import controller.AddressHelper;

public class AddressListTester {

	public static void main(String[] args) {
	
		//List<AddressList> allAddressList = alh.showAllAddressLists();

		AddressHelper ah = new AddressHelper();
		Address steveadd1 = ah.searchForItemById(25);
		ah.deleteItem(steveadd1);
		// TODO Auto-generat
		AddressListHelper alh = new AddressListHelper();
		AddressList myAddressList = alh.searchForItemById(22);
		alh.deleteItem(myAddressList);
		
		List<Address> allLists = ah.getLists();

			for (Address a : allLists) {
				System.out.println(a.toString());
			}
	
		


	}

}
