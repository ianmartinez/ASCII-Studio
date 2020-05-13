/*
 * Copyright (C) 2020 Ian Martinez
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ascomponent;

import asciistudio.Palette;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Locale;
import javax.swing.JColorChooser;

/**
 *
 * @author Ian Martinez
 */
public class PalettePanel extends javax.swing.JPanel {
    
    private Palette palette = new Palette();
    
    /**
     * Creates new form FontPicker
     */
    public PalettePanel() {
        initComponents();
        
        // Load font combo
        fontFamiliesComboBox.removeAllItems();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] allFonts = ge.getAllFonts();
        for (Font font : allFonts) {
            fontFamiliesComboBox.addItem(font.getFontName(Locale.US));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        backgroundColorButton = new javax.swing.JButton();
        backgroundColorPanel = new ascomponent.ColorPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        fontColorPanel = new ascomponent.ColorPanel();
        fontColorButton = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        fontFamiliesComboBox = new javax.swing.JComboBox<>();
        jSpinner1 = new javax.swing.JSpinner();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();

        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        jPanel7.setMinimumSize(new java.awt.Dimension(200, 45));
        jPanel7.setPreferredSize(new java.awt.Dimension(375, 30));
        java.awt.GridBagLayout jPanel7Layout = new java.awt.GridBagLayout();
        jPanel7Layout.columnWeights = new double[] {1.0, 0.0, 0.0};
        jPanel7.setLayout(jPanel7Layout);

        jLabel4.setFont(jLabel4.getFont().deriveFont(jLabel4.getFont().getStyle() | java.awt.Font.BOLD));
        jLabel4.setText("Background Color:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 9, 3, 9);
        jPanel7.add(jLabel4, gridBagConstraints);

        backgroundColorButton.setText("...");
        backgroundColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backgroundColorButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel7.add(backgroundColorButton, gridBagConstraints);

        backgroundColorPanel.setColor(new java.awt.Color(255, 255, 255));
        backgroundColorPanel.setPreferredSize(new java.awt.Dimension(180, 30));

        javax.swing.GroupLayout backgroundColorPanelLayout = new javax.swing.GroupLayout(backgroundColorPanel);
        backgroundColorPanel.setLayout(backgroundColorPanelLayout);
        backgroundColorPanelLayout.setHorizontalGroup(
            backgroundColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        backgroundColorPanelLayout.setVerticalGroup(
            backgroundColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel7.add(backgroundColorPanel, gridBagConstraints);

        add(jPanel7);

        jPanel9.setMinimumSize(new java.awt.Dimension(200, 45));
        jPanel9.setPreferredSize(new java.awt.Dimension(375, 30));
        java.awt.GridBagLayout jPanel9Layout = new java.awt.GridBagLayout();
        jPanel9Layout.columnWeights = new double[] {1.0, 0.0, 0.0, 0.0};
        jPanel9.setLayout(jPanel9Layout);

        jLabel5.setFont(jLabel5.getFont().deriveFont(jLabel5.getFont().getStyle() | java.awt.Font.BOLD));
        jLabel5.setText("Font Color:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 9, 3, 9);
        jPanel9.add(jLabel5, gridBagConstraints);

        jCheckBox1.setToolTipText("");
        jCheckBox1.setLabel("Override image");
        jCheckBox1.setMinimumSize(new java.awt.Dimension(130, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel9.add(jCheckBox1, gridBagConstraints);

        fontColorPanel.setPreferredSize(new java.awt.Dimension(180, 30));

        javax.swing.GroupLayout fontColorPanelLayout = new javax.swing.GroupLayout(fontColorPanel);
        fontColorPanel.setLayout(fontColorPanelLayout);
        fontColorPanelLayout.setHorizontalGroup(
            fontColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        fontColorPanelLayout.setVerticalGroup(
            fontColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel9.add(fontColorPanel, gridBagConstraints);

        fontColorButton.setText("...");
        fontColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontColorButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel9.add(fontColorButton, gridBagConstraints);

        add(jPanel9);

        jPanel13.setMinimumSize(new java.awt.Dimension(600, 45));
        jPanel13.setPreferredSize(new java.awt.Dimension(520, 30));
        java.awt.GridBagLayout jPanel13Layout = new java.awt.GridBagLayout();
        jPanel13Layout.columnWeights = new double[] {0.0, 1.0, 0.0};
        jPanel13.setLayout(jPanel13Layout);

        jLabel9.setFont(jLabel9.getFont().deriveFont(jLabel9.getFont().getStyle() | java.awt.Font.BOLD));
        jLabel9.setText("String weights/phrase:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 9, 3, 9);
        jPanel13.add(jLabel9, gridBagConstraints);

        jTextField1.setMinimumSize(new java.awt.Dimension(150, 26));
        jTextField1.setPreferredSize(new java.awt.Dimension(150, 26));
        jTextField1.setSize(new java.awt.Dimension(150, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel13.add(jTextField1, gridBagConstraints);

        add(jPanel13);

        jPanel12.setMinimumSize(new java.awt.Dimension(300, 45));
        jPanel12.setPreferredSize(new java.awt.Dimension(450, 30));
        java.awt.GridBagLayout jPanel12Layout = new java.awt.GridBagLayout();
        jPanel12Layout.columnWeights = new double[] {1.0, 0.0, 0.0};
        jPanel12.setLayout(jPanel12Layout);

        jLabel8.setFont(jLabel8.getFont().deriveFont(jLabel8.getFont().getStyle() | java.awt.Font.BOLD));
        jLabel8.setText("Font:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 9, 3, 9);
        jPanel12.add(jLabel8, gridBagConstraints);

        fontFamiliesComboBox.setMinimumSize(new java.awt.Dimension(150, 27));
        fontFamiliesComboBox.setPreferredSize(new java.awt.Dimension(150, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel12.add(fontFamiliesComboBox, gridBagConstraints);

        jSpinner1.setMinimumSize(new java.awt.Dimension(70, 26));
        jSpinner1.setPreferredSize(new java.awt.Dimension(25, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel12.add(jSpinner1, gridBagConstraints);

        jCheckBox2.setText("Bold");
        jCheckBox2.setMinimumSize(new java.awt.Dimension(70, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel12.add(jCheckBox2, gridBagConstraints);

        jCheckBox3.setText("Italic");
        jCheckBox3.setMinimumSize(new java.awt.Dimension(70, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel12.add(jCheckBox3, gridBagConstraints);

        add(jPanel12);
    }// </editor-fold>//GEN-END:initComponents

    private void backgroundColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backgroundColorButtonActionPerformed
        Color newColor = JColorChooser.showDialog(this, "Choose background Color", backgroundColorPanel.getColor());

        if (newColor != null) {
            backgroundColorPanel.setColor(newColor);
            palette.setBackgroundColor(newColor);
        }
    }//GEN-LAST:event_backgroundColorButtonActionPerformed

    private void fontColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontColorButtonActionPerformed
        Color newColor = JColorChooser.showDialog(this, "Choose font Color", fontColorPanel.getColor());

        if (newColor != null) {
            fontColorPanel.setColor(newColor);
            palette.setFontColor(newColor);
        }
    }//GEN-LAST:event_fontColorButtonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backgroundColorButton;
    private ascomponent.ColorPanel backgroundColorPanel;
    private javax.swing.JButton fontColorButton;
    private ascomponent.ColorPanel fontColorPanel;
    private javax.swing.JComboBox<String> fontFamiliesComboBox;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
