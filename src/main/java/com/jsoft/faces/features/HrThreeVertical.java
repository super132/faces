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

import com.jsoft.faces.Feature;
import com.jsoft.faces.FtValue;
import com.jsoft.faces.IntegralImg;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Haar-like feature with 2 white rectangles enclosed the black rectangle on a
 * vertical line for detection.
 *
 * @author Jason Wong (super132j@yahoo.com)
 * @version $Id$
 * @since 0.1
 */
public final class HrThreeVertical implements Feature {

    /**
     * The number of rectangles in this feature.
     */
    private static final int NUM = 3;

    /**
     * Integral image for calculation.
     */
    private final transient IntegralImg img;

    /**
     * Ctor.
     * @param image Integral image.
     */
    public HrThreeVertical(final IntegralImg image) {
        this.img = image;
    }

    @Override
    @SuppressWarnings("PMD.AvoidInstantiatingObjectsInLoops")
    public Iterable<FtValue> values(final int initx, final int inity,
        final int size) {
        final List<FtValue> result = new LinkedList<FtValue>();
        // @checkstyle NestedForDepthCheck (4 lines)
        for (int posx = initx; posx < size; ++posx) {
            for (int posy = inity; posy < size; ++posy) {
                for (int wid = 1; (posx + wid) <= size; ++wid) {
                    for (int tall = 1;
                        (posy + HrThreeVertical.NUM * tall) <= size;
                        ++tall
                    ) {
                        result.add(
                            new FtValue.Default(
                                posx,
                                posy,
                                wid,
                                tall,
                                this.difference(posx, posy, wid, tall)
                            )
                        );
                    }
                }
            }
        }
        return Collections.unmodifiableList(result);
    }

    /**
     * Calculate the difference between white and black area.
     * @param posx The x coordinate of the top left of feature
     * @param posy The y coordinate of the top left of feature
     * @param wid The width of feature
     * @param tall The height of feature
     * @return The integral difference
     * @checkstyle ParameterNumberCheck (2 lines)
     */
    private long difference(final int posx, final int posy,
        final int wid, final int tall) {
        return this.img.values(posy, posx, posy + tall, posx + wid)
            - this.img.values(posy + tall, posx, posy + 2 * tall, posx + wid)
            + this.img.values(
                posy + 2 * tall,
                posx,
                posy + HrThreeVertical.NUM * tall,
                posx + wid
            );
    }
}
