cmake_minimum_required(VERSION 2.8)
project (main)

find_package(SWIG REQUIRED)
find_package(Java REQUIRED)
find_package(JNI REQUIRED)
find_package(LibXml2 REQUIRED)

include(UseJava)
include(UseSWIG)

# add rdfa linker and compiler flags
# https://stackoverflow.com/questions/32507252/how-to-include-pkg-config-cflags-libs-gtk-2-0-in-cxx-flags-of-cmake?rq=1
# https://stackoverflow.com/questions/11961303/cmake-which-package-name-to-pass-to-find-package

include_directories(${LIBXML2_INCLUDE_DIR})
include_directories(${JNI_INCLUDE_DIRS})
#link_directories(/usr/local/lib)
link_libraries(rdfa)



set( CMAKE_SWIG_OUTDIR ${CMAKE_CURRENT_BINARY_DIR} )
include_directories(${CMAKE_CURRENT_BINARY_DIR}/..)

set_property(SOURCE rdfa.i PROPERTY CPLUSPLUS ON)
# set(CMAKE_SWIG_FLAGS -package example)
# set(CMAKE_SWIG_OUTDIR "${CMAKE_CURRENT_SOURCE_DIR}/example")
# set_source_files_properties(example.i PROPERTIES CPLUSPLUS ON)
# SWIG_ADD_MODULE(core Java native.i lib.cpp)

# Build the C++ code into a dynamic library: example.dll (on Windows) or libexample.so (on Linux)
swig_add_module(
    rdfaJava
    java
    rdfa.i
    RdfaParser.cpp
)

# For convenience we copy the dynamic library to the current build folder
add_custom_command(
    TARGET rdfaJava
    POST_BUILD
    COMMAND ${CMAKE_COMMAND} -E copy_if_different $<TARGET_FILE:rdfaJava> ${CMAKE_CURRENT_BINARY_DIR}
)

# Build the Java code into ExampleJNI.jar
add_jar(
    RdfaJNI
    SOURCES
    ${CMAKE_SWIG_OUTDIR}/rdfa.java
    ${CMAKE_SWIG_OUTDIR}/rdfaJNI.java
)
add_dependencies( RdfaJNI rdfaJava )

# Finally build the demonstration code into Main.jar

set(CMAKE_JAVA_JAR_ENTRY_POINT main)
add_jar(
    Main
    SOURCES main.java
    ENTRY_POINT main
)
add_dependencies( Main RdfaJNI )
