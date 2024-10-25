package com.tarik.controle1.services;

import com.tarik.controle1.DAO.CDInterface;
import com.tarik.controle1.DAO.impl.CdImpl;
import com.tarik.controle1.model.CD;
import jakarta.enterprise.context.RequestScoped;


import java.util.List;
@RequestScoped
public class CdServices {

    private CDInterface cdDao = new CdImpl();

    public List<CD> listAvailableCDs() {
        return cdDao.getAllAvailableCDs();
    }


}
