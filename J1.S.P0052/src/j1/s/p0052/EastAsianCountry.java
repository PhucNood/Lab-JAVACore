/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0052;

/**
 *
 * @author ACER
 */
public class EastAsianCountry extends Country{
    private String countryTerrain;

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }
    
    public EastAsianCountry( String countryCode, String countryName, float totalArea,String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }
    
    @Override
    public void display() {
        System.out.printf("%-10s%-25s%-19.0f%-24s\n", getCountryCode(),
                getCountryName(), getTotalArea(), this.countryTerrain);
    }
    
}
