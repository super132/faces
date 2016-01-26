package com.jsoft.faces;

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
 * @version: $id
 *
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
