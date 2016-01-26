package com.jsoft.faces;

import com.jcabi.aspects.Tv;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link Pixels}.
 *
 * @author Jason Wong (super132j@yahoo.com)
 * @version: $id
 *
 */
public final class PixelsTest {

    /**
     * Pixels can calculate intensity from an image.
     */
    @Test
    public void calculatesIntensityFromImage() {
        final BufferedImage img = new BufferedImage(
            Tv.HUNDRED, Tv.THOUSAND, BufferedImage.TYPE_INT_ARGB
        );
        final Graphics2D graphic = img.createGraphics();
        graphic.setColor(new Color(Tv.TEN, Tv.TWENTY, Tv.HUNDRED));
        graphic.fillRect(0, 0, 1, 1);
        graphic.dispose();
        final Pixels pixels = new Pixels(img);
        MatcherAssert.assertThat(pixels.value(0, 0), Matchers.is(43));
    }
}
