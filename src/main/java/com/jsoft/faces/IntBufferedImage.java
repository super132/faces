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
package com.jsoft.faces;

import com.jcabi.aspects.Immutable;
import java.awt.image.BufferedImage;

/**
 * Integral image.
 *
 * @author Jason Wong (super132j@yahoo.com)
 * @version $Id$
 * @since 0.1
 */
@Immutable
public final class IntBufferedImage implements IntegralImg {

    /**
     * The width of this integral image.
     */
    private final transient int wdth;

    /**
     * The height of this integral image.
     */
    private final transient int tall;

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
     * @param img The image
     */
    @SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
    public IntBufferedImage(final BufferedImage img) {
        this.wdth = img.getWidth();
        this.tall = img.getHeight();
        this.data = new long[this.wdth][this.tall];
        this.pixels = new Pixels(img);
        IntBufferedImage.initArray(this.data, -1);
        this.data[0][0] = this.pixels.value(0, 0);
    }

    @Override
    public int width() {
        return this.wdth;
    }

    @Override
    public int height() {
        return this.tall;
    }

    @Override
    public long values(final int horiz, final int vert) {
        final long result;
        if (horiz < 0 || vert < 0) {
            result = 0;
        } else if (this.data[horiz][vert] == -1) {
            result = this.pixels.value(horiz, vert)
                - this.values(horiz - 1, vert - 1)
                + this.values(horiz, vert - 1)
                + this.values(horiz - 1, vert);
            this.data[horiz][vert] = result;
        } else {
            result = this.data[horiz][vert];
        }
        return result;
    }

    // @checkstyle ParameterNumberCheck (3 lines)
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
