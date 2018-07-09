# Librdfa - RDF4J

## Prerequisites

You need to install the [librdfa](https://github.com/rdfa/librdfa) library.

## Compile

`mvn clean install`

## Use

Add the library and you can parse an `InputStream` as you would do with `[Rio](http://docs.rdf4j.org/javadoc/2.1/org/eclipse/rdf4j/rio/Rio.html)`.

``` java
    RDFParser rdfParser = Rio.createParser(RDFFormat.RDFA);
    Model model = new LinkedHashModel();
    rdfParser.setRDFHandler(new StatementCollector(model));
    rdfParser.parse(in2, "http://www.example.org./");
```