/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpservidor;

/**
 *
 * @author guery
 */
/*
*Nombre: Guery Castaño Apaza
*Docente: Roberto Vargas Blacutt
*/
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {
	
	ServerSocket sServidor;
	Socket sCliente;
	int puerto;
	PrintStream salida;
	Scanner entrada;
	String mensajeSolicitud = "";
	String mensajeRespuesta = "";
        
	//Se crea la funcion para verificar si es primo 
	public String EsPrimo(int num)
	{
            
            int cont=0,i;
            String cad="";
      //verificando  las diviciones del numero n 
         for(i=1;i<(num+1);i++){
             //cantidad del mod = 0 
         if(num%i==0){
             cont++;
            }
         }
         // si el contador es distinto de 2 " indica que no es primo"
         // y si rl con es = 2 " indica que el numero es  primo"
         if(cont!=2){
              cad = "El numero " +num+" NO ES PRIMO...";
                        
            }else{
                cad = "El numero "+num +" ES PRIMO...";
         }
         
         //retornamos  la cadena del numero determinando si es primo o no
         return cad;
         
	}

	
	public TCPServer(int p)
	{
		puerto = p;
	}
	public void iniciar()
	{
		try {//se inicia nuestro servidor
			sServidor = new ServerSocket(puerto);
			System.out.println("-        SERVIDOR TCP INICIADO         -");
			System.out.println("- Esperando la Coneccion de un Cliente -");
                        //se esperan las peticiones del cliente
			while(true){
				//El servidor es aceptado la conexion con un cliente
				sCliente = sServidor.accept();				
				entrada = new Scanner(sCliente.getInputStream());
				salida = new PrintStream(sCliente.getOutputStream());
                                
				//capturamos el mensaje del cliente recibido
				mensajeSolicitud = entrada.nextLine();
				System.out.println("NUMERO PARA VERIFICAR :"+mensajeSolicitud);
				//con este if validaremos si el mensaje es un espacio (" ") el
				//servidor se desconecta y si es un numero verificara si es primo o no
				if (mensajeSolicitud.equals(" "))
				{
					//enviamos el mensaje de desconexion y desconectamos el servidor con la palabra reservada return
					//el cual saldra del while infinito y se ejecutara la funcion finally
					mensajeRespuesta = "El servidor se ha desconectado";
					salida.println(mensajeRespuesta);
					return;
				}
				else
				{
					mensajeRespuesta = EsPrimo(Integer.parseInt(mensajeSolicitud));
                                        //envia el mensaje solicitado
					salida.println(mensajeRespuesta);
				}

			}
			
		} catch (Exception e) {
			e.printStackTrace();
			finalizar();
		}
		finally{
			finalizar();
		}
	}
	public void finalizar()
	{
		try {
                    // Finalizando los flujos y el socket
			salida.close();
			entrada.close();
			sServidor.close();
			sCliente.close();
			System.out.println("Conexion Finalizada...");
		} catch (Exception e) {
                    // Imprimir error
			e.printStackTrace();
		}
	}
	
}
