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
class HitTypeTest {
  @Test
  void testToString() {
    int count = 0;
    Assertions.assertEquals("event", HitType.EVENT.toString());
    count++;
    Assertions.assertEquals("exception", HitType.EXCEPTION.toString());
    count++;
    Assertions.assertEquals("item", HitType.ITEM.toString());
    count++;
    Assertions.assertEquals("pageview", HitType.PAGEVIEW.toString());
    count++;
    Assertions.assertEquals("screenview", HitType.SCREENVIEW.toString());
    count++;
    Assertions.assertEquals("social", HitType.SOCIAL.toString());
    count++;
    Assertions.assertEquals("timing", HitType.TIMING.toString());
    count++;
    Assertions.assertEquals("transaction", HitType.TRANSACTION.toString());
    count++;
    // Make sure we cover all the values
    Assertions.assertEquals(HitType.values().length, count);
  }
}
