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

package com.tectonica.jonix.onix2;

import java.io.Serializable;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.ExtentTypes;
import com.tectonica.jonix.codelist.ExtentUnits;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixExtent;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Extent composite</h1>
 * <p>
 * A repeatable group of data elements which together describe an extent pertaining to the product.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Extent&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;extent&gt;</td>
 * </tr>
 * </table>
 */
public class Extent implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Extent";
	public static final String shortname = "extent";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	public TextFormats textformat;

	public TextCaseFlags textcase;

	public LanguageCodes language;

	public TransliterationSchemes transliteration;

	/**
	 * (type: DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	// ///////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (this field is required)
	 */
	public ExtentType extentType;

	/**
	 * (this field is required)
	 */
	public ExtentValue extentValue;

	/**
	 * (this field is required)
	 */
	public ExtentUnit extentUnit;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Extent()
	{}

	public Extent(org.w3c.dom.Element element)
	{
		textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(ExtentType.refname) || name.equals(ExtentType.shortname))
					extentType = new ExtentType(element);
				else if (name.equals(ExtentValue.refname) || name.equals(ExtentValue.shortname))
					extentValue = new ExtentValue(element);
				else if (name.equals(ExtentUnit.refname) || name.equals(ExtentUnit.shortname))
					extentUnit = new ExtentUnit(element);
			}
		});
	}

	public ExtentTypes getExtentTypeValue()
	{
		return (extentType == null) ? null : extentType.value;
	}

	/**
	 * Raw Format: Numeric, with decimal point where required, as specified in field PR.12.4
	 */
	public String getExtentValueValue()
	{
		return (extentValue == null) ? null : extentValue.value;
	}

	public ExtentUnits getExtentUnitValue()
	{
		return (extentUnit == null) ? null : extentUnit.value;
	}

	public JonixExtent asJonixExtent()
	{
		JonixExtent x = new JonixExtent();
		x.extentType = getExtentTypeValue();
		x.extentUnit = getExtentUnitValue();
		x.extentValue = JPU.convertStringToDouble(getExtentValueValue());
		return x;
	}
}
