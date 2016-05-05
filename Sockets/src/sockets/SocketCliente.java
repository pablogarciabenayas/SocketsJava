package sockets;



import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketCliente {

    public static void main(String[] args) throws UnknownHostException, IOException {
        /*         
         // Leemos la frase desde la consola
         System.out.print("Texto a enviar:    ");
         BufferedReader consolaIn = new BufferedReader(new InputStreamReader(System.in));
         String frase = consolaIn.readLine();
         System.out.print("Formato (MAY/MIN): ");
         String cabecera = consolaIn.readLine();
        
         // Creamos un Socket en el cliente para conectarse al servidor
         String hostName = InetAddress.getLocalHost().getHostName();
         int    puerto   = 8000;
         Socket socket   = new Socket(hostName,puerto);
        
         // Creamos los streams para la lectura y escritura de objetos a traves de la conexion
         DataOutputStream streamOut = new DataOutputStream(socket.getOutputStream());
         BufferedReader   streamIn  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
       
         // Enviamos la frase al servidor
         String mensaje = cabecera + ";" + frase;
         streamOut.writeBytes(mensaje + '\n');
         streamOut.flush();
        
         // Recogemos la frase modificada y la mostramos por consola
         String fraseModificada = streamIn.readLine();
         System.out.println("Recibido:          " + fraseModificada);
         */

        // Creamos un Socket en el cliente para conectarse al servidor
        String hostName = InetAddress.getLocalHost().getHostName();
        int puerto = 8000;
        Socket socket = new Socket(hostName, puerto);

        // Creamos los streams para la lectura y escritura de objetos a traves de la conexion
        DataOutputStream streamOut = new DataOutputStream(socket.getOutputStream());
        BufferedReader streamIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader consolaIn;
        String mensaje;
            //mensaje de teclado
        char c = 0;
        for (int i = 0; i < 10; i++) {
            mensaje = "Cliente dice: "+ i +'\n';
            System.out.println(mensaje);
            streamOut.writeBytes(mensaje);
            streamOut.flush();

            String echo;
            echo = streamIn.readLine();
            
            System.out.println("echo "+ echo);

        }

        //Cerramos la conexion
        streamIn.close();
        streamOut.close();
        socket.close();

    }

}
