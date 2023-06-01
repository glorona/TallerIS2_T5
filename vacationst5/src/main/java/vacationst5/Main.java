// Copyright (C) 2023
// All rights reserved

package vacationst5;

import Clases.*;
import java.util.*;
import java.io.IOException;
public class Main {
	
    private ArrayList<CiudadPopular> ciudadesPopulares;
	
	
    /**
     * 
     */
    public Main() {
		
        CiudadPopular paris = new CiudadPopular("Paris", 500);
        CiudadPopular newYork = new CiudadPopular("New York City", 600);
        CiudadPopular tokyo = new CiudadPopular("Tokyo", 500);
        CiudadPopular barcelona = new CiudadPopular("Barcelona", 700);
        ciudadesPopulares = new ArrayList<CiudadPopular>();
        ciudadesPopulares.add(newYork);
        ciudadesPopulares.add(paris);
        ciudadesPopulares.add(tokyo);
        ciudadesPopulares.add(barcelona);
    }
	
    /**
     * @return lista de ciudades populares
     */
    public ArrayList<CiudadPopular> getCiudadesPopulares() {
        return ciudadesPopulares;
    }
	

//CHECKSTYLE:OFF
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Main m1 = new Main();
        m1.menuPrincipal();
    }
//CHECKSTYLE:ON
	
    /**
     * 
     */
    private void menuPrincipal() {
        try{
                              
            int ingreso;
            Scanner sc = new Scanner(System.in);
            do {
                System.out.println("\n Bienvenido");
                System.out.println("Seleccione una opcion:");
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
                        System.out.println("Entrada invalida!");
                        System.out.println("Elija una de las opciones:");
				
                }
			
            } while (!(ingreso == 2));
            sc.close();
        }catch(Exception ex){
            System.out.println("Entrada invalida!");
            System.out.println("Elija una de las opciones:");
            menuPrincipal();
        }
		
    }
	
    /**
     * 
     */
    private void menuViajes() {
        int total = 0;
        System.out.println("Hola, a donde te dirijes?");
        Scanner sc = new Scanner(System.in);
        String destino = sc.nextLine();
        int personas=1; //default para el while
        try {
                
            do {
                System.out.println("Cuantas personas viajan?");
                personas = sc.nextInt();
                sc.nextLine();
            }while (personas<1);
		
            if (!validarPasajeros(personas)) {
                total = -1;
            }
                
            int duracion=1;
                
            do {
                System.out.println("Cuantos dias viajaran?");
                duracion = sc.nextInt();
                sc.nextLine();
            }while (duracion<1);
		
		
            System.out.println("Entonces, viajaras a " + destino );
            System.out.println(" con " + personas+ " personas ");
            System.out.println("durante " +duracion + " dias");
            String confirmacion = "";
            do {
                System.out.println("Desea calcular con estos datos?S/N");
                confirmacion = sc.nextLine();
            }while (!(confirmacion.equals("S") 
                		|| confirmacion.equals("N")));
		
		
            if (confirmacion.equals("S")) {
                Pedido pedido = new Pedido(destino, personas, duracion);
                isPopular(pedido, pedido.getDestination()
                		, getCiudadesPopulares());
                pedido.applyDiscount(pedido);
                System.out.println("Total por viaje es: " 
                    + pedido.getTotal());
			
			
            }else {
                menuViajes();
            }
		
        }catch (Exception ex) {
            System.out.println("Error de ingreso, "
                    + "ingresar solo numeros");
            menuViajes();
        }
		
		
		
		
    }
	
	/**
	 * @param cantidad
	 * @return es valido o no
	 */
    private boolean validarPasajeros(int cantidad) {
        if (cantidad > 80) {
            return false;
        }
        return true;
    }
	
	/**
	 * @param pedido
	 * @param destination
	 * @param ciudadesPopulares
	 */
    public static void isPopular(Pedido pedido, String destination, 
    		ArrayList<CiudadPopular> ciudadesPopulares){
        for (CiudadPopular cp:ciudadesPopulares){
            if (cp.nombre.equalsIgnoreCase(destination)){
                pedido.setTotal(pedido.getTotal()+cp.valor);
            }
        }
            
    }
    

}
