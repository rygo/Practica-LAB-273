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
public class MainTCPServer {

	public static void main(String[] args) {
		TCPServer Server = new TCPServer(8888);
		Server.iniciar();
	}

}
