package org.academiadecodigo.bootcamp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {

    public static void main(String[] args) {

                byte[] recvBuffer = new byte[1024];
                byte[] sendBuffer;
                int portNumber = 5000;

                try {

                        DatagramSocket socket = new DatagramSocket(portNumber);
                        DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);

                        socket.receive(receivePacket);
                        String messageReceived = new String(receivePacket.getData());
                        InetAddress ipAddrressSender = receivePacket.getAddress();

                        while(true) {
                        int port = receivePacket.getPort();

                        String messageUpperCase = messageReceived.toUpperCase();

                        sendBuffer = messageUpperCase.getBytes();
                        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, ipAddrressSender, port);
                        socket.send(sendPacket);
                    }

                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }



