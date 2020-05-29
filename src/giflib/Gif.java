/**
 * Gif.java:
 * Handles the loading and saving of GIF files.
 *
 * ---
 *
 * Created by Elliot Kroo, April 25, 2009
 * Modified by Ian Martinez, May 2020
 *
 * This work is licensed under the Creative Commons Attribution 3.0 Unported
 * License. To view a copy of this license, visit
 * http://creativecommons.org/licenses/by/3.0/ or send a letter to Creative
 * Commons, 171 Second Street, Suite 300, San Francisco, California, 94105, USA.
 *
 * ---
 *
 * April 2009 (Elliot Kroo):
 *  - Initial Release
 *
 * May 2020 (Ian Martinez):
 *  - Update with newer Java constructs
 *  - Add JavaDocs
 *  - Simplified function and variable names
 *  - GifSequenceWriter implements AutoCloseable so it can be used with try-with-resources
 *  - Customizable program name in comments
 *  - Let IO errors be handled by user of library, not the library itself
 *  - Use GifFrame for storing frames instead of BufferedImage array
 *  - Change delay of GIF
 */
package giflib;

import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.stream.*;
import java.awt.Dimension;
import static giflib.GifSequenceWriter.getFrames;
import static java.awt.image.BufferedImage.*;
import java.util.ArrayList;

public final class Gif {

    private GifFrame[] frames;
    private int averageDelay = -1; // Don't calculate until needed
    private GifSaveProgressWatcher saveProgressWatcher;

    public Gif(BufferedImage[] images, int delay) {
        frames = new GifFrame[images.length];

        for (int i = 0; i < frames.length; i++) {
            frames[i] = new GifFrame(images[i], delay, "");
        }
    }

    public Gif(String filename) {
        open(filename);
    }

    /**
     * Create a new GIF with the same frame count and delay as another GIF
     *
     * @param gif The GIF to base the frame and delay from
     */
    public Gif(Gif gif) {
        this(new BufferedImage[gif.getFrameCount()], gif.getDelay());

        // Init empty frames
        var maxSize = maxSize(gif.getImages());
        for (GifFrame frame : frames) {
            frame.setImage(new BufferedImage(maxSize.width, maxSize.height, TYPE_INT_ARGB));
        }
    }

    private Dimension maxSize(BufferedImage[] images) {
        int maxW = 0;
        int maxH = 0;

        for (var image : images) {
            maxW = Math.max(maxW, image.getWidth());
            maxH = Math.max(maxH, image.getHeight());
        }

        return new Dimension(maxW, maxH);
    }

    public void open(String fileName) {
        frames = getFrames(fileName);
    }

    public void save(String fileName) throws IOException {
        try (var output = new FileImageOutputStream(new File(fileName));
                var writer = new GifSequenceWriter(output, frames[0].getImageType(), getDelay(), true)) {

            for (int i = 0; i < frames.length; i++) {
                var frame = frames[i];
                writer.writeToSequence(frame);

                if (saveProgressWatcher != null) {
                    saveProgressWatcher.update(i, frames.length);
                }
            }
        }
    }

    public int getFrameCount() {
        return frames.length;
    }

    public GifFrame getFrame(int pos) {
        return frames[pos];
    }

    public void setFrame(int pos, GifFrame frame) {
        frames[pos] = frame;
    }

    public BufferedImage getFrameImage(int pos) {
        return getFrame(pos).getImage();
    }

    public void setFrameImage(int pos, BufferedImage img) {
        frames[pos].setImage(img);
    }

    public int getFrameDelay(int pos) {
        return frames[pos].getDelay();
    }

    public void setFrameDelay(int pos, int delay) {
        frames[pos].setDelay(delay);
    }

    public void setAllFramesDelay(int delay) {
        for (var frame : frames) {
            frame.setDelay(delay);
        }
    }

    public int getDelay() {
        if (averageDelay == -1) { // Not calculated
            int total = 0;

            for (GifFrame frame : frames) {
                total += frame.getDelay();
            }

            averageDelay = total / frames.length;
        }

        return averageDelay;
    }

    public BufferedImage[] getImages() {
        var images = new ArrayList<BufferedImage>();

        for (var frame : frames) {
            images.add(frame.getImage());
        }

        return images.toArray(new BufferedImage[images.size()]);
    }

    /**
     * @return the saveProgressWatcher
     */
    public GifSaveProgressWatcher getSaveProgressWatcher() {
        return saveProgressWatcher;
    }

    /**
     * @param saveProgressWatcher the saveProgressWatcher to set
     */
    public void setSaveProgressWatcher(GifSaveProgressWatcher saveProgressWatcher) {
        this.saveProgressWatcher = saveProgressWatcher;
    }
}
