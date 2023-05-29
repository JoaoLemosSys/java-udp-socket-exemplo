import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();

        InetAddress address = InetAddress.getByName("localhost");

        byte[] mensagemEnviar = "Esta é uma mensagem do cliente.".getBytes();

        DatagramPacket packetEnviar = new DatagramPacket(mensagemEnviar, mensagemEnviar.length, address, 10009);

        socket.send(packetEnviar);        
        
        
        byte[] mensagemReceber = new byte[1024];        
        DatagramPacket packetReceber = new DatagramPacket(mensagemReceber, mensagemReceber.length);
        socket.receive(packetReceber);
        
        String recebido = new String(packetReceber.getData(), 0, packetReceber.getLength());

        System.out.println("Resposta do Servidor: " + recebido);
        
        socket.close();
    }
}
