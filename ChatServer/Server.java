package Server;
import java.net.*;
import java.io.*;
import java.util.*;
public class Server
{
	public void runServer(int port) throws IOException
	{ 
		Scanner a = new Scanner(System.in);
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("Server Started!..........");
		Socket server = serverSocket.accept();
		DataInputStream IS = new DataInputStream(server.getInputStream());
		DataOutputStream OS = new DataOutputStream(server.getOutputStream());
		System.out.println("Just Connected To "+server.getRemoteSocketAddress());
		System.out.println("\t\t\t\tNOTE:ENTER LOGOUT FOR LOGGING OUT");
		try
		{
			while(true)
			{
				String s = IS.readUTF();
				System.out.println("\nClient> "+s+"\n");
				System.out.print("Server> ");
				String ar = a.nextLine();
				if(ar.equalsIgnoreCase("Logout"))
				break;
				OS.writeUTF(ar);
			}
		}catch(EOFException e)
		{
			System.out.println("\n Client Logged Out");
		}
		catch(SocketException e)
		{
			System.out.println("\n\t\t\t Socket Disconnected.");
		}
		OS.close();
		IS.close();
		serverSocket.close();
		server.close();
	} 
	public void Welcome()
	{
		char ch1=30,ch2=31,ch3=1;
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
			System.out.print("\n\t\t"+ch3+"\t\t SERVER SIDE \t\t\t "+ch3);
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
		Server s = new Server();
		s.Welcome();
		System.out.print("\nEnter Server Port No. :");
		int p = in.nextInt();
		s.runServer(p);
	}
}