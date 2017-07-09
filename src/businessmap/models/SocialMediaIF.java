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
public interface SocialMediaIF {
    public int getId();
    public void setId(int id);
    
    public String getName();
    public void setName(String name);
    

    public URL getAddress();
    public void setAddress(URL address);

}