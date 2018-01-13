 import java.rmi.*;
import java.io.*;


public class Client
{
public static void main(String args[])
  {
 try
  {
 String ip="rmi://localhost/RMIAPPLICATION";
 RemoteInterface s=
   (RemoteInterface)Naming.lookup(ip);
 System.out.println("sum: "+ s.add(15,8));
  }
 catch(Exception e)
  {
  System.out.println(e.getMessage());
  e.printStackTrace();
  }
  }
}