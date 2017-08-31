/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.prn335.guia03;

import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author William
 */
@RunWith(Arquillian.class)
public class UtilitiesTest {
    @Deployment
    public static WebArchive desplegar(){
        WebArchive salida = ShrinkWrap.create(WebArchive.class)
                .addClass(Utilities.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE,"beans.xml");
        System.err.println(salida.toString(true));
        return salida;
    }
    @Inject
    private Utilities utilidades;
    
    @Test
    public void testGetResume(){
    String resumenEsperado="Bienvenidos a la mat";
    String resultado=utilidades.getResume("Bienvenidos a la materia de Programación 3 Ciclo II 2017.");
        Assert.assertEquals(resultado, resumenEsperado);
    
    }
    
    @Test
    public void testGetResume1(){
    String resumenEsperado="Hola Mundo!";
    String resultado=utilidades.getResume("Hola Mundo!");
        Assert.assertEquals(resultado, resumenEsperado);
    
    }
    
    @Test
    public void testGetResume2(){
    String resumenEsperado=null;
    String resultado=utilidades.getResume(null);
        Assert.assertEquals(resultado, resumenEsperado);
    
    }
    
    @Test
    public void testCapitalizar(){
    String esperado="Pruebas De Unidad Con Junit & Arquillian";
    String resultado=utilidades.capitalizar("prueBas  de  UNIDAD con  JUnit  & arQuillian");
        Assert.assertEquals(resultado, esperado);
    
    }
     @Test
    public void testCapitalizar1(){
    String esperado="";
    String resultado=utilidades.capitalizar("");
        Assert.assertEquals(resultado, esperado);
    
    }
     @Test
    public void testCapitalizar2(){
    String esperado=null;
    String resultado=utilidades.capitalizar(null);
        Assert.assertEquals(resultado, esperado);
    
    }
    @Test
    public void testCoincidencias(){
    int esperado=1;
    String frase="2017";
    String texto = "Bienvenidos a la materia de Programación 3 Ciclo II​2017.";
    int resultado=utilidades.contarCoincidencias(frase,texto);
    Assert.assertEquals(resultado, esperado);
    
    }
      @Test
    public void testCoincidencias1(){
    int esperado=2;
    String frase="MA";
    String texto = "Bienvenidos a la materia de Programación 3 Ciclo II​2017.";
    int resultado=utilidades.contarCoincidencias(frase,texto);
    Assert.assertEquals(resultado, esperado);
    
    }
      @Test
    public void testCoincidencias2(){
    int esperado=0;
    String frase="bienvenido";
    String texto = null;
    int resultado=utilidades.contarCoincidencias(frase,texto);
    Assert.assertEquals(resultado, esperado);
    
    }
        
    
}
