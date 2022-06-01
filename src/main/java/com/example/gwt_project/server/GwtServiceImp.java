package com.example.gwt_project.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GwtServiceImp extends RemoteServiceServlet implements GwtServiceIntf {

    @Override
    public String gwtAppCallServer(String data) throws IllegalArgumentException {
        return "hello " + data;
    }
}

