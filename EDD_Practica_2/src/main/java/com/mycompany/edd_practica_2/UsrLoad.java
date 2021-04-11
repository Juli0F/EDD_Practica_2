/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edd_practica_2;

import java.util.List;

/**
 *
 * @author Temporal
 */
public class UsrLoad {
    private String id;
    private List<Integer> lst;

    public UsrLoad(String id, List<Integer> lst) {
        this.id = id;
        this.lst = lst;
    }

    public UsrLoad() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Integer> getLst() {
        return lst;
    }

    public void setLst(List<Integer> lst) {
        this.lst = lst;
    }
    

    
    
    
}
