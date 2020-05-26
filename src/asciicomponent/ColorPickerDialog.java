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
package asciicomponent;

import asciistudio.App;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Ian Martinez
 */
public class ColorPickerDialog extends javax.swing.JDialog {
    private Color initialColor;
    private boolean hasChosenColor = false;

    /**
     * Creates new form ColorDialog
     */
    public ColorPickerDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        // VAqua's dark mode *completely* bugs out on the JColorPicker, so
        // disable it for this window
        App.setProperty(rootPane, "Aqua.appearanceName", "NSAppearanceNameAqua");

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

        colorChooser = new javax.swing.JColorChooser();
        buttonPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        colorChooser.setDoubleBuffered(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(colorChooser, gridBagConstraints);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(okButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(cancelButton);

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(resetButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(buttonPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        hasChosenColor = true;
        this.setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        hasChosenColor = false;
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        if (initialColor != null)
            setColor(initialColor);
    }//GEN-LAST:event_resetButtonActionPerformed

    public static Color showDialog(JFrame frame, String title, Color initialColor) {
        var colorDialog = new ColorPickerDialog(frame, true);
        colorDialog.setLocationRelativeTo(frame);
        colorDialog.setModalityType(ModalityType.APPLICATION_MODAL);
        colorDialog.setInitialColor(initialColor);
        colorDialog.setTitle(title);
        colorDialog.setVisible(true);

        return colorDialog.hasChosenColor() ? colorDialog.getColor() : null;
    }
    
    public static Color showDialog(Component component, String title, Color initialColor) {
        var ancestorFrame = (JFrame) SwingUtilities.getWindowAncestor(component);
        return showDialog(ancestorFrame, title, initialColor);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JColorChooser colorChooser;
    private javax.swing.JButton okButton;
    private javax.swing.JButton resetButton;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the initialColor
     */
    public Color getInitialColor() {
        return initialColor;
    }

    /**
     * @param initialColor the initialColor to set
     */
    public void setInitialColor(Color initialColor) {
        this.initialColor = initialColor;
        this.colorChooser.setColor(initialColor);
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return colorChooser.getColor();
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        colorChooser.setColor(color);
    }
    
    /**
     * @return if the user has chosen as color
     */
    public boolean hasChosenColor() {
        return hasChosenColor;
    }
}