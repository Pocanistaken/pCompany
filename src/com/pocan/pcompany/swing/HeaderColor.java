package com.pocan.pcompany.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class HeaderColor extends DefaultTableCellRenderer {

        public HeaderColor() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
           
           setBackground(new java.awt.Color(0, 0, 0)); // 32,136,203
           setForeground(new Color(255, 255, 255));
           setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12));

            return this;
        }

    }