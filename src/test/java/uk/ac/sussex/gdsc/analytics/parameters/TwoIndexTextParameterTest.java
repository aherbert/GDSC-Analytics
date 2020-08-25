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

import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uk.ac.sussex.gdsc.analytics.TestUtils;

@SuppressWarnings("javadoc")
class TwoIndexTextParameterTest {
  @SuppressWarnings("unused")
  @Test
  void testConstructor() {
    final ParameterSpecification spec = TestUtils.newTextParameterSpecification("test_test_", 0);
    final int index1 = 1;
    final int index2 = 2;
    final String value = "test";
    Assertions.assertThrows(NullPointerException.class, () -> {
      new TwoIndexTextParameter(spec, index1, index2, null);
    });
    Assertions.assertThrows(NullPointerException.class, () -> {
      new TwoIndexTextParameter((ParameterSpecification) null, index1, index2, value);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      new TwoIndexTextParameter(spec, 0, index2, value);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      new TwoIndexTextParameter(spec, index1, 0, value);
    });

    final ProtocolSpecification spec2 = ProtocolSpecification.PRODUCT_CUSTOM_DIMENSION;
    Assertions.assertThrows(NullPointerException.class, () -> {
      new TwoIndexTextParameter(spec2, index1, index2, null);
    });
    Assertions.assertThrows(NullPointerException.class, () -> {
      new TwoIndexTextParameter((ProtocolSpecification) null, index1, index2, value);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      new TwoIndexTextParameter(spec2, 0, index2, value);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      new TwoIndexTextParameter(spec2, index1, 0, value);
    });
  }

  @Test
  void testFormat() {
    final UniformRandomProvider rg = RandomSource.create(RandomSource.SPLIT_MIX_64);
    for (int i = 0; i < 5; i++) {
      final String name = TestUtils.randomName(rg, 3);
      final String name2 = TestUtils.randomName(rg, 3);
      final int index1 = 1 + rg.nextInt(20);
      final int index2 = 1 + rg.nextInt(20);
      final String value = TestUtils.randomName(rg, 3);
      TwoIndexTextParameter param = new TwoIndexTextParameter(
          TestUtils.newTextParameterSpecification(name + "_" + name2 + "_", 0), index1, index2,
          value);
      Assertions.assertEquals(String.format("%s%d%s%d=%s", name, index1, name2, index2, value),
          param.format());
      // Repeat as this checks the cache version is the same
      Assertions.assertEquals(String.format("%s%d%s%d=%s", name, index1, name2, index2, value),
          param.format());
      Assertions.assertEquals(index1, param.getIndex1());
      Assertions.assertEquals(index2, param.getIndex2());
      Assertions.assertEquals(value, param.getValue());

      param = new TwoIndexTextParameter(ProtocolSpecification.PRODUCT_CUSTOM_DIMENSION, index1,
          index2, value);
      Assertions.assertEquals(String.format("pr%dcd%d=%s", index1, index2, value), param.format());
      Assertions.assertEquals(value, param.getValue());
    }
  }
}
