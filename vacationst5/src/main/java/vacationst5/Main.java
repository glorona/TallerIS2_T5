package vacationst5;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
        System.out.println("Hello World!");
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
		
		int personas = sc.nextInt();
		if (!validarPasajeros(personas)) {
			total = -1;
		}
		sc.nextLine();
		System.out.println("Cuanto tiempo viajaran?");
		int duracion = sc.nextInt();
		sc.nextLine();
		
		
		
		
	}
	
	private boolean validarPasajeros(int cantidad) {
		if(cantidad > 80) {
			return false;
		}
		return true;
	}
    

}
