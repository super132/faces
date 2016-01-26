package com.jsoft.faces;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import com.jcabi.aspects.Tv;

/**
 * Image pixel in grayscale (intensity).
 *
 * @author Jason Wong (super132j@yahoo.com)
 * @version: $id
 *
 */
final class Pixels {

    /**
     * Bit mask to extract RGB.
     */
    private static final int MASK = 0xFF;

    /**
     * The width of the original image.
     */
    private final transient int width;

    /**
     * The raw pixel arrays from BufferedImage.
     */
    private final transient DataBuffer raw;

    /**
     * Ctor.
     * @param img The image.
     */
    Pixels(final BufferedImage img) {
        this.raw = img.getRaster().getDataBuffer();
        this.width = img.getWidth();
    }

    /**
     * Obtain the intensity of the given point
     * @param horiz The X coordinate.
     * @param vert The Y coordinate.
     * @return The image intensity value.
     */
    public int value(final int horiz, final int vert) {
        final int position = vert * this.width + horiz;
        final int red = this.raw.getElem(position) >> 16 & Pixels.MASK;
        final int green = this.raw.getElem(position) >> Tv.EIGHT & Pixels.MASK;
        final int blue = this.raw.getElem(position) & Pixels.MASK;
        return (red + green + blue) / Tv.THREE;
    }
}
