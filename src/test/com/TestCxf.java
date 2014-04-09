package com;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

/**
 * Created by Administrator on 14-4-8.
 */
public class TestCxf {
    public static void main(String[] args) {

        URL url = null;
        try{
            url = new URL("http://210.13.111.26:8087/hummer/services/HelloWorldService?wsdl");
        }catch (Exception e){

        }

           QName SERVICE_NAME= new QName("http://ws.uc.svw.com/", "HelloWorld");
           Service service = Service.create(url, SERVICE_NAME);
        //IHelloWorld hw = service.getPort(IHelloWorld.class);
        System.out.println(service.getServiceName());

    }


}
