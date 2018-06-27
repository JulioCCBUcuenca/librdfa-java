/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucuenca.rdf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Collection;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.rio.ParseErrorListener;
import org.eclipse.rdf4j.rio.ParseLocationListener;
import org.eclipse.rdf4j.rio.ParserConfig;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFHandler;
import org.eclipse.rdf4j.rio.RDFHandlerException;
import org.eclipse.rdf4j.rio.RDFParseException;
import org.eclipse.rdf4j.rio.RDFParser;
import org.eclipse.rdf4j.rio.RioSetting;

/**
 *
 * @author Julio Caguano
 */
public class LibrdfaParser implements RDFParser {

    @Override
    public RDFFormat getRDFFormat() {
        return RDFFormat.RDFA;
    }

    @Override
    public RDFParser setValueFactory(ValueFactory vf) {
        return this;
    }

    @Override
    public RDFParser setRDFHandler(RDFHandler rdfh) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RDFParser setParseErrorListener(ParseErrorListener pl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RDFParser setParseLocationListener(ParseLocationListener pl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RDFParser setParserConfig(ParserConfig pc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ParserConfig getParserConfig() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<RioSetting<?>> getSupportedSettings() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> RDFParser set(RioSetting<T> rs, T t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setVerifyData(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPreserveBNodeIDs(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStopAtFirstError(boolean bln) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDatatypeHandling(DatatypeHandling dh) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void parse(InputStream in, String string) throws IOException, RDFParseException, RDFHandlerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void parse(Reader reader, String string) throws IOException, RDFParseException, RDFHandlerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
