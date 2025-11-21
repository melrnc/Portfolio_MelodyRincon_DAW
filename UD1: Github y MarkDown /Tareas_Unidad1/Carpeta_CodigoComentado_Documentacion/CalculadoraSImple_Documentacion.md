CalculadoraSimple        var pathtoroot = "../"; loadScripts(document, 'script');

JavaScript is disabled on your browser.

   

[Skip navigation links](#skip-navbar-top "Skip navigation links")

*   [Package](package-summary.html)
*   Class
*   [Use](class-use/CalculadoraSimple.html)
*   [Tree](package-tree.html)
*   [Index](../index-files/index-1.html)
*   [Help](../help-doc.html#class)

*   Summary:
    
    *   Nested
    *   Field
    *   [Constr](#constructor-summary)
    *   [Method](#method-summary)
*   Detail:
    
    *   Field
    *   [Constr](#constructor-detail)
    *   [Method](#method-detail)

*   Summary: 
*   Nested | 
*   Field | 
*   [Constr](#constructor-summary) | 
*   [Method](#method-summary)

*   Detail: 
*   Field | 
*   [Constr](#constructor-detail) | 
*   [Method](#method-detail)

[SEARCH](../search.html)  

Package [calculadorasimple](package-summary.html)

Class CalculadoraSimple
=======================

[java.lang.Object](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/Object.html "class or interface in java.lang")

calculadorasimple.CalculadoraSimple

* * *

public class CalculadoraSimple extends [Object](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/Object.html "class or interface in java.lang")

Since:

2025-11-19

*   Constructor Summary
    -------------------
    
    Constructors
    
    Constructor
    
    Description
    
    `[CalculadoraSimple](#%3Cinit%3E())()`
    
    Constructor por defecto de la clase CalculadoraSimple.
    
*   Method Summary
    --------------
    
    All MethodsStatic MethodsInstance MethodsConcrete Methods
    
    Modifier and Type
    
    Method
    
    Description
    
    `static void`
    
    `[main](#main(java.lang.String%5B%5D))([String](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/String.html "class or interface in java.lang")[] args)`
    
    Método principal que se ejecuta al iniciar el programa.
    
    `int`
    
    `[restar](#restar(int,int))(int a, int b)`
    
    Realiza la operación de resta entre dos números enteros.
    
    `int`
    
    `[sumar](#sumar(int,int))(int a, int b)`
    
    Realiza la operación de suma entre dos números enteros.
    
    ### Methods inherited from class java.lang.[Object](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/Object.html "class or interface in java.lang")
    
    `[clone](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/Object.html#clone() "class or interface in java.lang"), [equals](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object) "class or interface in java.lang"), [finalize](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/Object.html#finalize() "class or interface in java.lang"), [getClass](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/Object.html#getClass() "class or interface in java.lang"), [hashCode](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/Object.html#hashCode() "class or interface in java.lang"), [notify](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/Object.html#notify() "class or interface in java.lang"), [notifyAll](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/Object.html#notifyAll() "class or interface in java.lang"), [toString](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/Object.html#toString() "class or interface in java.lang"), [wait](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/Object.html#wait() "class or interface in java.lang"), [wait](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/Object.html#wait(long) "class or interface in java.lang"), [wait](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/Object.html#wait(long,int) "class or interface in java.lang")`
    

*   Constructor Details
    -------------------
    
    *   ### CalculadoraSimple
        
        public CalculadoraSimple()
        
        Constructor por defecto de la clase CalculadoraSimple.
        
    
*   Method Details
    --------------
    
    *   ### sumar
        
        public int sumar(int a, int b)
        
        Realiza la operación de suma entre dos números enteros. Este método acepta números positivos, negativos o cero.
        
        Parameters:
        
        `a` - El primer número a sumar (sumando).
        
        `b` - El segundo número a sumar (sumando).
        
        Returns:
        
        El resultado entero de la suma de 'a' y 'b'.
        
    *   ### restar
        
        public int restar(int a, int b)
        
        Realiza la operación de resta entre dos números enteros.
        
        Parameters:
        
        `a` - El número del que se va a restar (minuendo).
        
        `b` - El número a restar (sustraendo).
        
        Returns:
        
        El resultado entero de la resta de 'a' menos 'b'.
        
    *   ### main
        
        public static void main([String](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/String.html "class or interface in java.lang")\[\] args)
        
        Método principal que se ejecuta al iniciar el programa. Sirve para probar las funcionalidades de la calculadora.
        
        Parameters:
        
        `args` - Argumentos de la línea de comandos (no utilizados).