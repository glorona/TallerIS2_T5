// Copyright (C) 2023
// All rights reserved

package vacationst5;

import Clases.*;
import java.util.*;
public class Main {
	
    private ArrayList<String> packages;
    private Map<String,Integer> ciudadesPopulares = new HashMap<>();
	
	
    /**
     * 
     */
    public Main() {
		
        ciudadesPopulares.put("Paris", 500);
        ciudadesPopulares.put("New York City", 600);
        ciudadesPopulares.put("Tokyo", 500);
        ciudadesPopulares.put("Barcelona", 700);
        
        packages = new ArrayList<>();
        packages.add("All Inclusive Package");
        packages.add("Adventure Activities Package");
        packages.add("Spa and Wellness Package");
        
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
        }catch(InputMismatchException ex){
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
        int paquete=0;
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

            String confirmapaquetes = "";
            do {
            	System.out.println("Deseas agregar paquetes de viaje?S/N");
            	confirmapaquetes = sc.nextLine();
            }while (!(confirmapaquetes.equals("S") 
                		|| confirmapaquetes.equals("N")));
       
            if(confirmapaquetes.equals("S")) {
                System.out.println("1. All Inclusive Package - $200");
                System.out.println("2. Adventure Activities Package - $150");
                System.out.println("3. Spa and Wellness Package - $100");
                do {
                    System.out.println("Seleccione una opcion:");
                    paquete = sc.nextInt();
                    sc.nextLine();
                    
                }while (paquete<1 && paquete>3);
            	
            }
            
            System.out.println("Entonces, viajaras a " + destino );
            System.out.println(" con " + personas+ " personas ");
            System.out.println("durante " +duracion + " dias");
            if (paquete != 0) {
            System.out.println("Y ha seleccionado el paquete " + packages.get(paquete-1));
            }
            String confirmacion = "";
            do {
                System.out.println("Desea calcular con estos datos?S/N");
                confirmacion = sc.nextLine();
            }while (!(confirmacion.equals("S") 
                		|| confirmacion.equals("N")));
		
		
            if (confirmacion.equals("S")) {
            	if(total >= 0) {
            		Pedido pedido = new Pedido(destino, personas, duracion);
                    if(paquete != 0) {
                    	pedido.applyPackage(paquete);
                    }
                    isPopular(pedido, pedido.getDestination()
                    		, ciudadesPopulares);
                    pedido.applyDiscount(pedido);
                    System.out.println("Total por viaje es: " 
                        + pedido.getTotal());
            	}
            	else {
            		System.out.println("Total por viaje es: " 
                            + total);
            	}
			
			
            }else {
                menuViajes();
            }
		
        }catch (InputMismatchException ex) {
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
        return (cantidad < 80);

    }
	
	/**
	 * @param pedido
	 * @param destination
	 * @param ciudadesPopulares
	 */
    public static void isPopular(Pedido pedido, String destination, 
    		Map<String,Integer> ciudadesPopulares){
        for (String cp:ciudadesPopulares.keySet()){
            if (cp.equalsIgnoreCase(destination)){
                pedido.setTotal(pedido.getTotal()+ciudadesPopulares.get(cp));
            }
        }
            
    }
    

}
