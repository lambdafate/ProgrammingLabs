import socket
import sys

HOST = "39.107.83.159"
PORT = 8888

if len(sys.argv) > 1:
    HOST = sys.argv[1]
if len(sys.argv) > 2:
    PORT = int(sys.argv[2])

with socket.create_connection((HOST, PORT)) as client:
    client.send("Hello, fuck!\n".encode("utf8"))
    print(client.recv(1024).decode())
    