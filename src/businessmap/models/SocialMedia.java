/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessmap.models;

import java.net.URL;

/**
 *
 * @author erode
 */

public class SocialMedia implements SocialMediaIF{
   
    private int id;
    private String name;
    private URL address;
    
     public SocialMedia()
    {
        
    }

    
    public SocialMedia(String aName, URL aURL)
    {
        this.name = aName;
        this.address = aURL;
    }
    
        public SocialMedia(String aName, URL aURL, int anId)
    {
        this.name = aName;
        this.address = aURL;
        this.id = anId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URL getAddress() {
        return address;
    }

    public void setAddress(URL address) {
        this.address = address;
    }
        
}
