package com.zmops.component.zabbix.agent;

import java.net.URI;
import java.util.Map;

import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import org.apache.camel.spi.UriPath;

/**
 * @author nantian created at 2021/8/30 20:50
 */

@UriParams
public class ZabbixAgentConfiguration {

    @UriPath(defaultValue = "" + 10050, description = "zabbix agent listener port")
    @Metadata(required = true)
    private int listenPort;

    @UriPath(defaultValue = "0.0.0.0", description = "zabbix agent listener ip")
    @Metadata(required = true)
    private String listenIp;

    @UriParam(defaultValue = "" + 3000, description = "超时时间, 单位: 毫秒")
    private int readTimeout;

    public void parseURI(URI uri, Map<String, Object> parameters, ZabbixAgentComponent component) throws Exception {
        setListenIp(uri.getHost());

        if (uri.getPort() != -1) {
            setListenPort(uri.getPort());
        }

        readTimeout = component.getAndRemoveOrResolveReferenceParameter(parameters, "readTimeout", Integer.class, 3000);
    }

    public int getListenPort() {
        return listenPort;
    }

    public void setListenPort(int listenPort) {
        this.listenPort = listenPort;
    }

    public String getListenIp() {
        return listenIp;
    }

    public void setListenIp(String listenIp) {
        this.listenIp = listenIp;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }
}
