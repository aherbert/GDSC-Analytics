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

/**
 * Class to replace a single occurrence of the index marker character with an index value.
 */
public class OneIndexReplacer extends IndexReplacer {

  /** The expected number of indexes. */
  private static final int EXPECTED = 1;

  /**
   * Create a new instance.
   *
   * @param nameFormat the name format
   * @throws IncorrectCountException If the index count is not one
   */
  public OneIndexReplacer(CharSequence nameFormat) {
    super(nameFormat);
    ParameterUtils.validateCount(EXPECTED, getNumberOfIndexes());
  }

  /**
   * Create a new instance.
   *
   * <p>Package scope. The public version is to use a factory method.
   *
   * @param specification the specification
   * @throws IncorrectCountException If the index count is not one
   */
  OneIndexReplacer(ProtocolSpecification specification) {
    super(specification);
    ParameterUtils.validateCount(EXPECTED, specification);
  }

  /**
   * Replace the index marker character in the format string with the given index and write the
   * result to the {@link StringBuilder}.
   *
   * <p>E.g. replace {@code cd_} with {@code cd2} for index 2.
   *
   * @param sb the string builder
   * @param index the index
   * @return the string builder
   */
  public StringBuilder replaceTo(StringBuilder sb, int index) {
    // No formats should have the index at the start, i.e. length0 == 0.
    //@formatter:off
    sb.append(format, 0, ranges[0])
      .append(index);
    // Some formats do not have any character after the last index
    if (ranges[2] != 0) {
      sb.append(format, ranges[1], ranges[2]);
    }
    return sb;
  }
}
