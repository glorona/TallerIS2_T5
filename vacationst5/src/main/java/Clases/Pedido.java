// Copyright (C) 2023
// All rights reserved

package Clases;

public class Pedido {
    private int numTravelers;
    private String destination;
    private int vacDays;
    private double total=1000;
    
    /**
     * @param destino
     * @param numtravelers
     * @param vacdays
     */
    public Pedido(String destino, int numtravelers, int vacdays) {
    	this.numTravelers = numtravelers;
    	this.destination = destino;
    	this.vacDays = vacdays;
    	this.total = 1000;
    }

    /**
     * @return numero viajeros
     */
    public int getNumTravelers() {
        return numTravelers;
    }

    /**
     * @return destino viaje
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @return dias de vacaciones
     */
    public int getVacDays() {
        return vacDays;
    }

    /**
     * @param numTravelers
     */
    public void setNumTravelers(int numTravelers) {
        this.numTravelers = numTravelers;
    }

    /**
     * @param destination
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @param vacDays
     */
    public void setVacDays(int vacDays) {
        this.vacDays = vacDays;
    }

    /**
     * @param total
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    /**
     * @return valor total
     */
    public double getTotal() {
    	return this.total;
    }
    
    /**
     * @param p
     */
    public void applyDiscount(Pedido p){
        if (numTravelers>4 && numTravelers<10){
            total =total-(total*0.1);
        }else if (numTravelers>20){
            total=total-(total*0.2);
        }else if (vacDays<7){
            total=total-200;
        }else if (vacDays>30 || numTravelers==2){
            total=total-200;
        }
        
    }
    
    public void applyPackage(int option) {
    	switch(option) {
    		case 1:
    			total=total+(numTravelers*200);
    			break;
    		case 2:
    			total=total+(numTravelers*150);
    			break;
    		case 3:
    			total=total+(numTravelers*100);
    			break;
    	
    	}
    }

}
