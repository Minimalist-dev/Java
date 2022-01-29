package javafx.l;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author neury-dev
 */
public class Identidad {
    public static String 
    pc() {
        String pcObject = null;
        try {
            pcObject = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Identidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pcObject;
    }
    public static String 
    usuario() {
        String usuarioObject = System.getProperty("user.name");
        return usuarioObject; 
    }
    public static String 
    ipLocal() {
        String ipLocalObject = null;
        try {
            ipLocalObject = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Identidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ipLocalObject; 
    }
    public static String 
    idioma() {
        Locale idiomaLocaleObject = Locale.getDefault();
        String idiomaObject = idiomaLocaleObject.toString();
        return idiomaObject;
    }
    public static String
    origen() {
        String origenObject = Locale.getDefault().getDisplayCountry();
        return origenObject;
    }
    public static String 
    ipv4(){ 
        String ipv4Object = null; 
        Enumeration<NetworkInterface> networkInterfaceObject = null; 
        
        try { 
            networkInterfaceObject = NetworkInterface.getNetworkInterfaces(); 
        } catch (SocketException exObject) { 
            throw new RuntimeException(exObject); 
        } 
        
        while(networkInterfaceObject.hasMoreElements()){ 
            NetworkInterface elementObject = networkInterfaceObject.nextElement(); 
            Enumeration<InetAddress> InetAddressObject = elementObject.getInetAddresses(); 
            
            while (InetAddressObject.hasMoreElements()){ 
                InetAddress ipObject = InetAddressObject.nextElement(); 
                if (ipObject instanceof Inet4Address){ 
                    if (ipObject.isSiteLocalAddress()){ 
                        ipv4Object = ipObject.getHostAddress(); 
                    } 
                } 
            } 
        } 
        return ipv4Object; 
    }
    public static String 
    ipv6(){ 
        String ipv6Object = null; 
        Enumeration<NetworkInterface> networkInterfaceObject = null; 
        
        try { 
            networkInterfaceObject = NetworkInterface.getNetworkInterfaces(); 
        } catch (SocketException exObject) { 
            throw new RuntimeException(exObject); 
        } 
        
        while(networkInterfaceObject.hasMoreElements()){ 
            NetworkInterface elementObject = networkInterfaceObject.nextElement(); 
            Enumeration<InetAddress> inetAddressObject = elementObject.getInetAddresses(); 
            
            while (inetAddressObject.hasMoreElements()){ 
                InetAddress ipObject = inetAddressObject.nextElement(); 
                if (ipObject instanceof Inet6Address){ 
                    if (ipObject.isLinkLocalAddress()){ 
                        ipv6Object = ipObject.getHostAddress(); 
                    } 
                } 
            } 
        } 
        return ipv6Object; 
    }
    public static String 
    macName(){ 
        Enumeration<NetworkInterface> networkInterfaceObject = null; 
        
        try { 
            networkInterfaceObject = NetworkInterface.getNetworkInterfaces(); 
        } catch (SocketException exObject) { 
            throw new RuntimeException(exObject); 
        } 
        
        NetworkInterface currentObject = networkInterfaceObject.nextElement();
 
        return currentObject.getDisplayName();
    }
}
