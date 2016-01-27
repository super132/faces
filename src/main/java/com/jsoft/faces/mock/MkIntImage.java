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
package com.jsoft.faces.mock;

import com.jsoft.faces.IntegralImg;
import com.jsoft.faces.features.IntBufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Mock Integral image with all pixel equals to one.
 *
 * <pre>This class is NOT thread-safe.</pre>
 *
 * @author Jason Wong (super132j@yahoo.com)
 * @version $Id$
 * @since 0.1
 */
public final class MkIntImage implements IntegralImg {

    /**
     * Internal integral image.
     */
    private final transient IntegralImg image;

    /**
     * Ctor.
     * @param width The width of the image.
     * @param height The height of the image.
     */
    @SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
    public MkIntImage(final int width, final int height) {
        final BufferedImage img = new BufferedImage(
            width, height, BufferedImage.TYPE_INT_ARGB
        );
        final Graphics2D graphic = img.createGraphics();
        graphic.setColor(new Color(1, 1, 1));
        graphic.fillRect(0, 0, width, height);
        graphic.dispose();
        this.image = new IntBufferedImage(img);
    }

    @Override
    public int width() {
        return this.image.width();
    }

    @Override
    public int height() {
        return this.image.height();
    }

    @Override
    public long values(final int horiz, final int vert) {
        return this.image.values(horiz, vert);
    }

    // @checkstyle ParameterNumberCheck (3 lines)
    @Override
    public long values(final int top, final int left,
        final int bottom, final int right) {
        return this.image.values(top, left, bottom, right);
    }
}
