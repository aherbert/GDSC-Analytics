/*-
 * #%L
 * Genome Damage and Stability Centre Analytics Package
 *
 * The GDSC Analytics package contains code to use the Google Analytics
 * Measurement protocol to collect usage information from a Java application.
 * %%
 * Copyright (C) 2016 - 2020 Alex Herbert
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

package uk.ac.sussex.gdsc.analytics.parameters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@SuppressWarnings("javadoc")
class ProductActionParameterTest {
  @Test
  void testToString() {
    int count = 0;
    Assertions.assertEquals("pa=add", ProductActionParameter.ADD.format());
    count++;
    Assertions.assertEquals("pa=checkout", ProductActionParameter.CHECKOUT.format());
    count++;
    Assertions.assertEquals("pa=checkout_option", ProductActionParameter.CHECKOUT_OPTION.format());
    count++;
    Assertions.assertEquals("pa=click", ProductActionParameter.CLICK.format());
    count++;
    Assertions.assertEquals("pa=detail", ProductActionParameter.DETAIL.format());
    count++;
    Assertions.assertEquals("pa=purchase", ProductActionParameter.PURCHASE.format());
    count++;
    Assertions.assertEquals("pa=refund", ProductActionParameter.REFUND.format());
    count++;
    Assertions.assertEquals("pa=remove", ProductActionParameter.REMOVE.format());
    count++;
    // Make sure we cover all the values
    Assertions.assertEquals(ProductAction.values().length, count);
  }

  @Test
  void testCreate() {
    for (final ProductAction pa : ProductAction.values()) {
      Assertions
          .assertTrue(ProductActionParameter.create(pa).format().endsWith("=" + pa.toString()));
    }
    Assertions.assertThrows(NullPointerException.class, () -> {
      ProductActionParameter.create(null);
    });
  }
}
