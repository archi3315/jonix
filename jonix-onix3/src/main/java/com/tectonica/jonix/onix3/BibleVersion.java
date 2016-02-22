/*
 * Copyright (C) 2012 Zach Melamed
 * 
 * Latest version available online at https://github.com/zach-m/jonix
 * Contact me at zach@tectonica.co.il
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tectonica.jonix.onix3;

import java.io.Serializable;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.BibleVersions;
import com.tectonica.jonix.codelist.RecordSourceTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Bible version</h1>
 * <p>
 * An ONIX code indicating the version of a Bible or selected Biblical text, for example ‘King James’, ‘Jerusalem’, ‘New
 * American Standard’, ‘Reina Valera’. Mandatory in each occurrence of the &lt;Bible&gt; composite, and repeatable if a
 * work includes text in two or more versions.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Fixed-length, three letters</td>
 * </tr>
 * <tr>
 * <td>Codelist</td>
 * <td>List 83</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;BibleVersion&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;b353&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1&#8230;n</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;BibleVersion&gt;JER&lt;/BibleVersion&gt; (Jerusalem)</td>
 * </tr>
 * </table>
 */
public class BibleVersion implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "BibleVersion";
	public static final String shortname = "b353";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	// ///////////////////////////////////////////////////////////////////////////////
	// VALUE MEMBER
	// ///////////////////////////////////////////////////////////////////////////////

	public BibleVersions value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public BibleVersion()
	{}

	public BibleVersion(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		value = BibleVersions.byCode(JPU.getContentAsString(element));
	}
}
