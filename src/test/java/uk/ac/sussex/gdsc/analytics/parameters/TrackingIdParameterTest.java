/*-
 * #%L
 * Genome Damage and Stability Centre Analytics Package
 *
 * The GDSC Analytics package contains code to use the Google Analytics
 * Measurement protocol to collect usage information about a Java application.
 * %%
 * Copyright (C) 2010 - 2018 Alex Herbert
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

package uk.ac.sussex.gdsc.analytics.parameters;

import uk.ac.sussex.gdsc.analytics.TestUtils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@SuppressWarnings("javadoc")
public class TrackingIdParameterTest {
  @SuppressWarnings("unused")
  @Test
  public void testConstructor() {
    Assertions.assertThrows(NullPointerException.class, () -> {
      new TrackingIdParameter(null);
    });
    for (String trackingId : new String[] {" UA-1234-6", "", "hgkh", "12345", "ABC"}) {
      Assertions.assertThrows(NullPointerException.class, () -> {
        new TrackingIdParameter(null);
      });
    }
  }

  @Test
  public void testFormat() {
    for (String trackingId : new String[] {"UA-1234-6", "UA-123456789-6"}) {
      Assertions.assertEquals(String.format("&tid=%s", trackingId),
          TestUtils.callFormatTo(new TrackingIdParameter(trackingId)));
    }
  }
}
