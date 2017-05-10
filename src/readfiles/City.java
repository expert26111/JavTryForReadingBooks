/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readfiles;

/**
 *
 * @author yoyo
 */
public class City 
{
    private String lat;
    private String longt;
    private String name;

//    public City(String name,double lat, double longt) {
//        this.lat = lat;
//        this.longt = longt;
//        this.name = name;
//    }

    @Override
    public String toString() {
        return "City{" + "lat=" + lat + ", longt=" + longt + ", name=" + name + '}';
    }

    
    
    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongt() {
        return longt;
    }

    public void setLongt(String longt) {
        this.longt = longt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
