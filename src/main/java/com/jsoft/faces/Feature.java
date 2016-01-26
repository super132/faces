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
 * Feature to detect a face on an image.
 *
 * @author Jason Wong (super132j@yahoo.com)
 * @version $Id$
 * @since 0.1
 */
public interface Feature {

    /**
     * The width of this feature, in the minimum unit size.
     * @return The width in minimum unit size.
     */
    int width();

    /**
     * The height of this feature, in the minimum unit size.
     * @return The height in minimum unit size.
     */
    int height();

    /**
     * The value of this feature, either black (false) or white (true), of the
     * specified coordinate.
     * @param width The x coordinate of the feature.
     * @param height The y coordinate of the feature.
     * @return Black (false) or White (true).
     */
    boolean value(int width, int height);
}
