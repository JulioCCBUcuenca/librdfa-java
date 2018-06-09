%module(directors="1") rdfa
%{
#include "stdlib.h"
#include "RdfaParser.h"
#include "rdfa_utils.h"
#include "rdfa.h"

RdfaParser* gRdfaParser = NULL;
void process_default_graph_triple(rdftriple* triple, void* callback_data);
void process_processor_graph_triple(rdftriple* triple, void* callback_data);
size_t fill_buffer(char* buffer, size_t buffer_length, void* callback_data);
%}

%constant int RDF_TYPE_NAMESPACE_PREFIX = RDF_TYPE_NAMESPACE_PREFIX;
%constant int RDF_TYPE_IRI = RDF_TYPE_IRI;
%constant int RDF_TYPE_PLAIN_LITERAL = RDF_TYPE_PLAIN_LITERAL;
%constant int RDF_TYPE_XML_LITERAL = RDF_TYPE_XML_LITERAL;
%constant int RDF_TYPE_TYPED_LITERAL = RDF_TYPE_TYPED_LITERAL;

%typemap(in) Objec *pyfunc {
  if (!PyCallable_Check($input)) {
      PyErr_SetString(PyExc_TypeError, "Need a callable object!");
      return NULL;
  }
  $1 = $input;
}

%feature("director") Callback;
%include RdfaParser.h
%{
void process_default_graph_triple(rdftriple* triple, void* callback_data)
{
   /** ACQUIRE_GIL;
   PyObject* func;
   PyObject* data = (PyObject*)gRdfaParser->mTripleHandlerData;
   PyObject* arglist;
   PyObject* pyresult;

   // call the Python function to get the data for the buffer
   func = (PyObject*)gRdfaParser->mDefaultGraphTripleHandlerCallback;
   arglist = Py_BuildValue((char*)"(Osssiss)", data, triple->subject,
      triple->predicate, triple->object, triple->object_type,
      (char*)triple->datatype, triple->language);

   PyEval_CallObject(func, arglist);
   Py_DECREF(arglist);

   rdfa_free_triple(triple);
   RELEASE_GIL;*/
}
%}
