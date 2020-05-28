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

import asciicomponent.ProgressPanel;
import asciilib.AsciiConverter;
import asciilib.ImageSamplingParams;
import asciilib.Palette;
import giflib.Gif;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBException;

/**
 * The main window.
 *
 * @author Ian Martinez
 */
public class MainWindow extends javax.swing.JFrame {

    public String sourceImagePath = ""; // The source image's location
    public boolean isGif = false; // If the source image is a GIF or still image
    public Gif sourceGif; // The source image if it's a GIF
    public BufferedImage sourceCurrentFrame; // If a GIF, the current frame, if not the whole image
    public BufferedImage renderedCurrentFrame; // The current frame that has been rendered
    public ImageSamplingParams samplingParams; // The way to resize the image for rendering

    // File dialogs
    JFileChooser importImageDialog = new JFileChooser();
    JFileChooser exportImageDialog = new JFileChooser();
    JFileChooser exportTextDialog = new JFileChooser();
    JFileChooser importPaletteDialog = new JFileChooser();
    JFileChooser exportPaletteDialog = new JFileChooser();

    // If the user has changed from the default directory for exporting.
    // If not, open the export dialogs at the imported images location
    public boolean exportDirectoryChanged = false;

    // Filters for file dialogs
    public FileNameExtensionFilter imageFilesFilter = new FileNameExtensionFilter("Image files (*.jpeg, *.jpg, *.gif, *.png)", "jpeg", "jpg", "gif", "png");
    public FileNameExtensionFilter gifImageFilter = new FileNameExtensionFilter("GIF image (*.gif)", "gif");
    public FileNameExtensionFilter pngImageFilter = new FileNameExtensionFilter("PNG image (*.png)", "png");
    public FileNameExtensionFilter textFileFilter = new FileNameExtensionFilter("Text file (*.txt)", "txt");
    public FileNameExtensionFilter paletteFileFilter = new FileNameExtensionFilter("ASCII Palette (*.ascp)", "ascp");

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        beforeAfterSplitter.setDividerLocation(beforeAfterSplitter.getWidth() / 4);
        importImageDialog.setFileFilter(imageFilesFilter);

        exportImageDialog.addChoosableFileFilter(gifImageFilter);
        exportImageDialog.addChoosableFileFilter(pngImageFilter);
        exportImageDialog.setFileFilter(gifImageFilter);

        exportTextDialog.addChoosableFileFilter(textFileFilter);
        exportTextDialog.setFileFilter(textFileFilter);

        importPaletteDialog.addChoosableFileFilter(paletteFileFilter);
        importPaletteDialog.setFileFilter(paletteFileFilter);
        exportPaletteDialog.addChoosableFileFilter(paletteFileFilter);
        exportPaletteDialog.setFileFilter(paletteFileFilter);

        // Hide tooltips
        originalImageView.setToolTipText(null);
        renderedImageView.setToolTipText(null);
    }

    private String getExt(String path) {
        int dot = path.lastIndexOf(".");
        return (dot == -1) ? "" : path.substring(dot + 1).toLowerCase();
    }

    public String removeExt(String path) {
        if (path.equals("")) {
            return "";
        }

        int dot = path.lastIndexOf(".");
        return (dot == -1) ? path : path.substring(0, dot);
    }

    private void refreshSampleParams() {
        samplingParams.setSamplingRatio((double) sampleRatioSpinner.getValue());
    }

    private void refreshRender() {
        refreshSampleParams();

        if (isGif) {
            var frameSpinnerValue = (Integer) frameSpinner.getValue();
            sourceCurrentFrame = sourceGif.getFrameImage(frameSpinnerValue);
        }

        var converter = new AsciiConverter(currentPalette.getPalette(), samplingParams);
        renderedCurrentFrame = converter.renderImage(sourceCurrentFrame);
    }

    private void refreshPreview() {
        if (sourceCurrentFrame != null) {
            refreshRender();
            sampleWidthLabel.setText(samplingParams.getSampleWidth() + "px");
            sampleHeightLabel.setText(samplingParams.getSampleHeight() + "px");
            renderedImageView.setIcon(new StretchIcon(renderedCurrentFrame));
            renderWidthLabel.setText(renderedCurrentFrame.getWidth() + "px");
            renderHeightLabel.setText(renderedCurrentFrame.getHeight() + "px");
        }
    }

    private void enableEditing(boolean enable) {
        // File
        exportImageMenuItem.setEnabled(enable);
        exportTextMenuItem.setEnabled(enable);
        exportImageButton.setEnabled(enable);
        exportTextButton.setEnabled(enable);

        // Preview
        refreshMenuItem.setEnabled(enable);
        refreshButton.setEnabled(enable);

        // Sidebar
        frameSpinner.setEnabled(enable);
        sampleRatioSpinner.setEnabled(enable);
    }

    public void openProcess(String process) {
        try {
            Desktop.getDesktop().open(new File(process));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error opening " + process + "!");
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

        mainSplitter = new javax.swing.JSplitPane();
        settingsImageSplitter = new javax.swing.JSplitPane();
        currentPaletteContainer = new javax.swing.JPanel();
        currentPalette = new asciicomponent.PalettePanel();
        beforeAfterSplitter = new javax.swing.JSplitPane();
        originalImageView = new javax.swing.JLabel();
        renderedImageView = new javax.swing.JLabel();
        sidebarScroll = new javax.swing.JScrollPane();
        sidebarPanel = new javax.swing.JPanel();
        framesPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        frameCountLabel = new javax.swing.JLabel();
        widthPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        widthLabel = new javax.swing.JLabel();
        heightPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        heightLabel = new javax.swing.JLabel();
        currentFramePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        frameSpinner = new javax.swing.JSpinner();
        sampleRatioPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        sampleRatioSpinner = new javax.swing.JSpinner();
        sampleWidthPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        sampleWidthLabel = new javax.swing.JLabel();
        sampleHeightPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        sampleHeightLabel = new javax.swing.JLabel();
        renderWidthPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        renderWidthLabel = new javax.swing.JLabel();
        renderHeightPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        renderHeightLabel = new javax.swing.JLabel();
        progressPanel = new javax.swing.JPanel();
        progressPanel1 = new asciicomponent.ProgressPanel();
        mainToolbar = new javax.swing.JToolBar();
        importButton = new javax.swing.JButton();
        exportImageButton = new javax.swing.JButton();
        exportTextButton = new javax.swing.JButton();
        importPaletteButton = new javax.swing.JButton();
        exportPaletteButton = new javax.swing.JButton();
        resetPaletteButton = new javax.swing.JButton();
        invertPaletteButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        importMenuItem = new javax.swing.JMenuItem();
        exportImageMenuItem = new javax.swing.JMenuItem();
        exportTextMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        paletteMenu = new javax.swing.JMenu();
        importPaletteMenuItem = new javax.swing.JMenuItem();
        exportPaletteMenuItem = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        invertPaletteMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        resetPaletteMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        refreshMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setName("MainWindowFrame"); // NOI18N
        setSize(new java.awt.Dimension(700, 500));

        mainSplitter.setDividerLocation(700);
        mainSplitter.setResizeWeight(1.0);
        mainSplitter.setDoubleBuffered(true);

        settingsImageSplitter.setDividerLocation(105);
        settingsImageSplitter.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        currentPaletteContainer.setMinimumSize(new java.awt.Dimension(550, 55));
        currentPaletteContainer.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 180;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        currentPaletteContainer.add(currentPalette, gridBagConstraints);

        settingsImageSplitter.setLeftComponent(currentPaletteContainer);

        beforeAfterSplitter.setDividerLocation(350);
        beforeAfterSplitter.setResizeWeight(0.5);

        originalImageView.setToolTipText("");
        originalImageView.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        beforeAfterSplitter.setLeftComponent(originalImageView);

        renderedImageView.setToolTipText("");
        renderedImageView.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        beforeAfterSplitter.setRightComponent(renderedImageView);

        settingsImageSplitter.setRightComponent(beforeAfterSplitter);

        mainSplitter.setLeftComponent(settingsImageSplitter);

        sidebarScroll.setBorder(null);
        sidebarScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sidebarScroll.setMinimumSize(new java.awt.Dimension(120, 5));

        sidebarPanel.setMinimumSize(new java.awt.Dimension(120, 300));
        java.awt.GridBagLayout sidebarPanelLayout = new java.awt.GridBagLayout();
        sidebarPanelLayout.columnWeights = new double[] {1.0};
        sidebarPanelLayout.rowWeights = new double[] {-1.0, -1.0, -1.0};
        sidebarPanel.setLayout(sidebarPanelLayout);

        framesPanel.setLayout(new java.awt.BorderLayout());

        jLabel6.setText("Frames:");
        framesPanel.add(jLabel6, java.awt.BorderLayout.WEST);

        frameCountLabel.setText("0");
        framesPanel.add(frameCountLabel, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        sidebarPanel.add(framesPanel, gridBagConstraints);

        widthPanel.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("Width:");
        widthPanel.add(jLabel3, java.awt.BorderLayout.WEST);

        widthLabel.setText("0 px");
        widthPanel.add(widthLabel, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        sidebarPanel.add(widthPanel, gridBagConstraints);

        heightPanel.setLayout(new java.awt.BorderLayout());

        jLabel5.setText("Height:");
        heightPanel.add(jLabel5, java.awt.BorderLayout.WEST);

        heightLabel.setText("0 px");
        heightPanel.add(heightLabel, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        sidebarPanel.add(heightPanel, gridBagConstraints);

        currentFramePanel.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Current Frame:");
        currentFramePanel.add(jLabel1, java.awt.BorderLayout.WEST);
        jLabel1.getAccessibleContext().setAccessibleName("Sample Size (%):");

        frameSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 0, 1));
        frameSpinner.setEnabled(false);
        frameSpinner.setMinimumSize(new java.awt.Dimension(40, 26));
        frameSpinner.setPreferredSize(new java.awt.Dimension(50, 26));
        currentFramePanel.add(frameSpinner, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        sidebarPanel.add(currentFramePanel, gridBagConstraints);

        sampleRatioPanel.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Sample Ratio:");
        sampleRatioPanel.add(jLabel2, java.awt.BorderLayout.WEST);

        sampleRatioSpinner.setModel(new javax.swing.SpinnerNumberModel(10.0d, 1.0d, 100.0d, 1.0d));
        sampleRatioSpinner.setEnabled(false);
        sampleRatioSpinner.setMinimumSize(new java.awt.Dimension(40, 26));
        sampleRatioSpinner.setPreferredSize(new java.awt.Dimension(50, 26));
        sampleRatioPanel.add(sampleRatioSpinner, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        sidebarPanel.add(sampleRatioPanel, gridBagConstraints);

        sampleWidthPanel.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("Sample Width:");
        sampleWidthPanel.add(jLabel4, java.awt.BorderLayout.WEST);

        sampleWidthLabel.setText("0 px");
        sampleWidthPanel.add(sampleWidthLabel, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        sidebarPanel.add(sampleWidthPanel, gridBagConstraints);

        sampleHeightPanel.setLayout(new java.awt.BorderLayout());

        jLabel7.setText("Sample Height:");
        sampleHeightPanel.add(jLabel7, java.awt.BorderLayout.WEST);

        sampleHeightLabel.setText("0 px");
        sampleHeightPanel.add(sampleHeightLabel, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        sidebarPanel.add(sampleHeightPanel, gridBagConstraints);

        renderWidthPanel.setLayout(new java.awt.BorderLayout());

        jLabel9.setText("Render Width:");
        renderWidthPanel.add(jLabel9, java.awt.BorderLayout.WEST);

        renderWidthLabel.setText("0 px");
        renderWidthPanel.add(renderWidthLabel, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        sidebarPanel.add(renderWidthPanel, gridBagConstraints);

        renderHeightPanel.setLayout(new java.awt.BorderLayout());

        jLabel8.setText("Render Height:");
        renderHeightPanel.add(jLabel8, java.awt.BorderLayout.WEST);

        renderHeightLabel.setText("0 px");
        renderHeightPanel.add(renderHeightLabel, java.awt.BorderLayout.EAST);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        sidebarPanel.add(renderHeightPanel, gridBagConstraints);

        progressPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Render Progress", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        progressPanel.setLayout(new java.awt.GridBagLayout());

        progressPanel1.setPreferredSize(new java.awt.Dimension(14, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        progressPanel.add(progressPanel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        sidebarPanel.add(progressPanel, gridBagConstraints);

        sidebarScroll.setViewportView(sidebarPanel);

        mainSplitter.setRightComponent(sidebarScroll);

        mainToolbar.setRollover(true);

        importButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asciiicons/document-open.png"))); // NOI18N
        importButton.setText("Import");
        importButton.setFocusable(false);
        importButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        importButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });
        mainToolbar.add(importButton);

        exportImageButton.setIcon(new javax.swing.ImageIcon("/Users/ianmartinez/GitHub/taiga-icons/png/32/filetype-image.png")); // NOI18N
        exportImageButton.setText("Export Image");
        exportImageButton.setEnabled(false);
        exportImageButton.setFocusable(false);
        exportImageButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exportImageButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        exportImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportImageButtonActionPerformed(evt);
            }
        });
        mainToolbar.add(exportImageButton);

        exportTextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asciiicons/filetype-text.png"))); // NOI18N
        exportTextButton.setText("Export Text");
        exportTextButton.setEnabled(false);
        exportTextButton.setFocusable(false);
        exportTextButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exportTextButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        exportTextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportTextButtonActionPerformed(evt);
            }
        });
        mainToolbar.add(exportTextButton);

        importPaletteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asciiicons/document-import.png"))); // NOI18N
        importPaletteButton.setText("Import Palette");
        importPaletteButton.setFocusable(false);
        importPaletteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        importPaletteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        importPaletteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importPaletteButtonActionPerformed(evt);
            }
        });
        mainToolbar.add(importPaletteButton);

        exportPaletteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asciiicons/document-export.png"))); // NOI18N
        exportPaletteButton.setText("Export Palette");
        exportPaletteButton.setFocusable(false);
        exportPaletteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exportPaletteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        exportPaletteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportPaletteButtonActionPerformed(evt);
            }
        });
        mainToolbar.add(exportPaletteButton);

        resetPaletteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asciiicons/edit-clear.png"))); // NOI18N
        resetPaletteButton.setText("Reset Palette");
        resetPaletteButton.setFocusable(false);
        resetPaletteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        resetPaletteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        resetPaletteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetPaletteButtonActionPerformed(evt);
            }
        });
        mainToolbar.add(resetPaletteButton);

        invertPaletteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asciiicons/inverse.png"))); // NOI18N
        invertPaletteButton.setText("Invert Palette");
        invertPaletteButton.setFocusable(false);
        invertPaletteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        invertPaletteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        invertPaletteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertPaletteButtonActionPerformed(evt);
            }
        });
        mainToolbar.add(invertPaletteButton);

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asciiicons/refresh.png"))); // NOI18N
        refreshButton.setText("Refresh");
        refreshButton.setEnabled(false);
        refreshButton.setFocusable(false);
        refreshButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        refreshButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        mainToolbar.add(refreshButton);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        importMenuItem.setMnemonic('o');
        importMenuItem.setText("Import...");
        importMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(importMenuItem);

        exportImageMenuItem.setMnemonic('s');
        exportImageMenuItem.setText("Export Image...");
        exportImageMenuItem.setEnabled(false);
        exportImageMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportImageMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exportImageMenuItem);

        exportTextMenuItem.setMnemonic('a');
        exportTextMenuItem.setText("Export Text...");
        exportTextMenuItem.setEnabled(false);
        exportTextMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportTextMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exportTextMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        paletteMenu.setText("Palette");

        importPaletteMenuItem.setText("Import Palette");
        importPaletteMenuItem.setToolTipText("");
        importPaletteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importPaletteMenuItemActionPerformed(evt);
            }
        });
        paletteMenu.add(importPaletteMenuItem);

        exportPaletteMenuItem.setText("Export Palette");
        exportPaletteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportPaletteMenuItemActionPerformed(evt);
            }
        });
        paletteMenu.add(exportPaletteMenuItem);
        paletteMenu.add(jSeparator4);

        invertPaletteMenuItem.setText("Invert Palette");
        invertPaletteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertPaletteMenuItemActionPerformed(evt);
            }
        });
        paletteMenu.add(invertPaletteMenuItem);
        paletteMenu.add(jSeparator1);

        resetPaletteMenuItem.setText("Reset Palette");
        resetPaletteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetPaletteMenuItemActionPerformed(evt);
            }
        });
        paletteMenu.add(resetPaletteMenuItem);

        menuBar.add(paletteMenu);

        jMenu1.setText("Preview");

        refreshMenuItem.setText("Refresh");
        refreshMenuItem.setEnabled(false);
        refreshMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(refreshMenuItem);

        menuBar.add(jMenu1);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainSplitter, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE)
            .addComponent(mainToolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(mainToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainSplitter, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        var aboutDialog = new AboutDialog(this, true);
        aboutDialog.setLocationRelativeTo(this);
        aboutDialog.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importButtonActionPerformed
        importMenuItemActionPerformed(evt);
    }//GEN-LAST:event_importButtonActionPerformed

    private void importMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importMenuItemActionPerformed
        if (importImageDialog.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            var importedPath = importImageDialog.getSelectedFile().getAbsolutePath();

            try {
                var importingGif = getExt(importedPath).equals("gif");

                if (importingGif) { // GIF
                    var importedGif = new Gif(importedPath);
                    var importedCurrentFrame = importedGif.getFrameImage(0);

                    // All importing succeeded, so update data
                    sourceImagePath = importedPath;
                    isGif = true;
                    sourceGif = importedGif;
                    sourceCurrentFrame = importedCurrentFrame;

                    // Set frame spinner
                    var model = new SpinnerNumberModel(0, 0, sourceGif.getFrameCount() - 1, 1);
                    frameSpinner.setModel(model);

                    // Set the export image dialog to export GIFs by default
                    exportImageDialog.setFileFilter(gifImageFilter);
                } else { // Still image
                    var importedImage = ImageIO.read(new File(importedPath));

                    // All importing succeeded, so update data
                    sourceImagePath = importedPath;
                    isGif = false;
                    sourceGif = null;
                    sourceCurrentFrame = importedImage;

                    // Set frame spinner
                    var model = new SpinnerNumberModel(0, 0, 0, 1);
                    frameSpinner.setModel(model);

                    // Set the export image dialog to export PNG by default
                    exportImageDialog.setFileFilter(pngImageFilter);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error importing " + importedPath);
            }

            enableEditing(true);

            // Update UI
            originalImageView.setIcon(new StretchIcon(sourceCurrentFrame));
            frameCountLabel.setText(String.valueOf(isGif ? sourceGif.getFrameCount() : 1));
            widthLabel.setText(sourceCurrentFrame.getWidth() + "px");
            heightLabel.setText(sourceCurrentFrame.getHeight() + "px");

            // Set sampling image            
            samplingParams = currentPalette.getPalette().getSamplingParams(sourceCurrentFrame.getWidth(), sourceCurrentFrame.getHeight());
            sampleRatioSpinner.setValue(samplingParams.getSamplingRatio());

            // Render image and put it in the preview
            refreshPreview();
        }
    }//GEN-LAST:event_importMenuItemActionPerformed

    private void refreshMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshMenuItemActionPerformed
        refreshPreview();
    }//GEN-LAST:event_refreshMenuItemActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        refreshMenuItemActionPerformed(evt);
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void resetPaletteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetPaletteMenuItemActionPerformed
        currentPalette.resetPalette();
    }//GEN-LAST:event_resetPaletteMenuItemActionPerformed

    private void importPaletteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importPaletteButtonActionPerformed
        importPaletteMenuItemActionPerformed(evt);
    }//GEN-LAST:event_importPaletteButtonActionPerformed

    private void exportPaletteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportPaletteButtonActionPerformed
        exportPaletteMenuItemActionPerformed(evt);
    }//GEN-LAST:event_exportPaletteButtonActionPerformed

    private void resetPaletteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetPaletteButtonActionPerformed
        resetPaletteMenuItemActionPerformed(evt);
    }//GEN-LAST:event_resetPaletteButtonActionPerformed

    private void invertPaletteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertPaletteButtonActionPerformed
        invertPaletteMenuItemActionPerformed(evt);
    }//GEN-LAST:event_invertPaletteButtonActionPerformed

    private void importPaletteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importPaletteMenuItemActionPerformed
        try {
            if (importPaletteDialog.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                var filePath = importPaletteDialog.getSelectedFile().getAbsolutePath();
                var importedPalette = Palette.importXml(filePath);
                
                if(importedPalette != null) {
                    currentPalette.setPalette(importedPalette);
                } else {
                    throw new Exception("Invalid file");
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error importing " + importPaletteDialog.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_importPaletteMenuItemActionPerformed

    private void exportPaletteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportPaletteMenuItemActionPerformed
        try {
            if (exportPaletteDialog.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                var outputPath = exportPaletteDialog.getSelectedFile().getAbsolutePath();

                // Add extension if it was not given
                if (!outputPath.contains(".")) {
                    var filter = (FileNameExtensionFilter) exportPaletteDialog.getFileFilter();

                    if (filter != null) {
                        outputPath += "." + filter.getExtensions()[0];
                    }
                }

                currentPalette.getPalette().exportXml(outputPath);
            }
        } catch (HeadlessException | JAXBException ex) {
            JOptionPane.showMessageDialog(this, "Error exporting " + exportPaletteDialog.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_exportPaletteMenuItemActionPerformed

    private void invertPaletteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertPaletteMenuItemActionPerformed
        currentPalette.invertPalette();
    }//GEN-LAST:event_invertPaletteMenuItemActionPerformed

    private void exportTextMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportTextMenuItemActionPerformed
        try {
            var currentDirectory = exportTextDialog.getCurrentDirectory();

            if (!exportDirectoryChanged) {
                exportTextDialog.setCurrentDirectory(new File(sourceImagePath));
            }

            if (!sourceImagePath.equals("")) {
                exportTextDialog.setSelectedFile(new File(removeExt(sourceImagePath) + " ASCII.txt"));
            }

            if (exportTextDialog.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                refreshSampleParams();
                var converter = new AsciiConverter(currentPalette.getPalette(), samplingParams);
                var renderedText = converter.renderText(sourceCurrentFrame);
                var outputPath = exportTextDialog.getSelectedFile().getAbsolutePath();

                // Add extension if it was not given
                if (!outputPath.contains(".")) {
                    var filter = (FileNameExtensionFilter) exportTextDialog.getFileFilter();

                    if (filter != null) {
                        outputPath += "." + filter.getExtensions()[0];
                    }
                }

                try (var out = new PrintWriter(outputPath)) {
                    out.println(renderedText);
                }

                openProcess(outputPath);
                exportDirectoryChanged = !exportTextDialog.getCurrentDirectory().equals(currentDirectory);
            }

        } catch (HeadlessException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error exporting " + exportTextDialog.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_exportTextMenuItemActionPerformed

    private void exportTextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportTextButtonActionPerformed
        exportTextMenuItemActionPerformed(evt);
    }//GEN-LAST:event_exportTextButtonActionPerformed

    private void exportImageMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportImageMenuItemActionPerformed
        try {
            var currentDirectory = exportImageDialog.getCurrentDirectory();

            if (!exportDirectoryChanged) {
                exportImageDialog.setCurrentDirectory(new File(sourceImagePath));
            }

            if (!sourceImagePath.equals("")) {
                exportImageDialog.setSelectedFile(new File(removeExt(sourceImagePath) + " ASCII"));
            }

            if (exportImageDialog.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                refreshSampleParams();
                var converter = new AsciiConverter(currentPalette.getPalette(), samplingParams);
                var outputPath = exportImageDialog.getSelectedFile().getAbsolutePath();

                // Add extension if it was not given
                if (!outputPath.contains(".")) {
                    var filter = (FileNameExtensionFilter) exportImageDialog.getFileFilter();                    
                    if (filter != null) {
                        outputPath += "." + filter.getExtensions()[0];
                    }
                }

                var ext = getExt(outputPath);
                if (isGif && ext.equals("gif")) { // Animated GIF                    
                    converter.saveGif(outputPath, sourceGif);
                } else { // Still image
                    refreshRender();
                    ImageIO.write(renderedCurrentFrame, ext, new File(outputPath));
                }

                exportDirectoryChanged = !exportImageDialog.getCurrentDirectory().equals(currentDirectory);
                openProcess(outputPath);
            }
        } catch (HeadlessException | IOException ex) {
            JOptionPane.showMessageDialog(this, "Error exporting " + exportImageDialog.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_exportImageMenuItemActionPerformed

    private void exportImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportImageButtonActionPerformed
        exportImageMenuItemActionPerformed(evt);
    }//GEN-LAST:event_exportImageButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JMenuItem aboutMenuItem;
    protected javax.swing.JSplitPane beforeAfterSplitter;
    protected javax.swing.JPanel currentFramePanel;
    protected asciicomponent.PalettePanel currentPalette;
    protected javax.swing.JPanel currentPaletteContainer;
    protected javax.swing.JMenuItem exitMenuItem;
    protected javax.swing.JButton exportImageButton;
    protected javax.swing.JMenuItem exportImageMenuItem;
    protected javax.swing.JButton exportPaletteButton;
    protected javax.swing.JMenuItem exportPaletteMenuItem;
    protected javax.swing.JButton exportTextButton;
    protected javax.swing.JMenuItem exportTextMenuItem;
    protected javax.swing.JMenu fileMenu;
    protected javax.swing.JLabel frameCountLabel;
    protected javax.swing.JSpinner frameSpinner;
    protected javax.swing.JPanel framesPanel;
    protected javax.swing.JLabel heightLabel;
    protected javax.swing.JPanel heightPanel;
    protected javax.swing.JMenu helpMenu;
    protected javax.swing.JButton importButton;
    protected javax.swing.JMenuItem importMenuItem;
    protected javax.swing.JButton importPaletteButton;
    protected javax.swing.JMenuItem importPaletteMenuItem;
    protected javax.swing.JButton invertPaletteButton;
    protected javax.swing.JMenuItem invertPaletteMenuItem;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel2;
    protected javax.swing.JLabel jLabel3;
    protected javax.swing.JLabel jLabel4;
    protected javax.swing.JLabel jLabel5;
    protected javax.swing.JLabel jLabel6;
    protected javax.swing.JLabel jLabel7;
    protected javax.swing.JLabel jLabel8;
    protected javax.swing.JLabel jLabel9;
    protected javax.swing.JMenu jMenu1;
    protected javax.swing.JPopupMenu.Separator jSeparator1;
    protected javax.swing.JPopupMenu.Separator jSeparator4;
    protected javax.swing.JSplitPane mainSplitter;
    protected javax.swing.JToolBar mainToolbar;
    protected javax.swing.JMenuBar menuBar;
    protected javax.swing.JLabel originalImageView;
    protected javax.swing.JMenu paletteMenu;
    protected javax.swing.JPanel progressPanel;
    protected asciicomponent.ProgressPanel progressPanel1;
    protected javax.swing.JButton refreshButton;
    protected javax.swing.JMenuItem refreshMenuItem;
    protected javax.swing.JLabel renderHeightLabel;
    protected javax.swing.JPanel renderHeightPanel;
    protected javax.swing.JLabel renderWidthLabel;
    protected javax.swing.JPanel renderWidthPanel;
    protected javax.swing.JLabel renderedImageView;
    protected javax.swing.JButton resetPaletteButton;
    protected javax.swing.JMenuItem resetPaletteMenuItem;
    protected javax.swing.JLabel sampleHeightLabel;
    protected javax.swing.JPanel sampleHeightPanel;
    protected javax.swing.JPanel sampleRatioPanel;
    protected javax.swing.JSpinner sampleRatioSpinner;
    protected javax.swing.JLabel sampleWidthLabel;
    protected javax.swing.JPanel sampleWidthPanel;
    protected javax.swing.JSplitPane settingsImageSplitter;
    protected javax.swing.JPanel sidebarPanel;
    protected javax.swing.JScrollPane sidebarScroll;
    protected javax.swing.JLabel widthLabel;
    protected javax.swing.JPanel widthPanel;
    // End of variables declaration//GEN-END:variables
}


class PreviewRenderer extends SwingWorker<Void, Integer> {
        ProgressPanel progressPanel;
        
        public PreviewRenderer(ProgressPanel progressPanel) {
            this.progressPanel = progressPanel;
        }

        @Override
        protected void process(List<Integer> chunks) {
            int i = chunks.get(chunks.size()-1);
            progressPanel.setProgress(i); 
        }

        @Override
        protected Void doInBackground() throws Exception {
            
            return null;
        }

        @Override
        protected void done() {
            try {
                get();
                progressPanel.setProgress(100);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    
}