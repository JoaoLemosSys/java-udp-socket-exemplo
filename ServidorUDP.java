import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorUDP {
    public static void main(String[] args) throws IOException {
        
        DatagramSocket socket = new DatagramSocket(10009);
        byte[] mensagem = new byte[1024];
        DatagramPacket packet = new DatagramPacket(mensagem, mensagem.length);
        socket.receive(packet);

        String recebido = new String(packet.getData(), 0, packet.getLength());                
        System.out.println("Recebido:" + recebido);    
        mensagem = "Esta é a resposta do servidor para o cliente!".getBytes();    
            
        InetAddress address = packet.getAddress();

        int porta = packet.getPort();
        packet = new DatagramPacket(mensagem, mensagem.length, address, porta);
        
        socket.send(packet);
        socket.close();
    }
}