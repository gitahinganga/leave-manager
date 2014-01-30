/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itechkenya.leavemanager.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gitahi
 */
public abstract class LeaveManagerTableModel extends AbstractTableModel {

    private List<Object> rows;

    public List<Object> getRows() {
        if (rows == null) {
            rows = new ArrayList<>();
        }
        return rows;
    }

    public void createRow(Object row) {
        if (!getRows().contains(row)) {
            getRows().add(row);
            int rowIndex = getRows().indexOf(row);
            fireTableRowsInserted(rowIndex, rowIndex);
        }
    }

    public void editRow(Object row) {
        if (getRows().contains(row)) {
            int rowIndex = getRows().indexOf(row);
            getRows().set(rowIndex, row);
            fireTableRowsUpdated(rowIndex, rowIndex);
        }
    }

    public void destroyRow(Object row) {
        if (getRows().contains(row)) {
            int rowIndex = getRows().indexOf(row);
            getRows().remove(row);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }

    @Override
    public int getRowCount() {
        return getRows().size();
    }

    @Override
    public int getColumnCount() {
        return getColumns().length;
    }

    @Override
    public String getColumnName(int column) {
        return getColumns()[column];
    }

    public abstract String[] getColumns();

    public Object getRow(int rowIndex) {
        return rows.get(rowIndex);
    }
}