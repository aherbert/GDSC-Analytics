package gdsc.analytics;

/*
 * <ul>
 * <li>Copyright (c) 2016 Alex Herbert
 * </ul>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

/**
 * URL builder for the tracking requests.
 */
public interface IAnalyticsMeasurementProtocolURLBuilder
{
	/**
	 * Gets the version for this builder
	 * 
	 * @return The version
	 */
	public String getVersion();

	/**
	 * Build the parameters URL request from the data. The parameters are suitable for use in the HTTP POST method.
	 * 
	 * @param clientParameters
	 *            The client parameter data
	 * @param requestParameters
	 *            The request parameter data
	 * @param timestamp
	 *            The timestamp when the hit was reported (in milliseconds)
	 * @return The parameters URL
	 */
	public String buildURL(ClientParameters clientParameters, RequestParameters requestParameters, long timestamp);

	/**
	 * Build the parameters URL request from the data. The parameters are suitable for use in the HTTP GET method.
	 * 
	 * @param clientParameters
	 *            The client parameter data
	 * @param requestParameters
	 *            The request parameter data
	 * @param timestamp
	 *            The timestamp when the hit was reported (in milliseconds)
	 * @return The parameters URL
	 */
	public String buildGetURL(ClientParameters clientParameters, RequestParameters requestParameters, long timestamp);
}