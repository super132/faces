/**
 * Copyright (c) 2016 Jsoft Company
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 * BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.jsoft.faces.features;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;

/**
 * Image pixel in grayscale (intensity).
 *
 * @author Jason Wong (super132j@yahoo.com)
 * @version $Id$
 * @since 0.1
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
     * Obtain the intensity of the given point.
     * @param horiz The X coordinate.
     * @param vert The Y coordinate.
     * @return The image intensity value.
     */
    public int value(final int horiz, final int vert) {
        final int position = vert * this.width + horiz;
        // @checkstyle MagicNumberCheck (4 line)
        final int red = this.raw.getElem(position) >> 16 & Pixels.MASK;
        final int green = this.raw.getElem(position) >> 8 & Pixels.MASK;
        final int blue = this.raw.getElem(position) & Pixels.MASK;
        return (red + green + blue) / 3;
    }
}
