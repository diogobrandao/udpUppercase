package org.academiadecodigo.bootcamp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) {

        String hostName;
        int port;
        String message;
        DatagramSocket socket = null;


        byte[] sendBuffer; //= new byte[1024];
        byte[] recvBuffer = new byte[1024];


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Hostname: ");
        hostName = scanner.next();

        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Enter port: ");
        port = scanner1.nextInt();

        Scanner scanner2 = new Scanner(System.in);
        System.out.print("MESSAGE: ");
        message = scanner2.next();


        try {
            socket = new DatagramSocket();//port number will be random
            sendBuffer = message.getBytes();
            DatagramPacket sendPacket = null;
            try {
                sendPacket = new DatagramPacket(sendBuffer,
                        sendBuffer.length, InetAddress.getByName(hostName), port);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            try {
                socket.send(sendPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }

            DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);
            try {
                socket.receive(receivePacket);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String messageReceived = null;
            try {
                messageReceived = new String(receivePacket.getData(), "UTF-8").trim();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            System.out.println(messageReceived);
        } catch (SocketException e) {


        }
        DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);


    }

}
