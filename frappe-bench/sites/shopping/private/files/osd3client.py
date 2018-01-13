# Use Python for Socket Programming to connect v
# two or more PCs to share a text file.
# Developer: Manish Raj (technoslab@gmail.com)

import socket, os

print "Socket connection program"

choice = 0

def send():
  connection = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
  host = raw_input("Enter host name: ")
  port = int(raw_input("Enter port number: "))
  name = raw_input("Enter text file name to send: ")
  connection.connect((host, port))
  path = os.path.join(os.getcwd(), name)
  file = open(path, 'rb')
  data = file.read(1024)
  print "Sending file ",path ," to: ", host
  while data:
    connection.send(data)
    data = file.read(1024)
  connection.close()
  print "File sent!"

def receive():
  server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
  port = int(raw_input("Enter port number: "))
  server.bind(('172.16.4.119', port))
  server.listen(5)
  print "Waiting for file..."
  client, address = server.accept()
  print "Receiving file from: ", address[0], "\n"
  data = client.recv(1024)
  while data:
    print data
    data = client.recv(1024)
  server.close()
  print "\nFile received!"

def menu():
  print "1. Send file"
  print "2. Receive file"
  print "3. Exit"
  return int(raw_input("Enter choice: "))


while choice != 3:
  choice = menu()
  if choice == 1:
    send()
  elif choice == 2:
    receive()

