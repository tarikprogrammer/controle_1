package com.tarik.controle1.DAO;

import com.tarik.controle1.model.CD;

import java.util.List;

public interface CDInterface  {
    List<CD> getAllAvailableCDs();
    boolean emprunterCD(int cdId);

    boolean emprunterCD(int cd);
}
