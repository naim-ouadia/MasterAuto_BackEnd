/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.masterAuto.commun;


/**
 *
 * @author wadie
 */
public class NumberUtil {
    
    private static final String CHAINE_VIDE = "";
    private static final Double ZERO_DOUBLE = 0D;
    private static final Integer ZERO_INTEGER = 0;
    /*******************************************/
        public static Double toDouble (String value){
        
       if(value==null || value.isEmpty()){
           return ZERO_DOUBLE;
       } 
       else{
           return Double.parseDouble(value);
       }
    }
    /*************************************************/
     public static Integer toInteger(String value){
        
       if(value==null || value.isEmpty()){
           return ZERO_INTEGER;
       } 
       else{
           return Integer.parseInt(value);
       }
    }
      /*************************************/
    public static String toString(Double value) {
        if (value == null) {
            return CHAINE_VIDE;
        } else {
            return String.valueOf(value);
        }
    }
}
