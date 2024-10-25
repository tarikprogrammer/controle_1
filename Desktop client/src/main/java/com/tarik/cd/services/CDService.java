package com.tarik.cd.services;

import com.tarik.cd.model.CD;

import java.util.ArrayList;
import java.util.List;

public class CDService {
    private List<CD> cds = new ArrayList<>();
    private int nextId = 1;

    public void addCD(String title, String artist, int year) {
        cds.add(new CD(nextId++, title, artist, year));
    }

    public List<CD> getCDs() {
        return cds;
    }

    public void updateCD(int id, String title, String artist, int year) {
        for (CD cd : cds) {
            if (cd.getId() == id) {
                cd.setTitle(title);
                cd.setArtist(artist);
                cd.setYear(year);
                break;
            }
        }
    }

    public void deleteCD(int id) {
        cds.removeIf(cd -> cd.getId() == id);
    }
}
