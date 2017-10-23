package com.ferart.informx.models.data.daos;

public interface ResponseCallbackDAO<T> {

    void registerCallback(T callback);

    void unregisterCallback();
}
