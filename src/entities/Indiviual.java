/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ut2u
 */
public class Indiviual extends TaxPayer{
    
    private Double healtExpenditures;

    public Indiviual() {
        super();
    }

    public Indiviual(String name, Double anualIncome, Double healtExpenditures) {
        super(name, anualIncome);
        this.healtExpenditures = healtExpenditures;
    }

    public Double getHealtExpenditures() {
        return healtExpenditures;
    }

    public void setHealtExpenditures(Double healtExpenditures) {
        this.healtExpenditures = healtExpenditures;
    }
    
    @Override
    public double tax() {
        if(getAnualIncome() < 20000.0){
            return ((getAnualIncome() * 0.15) - (getHealtExpenditures() * 0.50));
        }
        else{
            return ((getAnualIncome() * 0.25) - (getHealtExpenditures() * 0.50));
        }
    }    
}
