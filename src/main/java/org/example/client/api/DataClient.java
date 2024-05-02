package org.example.client.api;

import jakarta.xml.ws.Service;
import org.example.client.utils.Constants;
import org.example.server.service.DataService;

import javax.xml.namespace.QName;
import java.net.URI;
import java.net.URL;

public class DataClient {

    //зменшив кількість коду
    //спростивши створення обєкту одним методом
    private DataService getService () throws Exception {
        URL url = URI.create(Constants.WSDL_URL).toURL();
        QName qname = new QName(Constants.SERVICE_URI, Constants.SERVICE_IMPL);
        Service service = Service.create(url, qname);
        return service.getPort(DataService.class);

    }
    public String runClient(String data) throws Exception {
        return getService().getData(data);


    }
}
