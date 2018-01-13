 import java.rmi.*;
import java.rmi.server.*;
import java.lang.String;



public class ServerImplements extends 
 UnicastRemoteObject implements RemoteInterface
  {
  public ServerImplements()throws Exception
  {
  super();
  }
  public int add(int x,int y)
  {
System.out.println("Numbers from client are " + x +" and " + y);
  return (x+y);
  }
}