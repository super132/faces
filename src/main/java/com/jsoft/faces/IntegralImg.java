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

/**
 * The integral image represents the sum of pixels of the original image.
 *
 * @author Jason Wong (super132j@yahoo.com)
 * @version $Id$
 * @since 0.1
 */
public interface IntegralImg {

    /**
     * The width of the integral image in pixels.
     * @return The width.
     */
    int width();

    /**
     * The height of the integral image in pixels.
     * @return The height.
     */
    int height();

    /**
     * Return the sum of the pixels of the original image of the point with the
     * specified coordinates being the right bottom corner of the point.
     *
     * @param horiz The X coordinate.
     * @param vert The Y coordinate.
     * @return The sum of the pixels in the original image.
     */
    long values(final int horiz, final int vert);

    /**
     * Return the sum of the pixels of the original image of the specified
     * area.
     * @param top Top Y coordinate
     * @param left Left X coordinate
     * @param right Right X coordinate
     * @param bottom Bottom Y coordinate
     * @return The sum of the pixels of the specified area.
     * @checkstyle ParameterNumberCheck (3 lines)
     */
    long values(final int top, final int left, final int right,
        final int bottom);
}
