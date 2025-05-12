package de.thi.winfo.components.client;

import de.thi.winfo.components.bean.Customer;
import de.thi.winfo.components.ejb.DiscountBeanRemote;
import de.thi.winfo.components.ejb.SearchCustomerBeanRemote;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Main {
	public static void main(String[] args) throws NamingException {
		// Properties props = new Properties();
		
		// Salvanos, S. 929
		// Folgende drei Properties benötigt die JNDI-API, wenn sie die Verbindung zum GlassFish-Server aufbauen soll
		// props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
		// props.setProperty(Context.URL_PKG_PREFIXES, "com.sun.enterprise.naming");
		// props.setProperty(Context.STATE_FACTORIES, "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
		
		// Verbindungsinformationen zu dem Server, auf dem die Session-Bean liegt
		// Port gibt die Nummer an, an der der RMI-IIOP-Dienst lauscht
		// props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
		// props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
		
		// Context context = new InitialContext(props);
		
		// JNDI-Properties ausgelagert in Properties-File jndi.properties
		// --> dadurch Default-Konstruktor für Context nehmen
		System.out.print("Initializing Context...");
		Context context = new InitialContext();	// liest die Parameter aus File jndi.properties
		System.out.println("done!");
		
		System.out.print("Finding discountBean...");
		DiscountBeanRemote discountBean = (DiscountBeanRemote)context.lookup(
											"java:global"
											+ "/"
											+ "AT4UA-EJB-EAR"							// EAR-Datei
											+ "/"
											+ "AT4UA-EJB"								// EJB-Modul
											+ "/"
											+ "DiscountBean"							// SessionBean
											+ "!"
											+ "edu.thi.at4ua.ejb.DiscountBeanRemote");	// Business-Interface
		System.out.println("done!");
		System.out.println("Discount für 101.000€: " + discountBean.calculateDiscount("4711", new Float(101000)));
		
		System.out.print("Finding searchCustomerBean...");
		SearchCustomerBeanRemote searchCustomerBean = (SearchCustomerBeanRemote)context.lookup(
											"java:global"
											+ "/"
											+ "AT4UA-EJB-EAR"									// EAR-Datei
											+ "/"
											+ "AT4UA-EJB"										// EJB-Modul
											+ "/"
											+ "SearchCustomerBean"								// SessionBean
											+ "!"
											+ "edu.thi.at4ua.ejb.SearchCustomerBeanRemote");	// Business-Interface
		System.out.println("done!");
		List<Customer> custList = searchCustomerBean.searchCustomers("demo.org");
		for (Customer customer : custList) {
			System.out.println(customer.getId());
			System.out.println(customer.getEmail());
			System.out.println(customer.getPassword());
		}
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}