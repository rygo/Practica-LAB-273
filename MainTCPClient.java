/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpcliente;

/**
 *
 * @author guery
 * 
 */
/*
*Nombre: Guery Castaño Apaza
*Docente: Roberto Vargas Blacutt
*/
public class MainTCPClient {

	public static void main(String[] args) {
		TCPClient C = new TCPClient("127.0.0.1", 8888);
		C.iniciar();
	}

}
