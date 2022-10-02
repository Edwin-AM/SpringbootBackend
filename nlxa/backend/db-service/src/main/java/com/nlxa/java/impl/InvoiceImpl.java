package com.nlxa.java.impl;

import com.nlxa.java.connector.IConnector;
import com.nlxa.java.domain.Invoice;

public interface InvoiceImpl extends IConnector<Invoice, String>  {

    Boolean verifyValueID(String id);

}
