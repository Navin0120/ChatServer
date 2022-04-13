package Client;
import java.net.*;
import java.io.*;
import java.util.*;
public class Client
{
	public void runClient(int port) throws IOException
	{ 
		Scanner a = new Scanner(System.in);
		Socket client = new Socket("localhost",port);
		DataInputStream IS = new DataInputStream(client.getInputStream());
		DataOutputStream OS = new DataOutputStream(client.getOutputStream());
		System.out.println("Just Connected To "+client.getRemoteSocketAddress());
		System.out.println("\t\t\t\tNOTE:ENTER LOGOUT FOR LOGGING OUT");
		System.out.println();
		try
		{
			while(true)
			{
				System.out.print("Client> ");
				String ar = a.nextLine();
				if(ar.equalsIgnoreCase("Logout"))
				break;
				OS.writeUTF(ar);
				String s = IS.readUTF();
				System.out.println("\nServer> "+s+"\n");
			}
		}catch(EOFException e)
		{
			System.out.println("\n Server Logged Out");
		}
		catch(SocketException e)
		{
			System.out.println("\n\t\t\t Socket Disconnected.");
		}
		
		OS.close();
		IS.close();
		client.close();
	} 
	public void Welcome()
	{
		char ch1=30,ch2=31,ch3=2;
		for(int i=0;i<40;i++)
		{
			System.out.print(ch1);
			System.out.print(ch2);
		}
			System.out.println("\n\t\t\t\t CHAT SERVER \n");
		for(int i=0;i<40;i++)
		{
			System.out.print(ch1);
			System.out.print(ch2);
		}
			System.out.print("\n\t\t");
		for(int i=0;i<50;i++)
		{
			System.out.print(ch3);
		}
			System.out.print("\n\t\t"+ch3+"\t\t\t\t\t\t "+ch3);
			System.out.print("\n\t\t"+ch3+"\t\t CLIENT SIDE \t\t\t "+ch3);
			System.out.print("\n\t\t"+ch3+"\t\t\t\t\t\t "+ch3);
			System.out.print("\n\t\t");
		for(int i=0;i<50;i++)
		{
			System.out.print(ch3);
		}
	}
	public static void main(String ...h) throws IOException
	{
		Scanner in = new Scanner(System.in);
		Client c = new Client();
		c.Welcome();
		System.out.print("\nEnter Port No. You Want To Connect To :");
		int p = in.nextInt();
		c.runClient(p);
	}
}