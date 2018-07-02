/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.any23.librdfa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.rio.RDFHandler;

/**
 *
 * @author Julio Caguano
 */
public class LibrdfaFilter extends Callback {

    private BufferedReader bis = null;
    private int len = 0;
    private RDFHandler handler;
    private ValueFactory valueFactory;

    public LibrdfaFilter(InputStream is) {
        super();
        bis = new BufferedReader(new InputStreamReader(is));
    }

    public LibrdfaFilter(Reader reader) {
        super();
        bis = new BufferedReader(reader);
    }

    @Override
    public void default_graph(String subject, String predicate, String object, int object_type, String datatype, String language) {
        System.out.println("default_graph(...)");
        Statement stmt = valueFactory.createStatement(valueFactory.createIRI(subject), valueFactory.createIRI(predicate), valueFactory.createLiteral(object));
        handler.handleStatement(stmt);
        System.out.println("S=" + subject + "P=" + predicate + "O=" + object + "OT=" + object_type + "DT=" + datatype + "LANG=" + language);
    }

    @Override
    public void processor_graph(String subject, String predicate, String object, int object_type, String datatype, String language) {
        if (handler != null) {
            handler.handleNamespace(predicate, object);
        }
        System.out.println("S=" + subject + "P=" + predicate + "O=" + object + "OT=" + object_type + datatype + "LANG=" + language);
    }

    @Override
    public String fill_data(long buffer_length) {
        System.out.println("buffer_length:" + buffer_length);
        StringBuilder sb = new StringBuilder(new StringBuffer((int) buffer_length));
        len = 0;
        try {
            for (int c; (c = bis.read()) != -1;) {
                sb.append((char) c);
                len++;
            }
        } catch (IOException ex) {
        }
        return sb.toString();
    }

    @Override
    public long fill_len() {
        return len;
    }

    public RDFHandler getHandler() {
        return handler;
    }

    public void setHandler(RDFHandler handler) {
        this.handler = handler;
    }

    public ValueFactory getValueFactory() {
        return valueFactory;
    }

    public void setValueFactory(ValueFactory valueFactory) {
        this.valueFactory = valueFactory;
    }

}
