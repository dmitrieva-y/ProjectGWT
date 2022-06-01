package com.example.gwt_project.server;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("/test")
public interface GwtServiceIntf extends RemoteService {

    String gwtAppCallServer(String data) throws IllegalArgumentException;
}