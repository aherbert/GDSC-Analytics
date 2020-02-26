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

package uk.ac.sussex.gdsc.analytics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class exists to determine what happens when there is no Internet connection. This can be
 * simulated by disconnecting the host (e.g. turn WiFi off; disconnect LAN; etc.) then running the
 * test manually.
 */
@SuppressWarnings("javadoc")
public class BackgroundThreadFactoryTest {

  @SuppressWarnings("unused")
  @Test
  public void testConstructor() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      new BackgroundThreadFactory(Thread.MIN_PRIORITY - 1);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      new BackgroundThreadFactory(Thread.MAX_PRIORITY + 1);
    });
  }

  @Test
  public void testNewThread() {
    final Runnable runnable = new Runnable() {
      @Override
      public void run() {
        // Do nothing
      }
    };
    for (int p = Thread.MIN_PRIORITY; p <= Thread.MAX_PRIORITY; p++) {
      final Thread thread = new BackgroundThreadFactory(p).newThread(runnable);
      Assertions.assertEquals(p, thread.getPriority());
      Assertions.assertTrue(thread.isDaemon());
    }
  }
}
