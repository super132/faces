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

import com.jcabi.aspects.Tv;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link IntBufferedImage}.
 *
 * @author Jason Wong (super132j@yahoo.com)
 * @version $Id$
 * @since 0.1
 */
public final class IntBufferedImageTest {

    /**
     * IntBufferdImage can return intergal value.
     */
    @Test
    public void returnsIntergalValue() {
        final int width = Tv.HUNDRED;
        final int height = Tv.THOUSAND;
        final BufferedImage img = new BufferedImage(
            width, height, BufferedImage.TYPE_INT_ARGB
        );
        final Graphics2D graphic = img.createGraphics();
        graphic.setColor(new Color(1, 1, 1));
        graphic.fillRect(0, 0, width, height);
        graphic.dispose();
        final IntBufferedImage integral = new IntBufferedImage(img);
        MatcherAssert.assertThat(
            integral.values(2, 2), Matchers.is((long) Tv.NINE)
        );
        MatcherAssert.assertThat(
            integral.values(width - 1, height - 1),
            Matchers.is((long) Tv.HUNDRED * Tv.THOUSAND)
        );
        MatcherAssert.assertThat(
            integral.values(1, 1, 2, 2),
            Matchers.is((long) Tv.FOUR)
        );
    }
}
