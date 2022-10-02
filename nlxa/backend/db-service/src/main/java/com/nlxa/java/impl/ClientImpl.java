package com.nlxa.java.impl;

import com.nlxa.java.connector.IConnector;
import com.nlxa.java.domain.Client;
import com.nlxa.java.domain.Invoice;

public interface ClientImpl extends IConnector<Client, String> {

    Boolean verifyValueID(String id);
}
