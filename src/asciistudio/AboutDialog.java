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
package asciistudio;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ian Martinez
 */
public class AboutDialog extends javax.swing.JDialog {

    /**
     * Creates new form AboutDialog
     */
    public AboutDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        appNameLabel.setText(App.getAppTitle());
        licenseTextArea.setSelectionStart(0);
        licenseTextArea.setSelectionEnd(0);
        changelogTextArea.setSelectionStart(0);
        changelogTextArea.setSelectionEnd(0);
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

        iconLabel = new javax.swing.JLabel();
        appNameLabel = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        websiteButton = new javax.swing.JButton();
        githubButon = new javax.swing.JButton();
        patreonButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        licenseTextArea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        changelogTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 550));
        setPreferredSize(new java.awt.Dimension(300, 200));
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWeights = new double[] {1.0};
        getContentPane().setLayout(layout);

        iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asciiicons/64.png"))); // NOI18N
        getContentPane().add(iconLabel, new java.awt.GridBagConstraints());

        appNameLabel.setFont(appNameLabel.getFont().deriveFont(appNameLabel.getFont().getStyle() | java.awt.Font.BOLD, appNameLabel.getFont().getSize()+4));
        appNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appNameLabel.setText("ASCII Studio");
        appNameLabel.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 3, 10, 3);
        getContentPane().add(appNameLabel, gridBagConstraints);

        websiteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asciiicons/web.png"))); // NOI18N
        websiteButton.setText("Website");
        websiteButton.setIconTextGap(6);
        websiteButton.setMargin(new java.awt.Insets(3, 3, 3, 3));
        websiteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                websiteButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(websiteButton);

        githubButon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asciiicons/github.png"))); // NOI18N
        githubButon.setText("GitHub");
        githubButon.setIconTextGap(6);
        githubButon.setMargin(new java.awt.Insets(3, 3, 3, 3));
        githubButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                githubButonActionPerformed(evt);
            }
        });
        buttonPanel.add(githubButon);

        patreonButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asciiicons/patreon.png"))); // NOI18N
        patreonButton.setText("Support on Patreon");
        patreonButton.setToolTipText("");
        patreonButton.setIconTextGap(6);
        patreonButton.setMargin(new java.awt.Insets(3, 3, 3, 3));
        patreonButton.setVerifyInputWhenFocusTarget(false);
        patreonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patreonButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(patreonButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(buttonPanel, gridBagConstraints);

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWeights = new double[] {1.0};
        jPanel1Layout.rowWeights = new double[] {1.0};
        jPanel1.setLayout(jPanel1Layout);

        jScrollPane1.setEnabled(false);

        licenseTextArea.setEditable(false);
        licenseTextArea.setColumns(20);
        licenseTextArea.setFont(licenseTextArea.getFont().deriveFont(licenseTextArea.getFont().getSize()-1f));
        licenseTextArea.setLineWrap(true);
        licenseTextArea.setRows(5);
        licenseTextArea.setText("Copyright (C) 2016-2020, Ian Martinez \n\nGNU LESSER GENERAL PUBLIC LICENSE\nVersion 3, 29 June 2007\n\n Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>\n Everyone is permitted to copy and distribute verbatim copies\n of this license document, but changing it is not allowed.\n\n\n  This version of the GNU Lesser General Public License incorporates\nthe terms and conditions of version 3 of the GNU General Public\nLicense, supplemented by the additional permissions listed below.\n\n  0. Additional Definitions.\n\n  As used herein, \"this License\" refers to version 3 of the GNU Lesser\nGeneral Public License, and the \"GNU GPL\" refers to version 3 of the GNU\nGeneral Public License.\n\n  \"The Library\" refers to a covered work governed by this License,\nother than an Application or a Combined Work as defined below.\n\n  An \"Application\" is any work that makes use of an interface provided\nby the Library, but which is not otherwise based on the Library.\nDefining a subclass of a class defined by the Library is deemed a mode\nof using an interface provided by the Library.\n\n  A \"Combined Work\" is a work produced by combining or linking an\nApplication with the Library.  The particular version of the Library\nwith which the Combined Work was made is also called the \"Linked\nVersion\".\n\n  The \"Minimal Corresponding Source\" for a Combined Work means the\nCorresponding Source for the Combined Work, excluding any source code\nfor portions of the Combined Work that, considered in isolation, are\nbased on the Application, and not on the Linked Version.\n\n  The \"Corresponding Application Code\" for a Combined Work means the\nobject code and/or source code for the Application, including any data\nand utility programs needed for reproducing the Combined Work from the\nApplication, but excluding the System Libraries of the Combined Work.\n\n  1. Exception to Section 3 of the GNU GPL.\n\n  You may convey a covered work under sections 3 and 4 of this License\nwithout being bound by section 3 of the GNU GPL.\n\n  2. Conveying Modified Versions.\n\n  If you modify a copy of the Library, and, in your modifications, a\nfacility refers to a function or data to be supplied by an Application\nthat uses the facility (other than as an argument passed when the\nfacility is invoked), then you may convey a copy of the modified\nversion:\n\n   a) under this License, provided that you make a good faith effort to\n   ensure that, in the event an Application does not supply the\n   function or data, the facility still operates, and performs\n   whatever part of its purpose remains meaningful, or\n\n   b) under the GNU GPL, with none of the additional permissions of\n   this License applicable to that copy.\n\n  3. Object Code Incorporating Material from Library Header Files.\n\n  The object code form of an Application may incorporate material from\na header file that is part of the Library.  You may convey such object\ncode under terms of your choice, provided that, if the incorporated\nmaterial is not limited to numerical parameters, data structure\nlayouts and accessors, or small macros, inline functions and templates\n(ten or fewer lines in length), you do both of the following:\n\n   a) Give prominent notice with each copy of the object code that the\n   Library is used in it and that the Library and its use are\n   covered by this License.\n\n   b) Accompany the object code with a copy of the GNU GPL and this license\n   document.\n\n  4. Combined Works.\n\n  You may convey a Combined Work under terms of your choice that,\ntaken together, effectively do not restrict modification of the\nportions of the Library contained in the Combined Work and reverse\nengineering for debugging such modifications, if you also do each of\nthe following:\n\n   a) Give prominent notice with each copy of the Combined Work that\n   the Library is used in it and that the Library and its use are\n   covered by this License.\n\n   b) Accompany the Combined Work with a copy of the GNU GPL and this license\n   document.\n\n   c) For a Combined Work that displays copyright notices during\n   execution, include the copyright notice for the Library among\n   these notices, as well as a reference directing the user to the\n   copies of the GNU GPL and this license document.\n\n   d) Do one of the following:\n\n       0) Convey the Minimal Corresponding Source under the terms of this\n       License, and the Corresponding Application Code in a form\n       suitable for, and under terms that permit, the user to\n       recombine or relink the Application with a modified version of\n       the Linked Version to produce a modified Combined Work, in the\n       manner specified by section 6 of the GNU GPL for conveying\n       Corresponding Source.\n\n       1) Use a suitable shared library mechanism for linking with the\n       Library.  A suitable mechanism is one that (a) uses at run time\n       a copy of the Library already present on the user's computer\n       system, and (b) will operate properly with a modified version\n       of the Library that is interface-compatible with the Linked\n       Version.\n\n   e) Provide Installation Information, but only if you would otherwise\n   be required to provide such information under section 6 of the\n   GNU GPL, and only to the extent that such information is\n   necessary to install and execute a modified version of the\n   Combined Work produced by recombining or relinking the\n   Application with a modified version of the Linked Version. (If\n   you use option 4d0, the Installation Information must accompany\n   the Minimal Corresponding Source and Corresponding Application\n   Code. If you use option 4d1, you must provide the Installation\n   Information in the manner specified by section 6 of the GNU GPL\n   for conveying Corresponding Source.)\n\n  5. Combined Libraries.\n\n  You may place library facilities that are a work based on the\nLibrary side by side in a single library together with other library\nfacilities that are not Applications and are not covered by this\nLicense, and convey such a combined library under terms of your\nchoice, if you do both of the following:\n\n   a) Accompany the combined library with a copy of the same work based\n   on the Library, uncombined with any other library facilities,\n   conveyed under the terms of this License.\n\n   b) Give prominent notice with the combined library that part of it\n   is a work based on the Library, and explaining where to find the\n   accompanying uncombined form of the same work.\n\n  6. Revised Versions of the GNU Lesser General Public License.\n\n  The Free Software Foundation may publish revised and/or new versions\nof the GNU Lesser General Public License from time to time. Such new\nversions will be similar in spirit to the present version, but may\ndiffer in detail to address new problems or concerns.\n\n  Each version is given a distinguishing version number. If the\nLibrary as you received it specifies that a certain numbered version\nof the GNU Lesser General Public License \"or any later version\"\napplies to it, you have the option of following the terms and\nconditions either of that published version or of any later version\npublished by the Free Software Foundation. If the Library as you\nreceived it does not specify a version number of the GNU Lesser\nGeneral Public License, you may choose any version of the GNU Lesser\nGeneral Public License ever published by the Free Software Foundation.\n\n  If the Library as you received it specifies that a proxy can decide\nwhether future versions of the GNU Lesser General Public License shall\napply, that proxy's public statement of acceptance of any version is\npermanent authorization for you to choose that version for the\nLibrary."); // NOI18N
        licenseTextArea.setWrapStyleWord(true);
        licenseTextArea.setFocusable(false);
        licenseTextArea.setMinimumSize(new java.awt.Dimension(200, 400));
        licenseTextArea.setSelectionEnd(0);
        licenseTextArea.setSelectionStart(0);
        jScrollPane1.setViewportView(licenseTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jScrollPane1, gridBagConstraints);

        jTabbedPane1.addTab("License", jPanel1);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jScrollPane3.setEnabled(false);

        changelogTextArea.setEditable(false);
        changelogTextArea.setColumns(20);
        changelogTextArea.setFont(changelogTextArea.getFont().deriveFont(changelogTextArea.getFont().getSize()-1f));
        changelogTextArea.setLineWrap(true);
        changelogTextArea.setRows(5);
        changelogTextArea.setText("Version 4.0 (May 30, 2020)\n   • Updated to Java 14\n   • Completely redesigned UI\n   • A more native UI on macOS, including support for dark mode\n   • GUI showing the progress of converting an image\n   • Split original-rendered pane\n   • Import and export weights\n   • Resize image before rendering by setting a sample ratio\n   • Multi-threaded image rendering and saving\n   • Add weights menu, which has several common weight sets \n   • New program icon\n\nVersion 3.1 (August 18, 2018)\n   • New program icon\n\nVersion 3.0 (January 23, 2017)\n   • Change name from \"ASCII Converter\" to \"ASCII Studio\"\n   • Improve look on HiDPI displays\n\nVersion 2.0 (October 12, 2016)\n   • Code cleanup\n   • Migrate from JCreator to NetBeans\n   • Update toolbar icons\n   • Added \"export using phrase\" option\n\nVersion 1.1 (May 17, 2016)\n   • Updated UI\n   • Show progress bars in console\n   • Files now open automatically when finished converting\n   • Bug fix: characters where off by a few pixels \n\nVersion 1.0 (May 5, 2016)\n   • Initial release");
        changelogTextArea.setWrapStyleWord(true);
        changelogTextArea.setFocusable(false);
        changelogTextArea.setMinimumSize(new java.awt.Dimension(200, 400));
        jScrollPane3.setViewportView(changelogTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jScrollPane3, gridBagConstraints);

        jTabbedPane1.addTab("Changelog", jPanel2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jTabbedPane1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void websiteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_websiteButtonActionPerformed
        openLink("https://ianmtz.com/asciistudio");
    }//GEN-LAST:event_websiteButtonActionPerformed

    private void githubButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_githubButonActionPerformed
        openLink("https://github.com/ianmartinez/AsciiStudio");
    }//GEN-LAST:event_githubButonActionPerformed

    private void patreonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patreonButtonActionPerformed
        openLink("https://www.patreon.com/ianmartinez");
    }//GEN-LAST:event_patreonButtonActionPerformed

    private void openLink(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (URISyntaxException | IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not open '" + url + "'");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appNameLabel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JTextArea changelogTextArea;
    private javax.swing.JButton githubButon;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea licenseTextArea;
    private javax.swing.JButton patreonButton;
    private javax.swing.JButton websiteButton;
    // End of variables declaration//GEN-END:variables
}
