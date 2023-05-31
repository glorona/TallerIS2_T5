package vacationst5;

import Clases.*;
import java.util.*;
import java.io.IOException;
public class Main {
	
	private ArrayList<CiudadPopular> ciudadesPopulares;
	
	
	public Main() {
		CiudadPopular Paris = new CiudadPopular("Paris",500);
	    CiudadPopular NY = new CiudadPopular("New York City",600);
	    CiudadPopular Tokyo = new CiudadPopular("Tokyo",500);
	    CiudadPopular Barcelona = new CiudadPopular("Barcelona",700);
	    ciudadesPopulares = new ArrayList<CiudadPopular>();
	    ciudadesPopulares.add(NY);
	    ciudadesPopulares.add(Paris);
	    ciudadesPopulares.add(Tokyo);
	    ciudadesPopulares.add(Barcelona);
	}
	
	public ArrayList<CiudadPopular> getCiudadesPopulares() {
		return ciudadesPopulares;
	}
	

	
	public static void main(String[] args) {
        Main m1 = new Main();
        m1.menuPrincipal();
    }
	
	private void menuPrincipal() {
		
		int ingreso;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n Bienvenido, seleccione una opcion:");
			System.out.println("1. Seleccionar paquete de vacaciones");
			System.out.println("2. Salir");
			ingreso = sc.nextInt();
			sc.nextLine();
			switch(ingreso) {
			case 1:
				menuViajes();
				break;
			case 2:
				break;
			default:
				System.out.println("Entrada invalida, selecciona una de las opciones!");
				
			}
			
		} while (!(ingreso == 2));
		sc.close();
		
		
	}
	
	private void menuViajes() {
		int total = 0;
		System.out.println("Hola, a donde te dirijes?");
		Scanner sc = new Scanner(System.in);
		String destino = sc.nextLine();
		
		System.out.println("Cuantas personas viajan?");
		try{
			int personas = sc.nextInt();
		
		
		if (!validarPasajeros(personas)) {
			total = -1;
		}
		sc.nextLine();
		System.out.println("Cuantos dias viajaran?");
		int duracion = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Entonces, viajaras a " + destino + " con " + personas+ " personas " + " durante " + duracion + " dias");
		String confirmacion = "";
		do {
		System.out.println("Desea calcular con estos datos?S/N");
		
		confirmacion = sc.nextLine();
		}while (!(confirmacion.equals("S") || confirmacion.equals("N")));
		
		
		if(confirmacion.equals("S")) {
			Pedido p = new Pedido(destino,personas,duracion);
			isPopular(p,p.getDestination(),getCiudadesPopulares());
			p.applyDiscount(p);
			System.out.println("Total por viaje es: " + p.getTotal());
			
			
			
		}
		else {
			menuViajes();
		}
		
		}
		catch(Exception ex) {
			System.out.println("Error de ingreso, por favor ingresa solo numeros");
			menuViajes();
		}
		
		
		
		
	}
	
	private boolean validarPasajeros(int cantidad) {
		if(cantidad > 80) {
			return false;
		}
		return true;
	}
	
	public static void isPopular(Pedido pedido,String destination, ArrayList<CiudadPopular> ciudadesPopulares){
        for(CiudadPopular cp:ciudadesPopulares){
            if(cp.nombre.equalsIgnoreCase(destination)){
                pedido.setTotal(pedido.getTotal()+cp.valor);
            }
        }
            
    }
    

}
