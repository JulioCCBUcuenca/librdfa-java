# Librdfa - RDF4J


``` java
    RDFParser rdfParser = Rio.createParser(RDFFormat.RDFA);
    Model model = new LinkedHashModel();
    rdfParser.setRDFHandler(new StatementCollector(model));
    rdfParser.parse(in2, "http://www.example.org./");
```