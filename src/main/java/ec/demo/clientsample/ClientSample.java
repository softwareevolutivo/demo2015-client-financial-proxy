package ec.demo.clientsample;

import java.util.Map;

import ec.demo.*;

public class ClientSample {

	public static void main(String[] args) {
	        System.out.println("***********************");
	        System.out.println("Create Web Service Client...");
	        FinancialService service1 = new FinancialService();
	        System.out.println("Create Web Service...");
	        FinancialServicePortType port1 = service1.getFinancialServicePort();
	        System.out.println("Call Web Service Operation...");
	        ec.demo.LiabilitiesResponse.Map liabilities = port1.liabilities("1715303004");
	        System.out.println("Server said: " + liabilities);
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Create Web Service...");
	        FinancialServicePortType port2 = service1.getFinancialServicePort();
	        System.out.println("Call Web Service Operation...");
	        System.out.println("Server said: " + port2.liabilities("1715303001"));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("***********************");
	        System.out.println("Call Over!");
	}
}
