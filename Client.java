// Divita Phadakale 8626

// Experiment No 12
// Write a TCP client server  menu based application 


import java.io.*;
import java.net.*;
import java.util.*;

public class Client
{
	public static void main(String[] args) throws Exception
	{
		// creating a client an connecting to server
		// i.e. creating a socket
		Socket s = new Socket("127.0.0.1", 1234);

		// output stream
		DataOutputStream out = new DataOutputStream(s.getOutputStream());

		// input stream
		DataInputStream in = in = new DataInputStream(s.getInputStream());
		

		int opt;
		String a;
		String dump;
		Scanner sc = new Scanner(System.in);

		System.out.println("Client has started");
		
		System.out.println("1: Factorial");
		System.out.println("2: Power");
		System.out.println("3: Check Palindrome");
		System.out.println("4: Check Armstrong");
		System.out.println("5: Check Prime");
		System.out.println("Which operation do you have to perform: ");
		opt = sc.nextInt();
		dump = sc.nextLine();

		switch(opt)
		{
			case 1:	System.out.println("Enter the number");
					a = sc.nextLine();
					out.writeUTF("1");	// writing to server
					out.writeUTF(a);
					break;

			case 2:	System.out.println("Enter the base");
					String b = sc.nextLine();
					System.out.println("Enter the power");
					String p = sc.nextLine();
					out.writeUTF("2");
					out.writeUTF(b);
					out.writeUTF(p);
					break;

			case 3:	System.out.println("Enter the number");
					a = sc.nextLine();
					out.writeUTF("3");
					out.writeUTF(a);
					break;

			case 4:	System.out.println("Enter the number");
					a = sc.nextLine();
					out.writeUTF("4");
					out.writeUTF(a);
					break;

			case 5:	System.out.println("Enter the number");
					a = sc.nextLine();
					out.writeUTF("5");
					out.writeUTF(a);
					break;

			default:	System.out.println("Your input is invalid!!");
						in.close();
						out.close();
						s.close();
						return;
		}


		a = in.readUTF();		// reading answers from server
		System.out.println(a);

		// closing all connections
		in.close();
		out.close();
		s.close();

		 
	}
}
