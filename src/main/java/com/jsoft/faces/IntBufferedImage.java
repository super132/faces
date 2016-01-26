package com.jsoft.faces;

import java.awt.image.BufferedImage;

/**
 * Integral image.
 *
 * @author Jason Wong (super132j@yahoo.com)
 * @version: $id
 *
 */
public final class IntBufferedImage implements IntegralImg {

    /**
     * The width of this integral image.
     */
    private final transient int width;

    /**
     * The height of this integral image.
     */
    private final transient int height;

    /**
     * Internal record storage.
     */
    private final transient long[][] data;

    /**
     * The pixels intensity of the original image.
     */
    private final transient Pixels pixels;

    /**
     * Ctor.
     */
    public IntBufferedImage(final BufferedImage img) {
        this.width = img.getWidth();
        this.height = img.getHeight();
        this.data = new long[this.width][this.height];
        this.pixels = new Pixels(img);
        IntBufferedImage.initArray(this.data, -1);
        this.data[0][0] = this.pixels.value(0, 0);
    }

    @Override
    public int width() {
        return this.width;
    }

    @Override
    public int height() {
        return this.height;
    }

    @Override
    public long values(final int horiz, final int vert) {
        final long result;
        if (horiz < 0 || vert < 0) {
            result = 0;
        } else if (this.data[horiz][vert] != -1) {
            result = this.data[horiz][vert];
        } else {
            result = this.pixels.value(horiz, vert)
                - this.values(horiz - 1, vert - 1)
                + this.values(horiz, vert - 1)
                + this.values(horiz - 1, vert);
            this.data[horiz][vert] = result;
        }
        return result;
    }

    @Override
    public long values(final int top, final int left, final int right,
        final int bottom) {
        return this.values(right, bottom) - this.values(right, top - 1)
            - this.values(left - 1, bottom) + this.values(left - 1, top - 1);
    }

    /**
     * Initialize a 2D long array with default value.
     * @param array Array
     * @param value Default value.
     */
    private static void initArray(final long[][] array, final long value) {
        for (int first = 0; first < array.length; ++first) {
            for (int second = 0; second < array[first].length; ++second) {
                array[first][second] = value;
            }
        }
    }
}
