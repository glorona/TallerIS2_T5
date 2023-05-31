package Clases;

public class Pedido {
	private int numTravelers;
    private String destination;
    private int vacDays;
    private double total=1000;

    public int getNumTravelers() {
        return numTravelers;
    }

    public String getDestination() {
        return destination;
    }

    public int getVacDays() {
        return vacDays;
    }

    public void setNumTravelers(int numTravelers) {
        this.numTravelers = numTravelers;
    }

    public void setDestination(pais destination) {
        this.destination = destination;
    }

    public void setVacDays(int vacDays) {
        this.vacDays = vacDays;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public double getTotal() {
    	return this.total;
    }
    
    public void applyDiscount(Pedido p){
        if (numTravelers>4 && numTravelers<10){
            total =total-(total*0.1);
        }else if(numTravelers>20){
            total=total-(total*0.2);
        }else if(vacDays<7){
            total=total-200;
        }else if(vacDays>30 || numTravelers==2){
            total=total-200;
        }
        
    }

}
