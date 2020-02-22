/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tabele;

import domen.Angazovanje;
import domen.Profesor;
import domen.Predmet;
import domen.TipNastave;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class ModelTabeleAngazovanja extends AbstractTableModel {

    private List<Angazovanje> angazovanja;
    private String[] header = new String[]{"Predmet", "Profesor", "Tip nastave"};

    public ModelTabeleAngazovanja(List<Angazovanje> angazovanja) {
        this.angazovanja = angazovanja;
    }

    @Override
    public String getColumnName(int i) {
        return header[i];
    }

    @Override
    public int getRowCount() {
        if (angazovanja == null) {
            return 0;
        }
        return angazovanja.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Angazovanje angazovanje = angazovanja.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return angazovanje.getPredmet();
            case 1:
                return angazovanje.getProfesor();
            case 2:
                return angazovanje.getTipNastave();
            default:
                return "N/A";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return false;
            case 1:
                return false;
            case 2:
                return false;
            default:
                return false;
        }
    }

    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Angazovanje angazovanje = angazovanja.get(rowIndex);
        switch (columnIndex) {
            case 0:
                angazovanje.setPredmet((Predmet) aValue);
                break;
            case 1:
                angazovanje.setProfesor((Profesor) aValue);
                break;
            case 2:
                angazovanje.setTipNastave((TipNastave)aValue);
                break;
        }
    }

    public void dodajAngazovanje(Angazovanje angazovanje) {
        angazovanja.add(angazovanje);
        fireTableDataChanged();
    }

    public void obrisiAngazovanje(int rowIndex) {
        angazovanja.remove(rowIndex);
        fireTableDataChanged();
    }

    public List<Angazovanje> dajAngazovanja() {
        return angazovanja;
    }

    public Angazovanje dajAngazovanje(int rowIndex) {
        return angazovanja.get(rowIndex);
    }
    public void obrisiSvaAngazovanja()
    {
    angazovanja = new ArrayList<>();
    fireTableDataChanged();
    }
}
