package com.nlxa.java.impl;

import com.nlxa.java.domain.Product;
import com.nlxa.java.connector.IConnector;

public interface ProductImpl extends IConnector<Product, String>{

    Boolean verifyValueID(String id);

}
