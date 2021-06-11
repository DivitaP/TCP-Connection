// Divita Phadakale 8626

// Experiment No 12
// Write a TCP client server  menu based application 



import java.io.*;
import java.net.*;
import java.util.*;

class Calculator
{
	String str;

	// Constructor
	Calculator(int a, DataInputStream in,DataOutputStream out)
	{
		try
		{
			switch(a)
			{
				case 1:	str = in.readUTF();
						String f = fact(Integer.parseInt(str));
						out.writeUTF("Factorial of " + str + " is " + f);	// writing to the client
						break;

				case 2:	str = in.readUTF();
						int b = Integer.parseInt(str);
						str = in.readUTF();
						int p = Integer.parseInt(str);
						String pow = power(b,p);
						out.writeUTF("Power is " + pow);
						break;

				case 3:	str = in.readUTF();
						String pal = isPalindrome(Integer.parseInt(str));
						out.writeUTF(pal);
						break;

				case 4:	str = in.readUTF();
						String arm = isArmstrong(Integer.parseInt(str));
						out.writeUTF(arm);
						break;

				case 5:	str = in.readUTF();
						String prime = isPrime(Integer.parseInt(str));
						out.writeUTF(prime);
						break;
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}

	}

	// Performs factorial
	String fact(int a)
	{
		int f = 1;
		for(int i=1 ; i<=a ; i++)
		{
			f *= i;
		}
		return Integer.toString(f);
	}

	// Performs power
	String power(int b,int p)
	{
		int pow = 1;
		for(int i = 0 ; i<p ; i++)
		{
			pow *= b;
		}

		return Integer.toString(pow);
	}

	// Checks if Palindrome
	String isPalindrome(int a)
	{
		int[] arr = new int[10];
		int i = -1;
		int j = 0;
		while(a>0)
		{
			arr[++i] = a%10;
			a /= 10;
		}

		while( i > j)
		{
			if( arr[i] != arr[j])
				return "It is not a Palindrome";
			i--;
			j++;
		}

		return "It is a Palindrome";
	}

	// Checks if Armstrong
	String isArmstrong(int a)
	{
		int b = a;
		int sum = 0;
		int t;
		while(b>0)
		{
			t = b%10;
			sum += Integer.parseInt(power(t,3));
			b /= 10;
		}

		if (sum == a)
			return "It is an Armstrong number";
		else
			return "It is not an Armstrong number";

	}

	// Checks if Prime no.
	String isPrime(int a)
	{
		for(int i = 2 ; i<=Math.sqrt(a) ; i++)
		{
			if (a%i == 0)
				return "It is not a Prime number";
		}

		return "It is a Prime number";
	}
}

public class Server
{
	public static void main(String[] args)
	{
		try
		{
			// Starting the server
			ServerSocket ss = new ServerSocket(1234);
			System.out.println("Server has started");

			Socket s;
			DataInputStream in;
			DataOutputStream out;
			String str;
			int l;
			while(true)
			{
				// Waiting for client
				s = ss.accept();
				System.out.println("A client has joined");

				// input stream
				in = new DataInputStream(s.getInputStream());

				// output stream
				out = new DataOutputStream(s.getOutputStream());

				try
				{
					// reading from the client
					str =in.readUTF();
					l = Integer.parseInt(str);
					Calculator obj = new Calculator(l,in,out);		// Creates a Calculator object and does the remaining calculation in there
				}
				catch(Exception e)
				{
					System.out.println("Error in Client side input !!!");
				}

				s.close();
				System.out.println("Client Left\n");
				
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}