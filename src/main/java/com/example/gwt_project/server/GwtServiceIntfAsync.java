package com.example.gwt_project.server;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GwtServiceIntfAsync {
    void gwtAppCallServer(String data, AsyncCallback<String> callback) throws IllegalArgumentException;
}
