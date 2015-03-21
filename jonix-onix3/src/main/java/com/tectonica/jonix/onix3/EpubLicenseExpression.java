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
import com.tectonica.jonix.codelist.LicenseExpressionTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.EpubLicenseExpressionStruct;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class EpubLicenseExpression implements Serializable
{
	public static final String refname = "EpubLicenseExpression";
	public static final String shortname = "epublicenseexpression";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public EpubLicenseExpressionType epubLicenseExpressionType; // Required
	public EpubLicenseExpressionTypeName epubLicenseExpressionTypeName; // Optional
	public EpubLicenseExpressionLink epubLicenseExpressionLink; // Required

	public EpubLicenseExpression()
	{}

	public EpubLicenseExpression(org.w3c.dom.Element element)
	{
		this.datestamp = JPU.getAttribute(element, "datestamp");
		this.sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		this.sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(EpubLicenseExpressionType.refname) || name.equals(EpubLicenseExpressionType.shortname))
					epubLicenseExpressionType = new EpubLicenseExpressionType(element);
				else if (name.equals(EpubLicenseExpressionTypeName.refname) || name.equals(EpubLicenseExpressionTypeName.shortname))
					epubLicenseExpressionTypeName = new EpubLicenseExpressionTypeName(element);
				else if (name.equals(EpubLicenseExpressionLink.refname) || name.equals(EpubLicenseExpressionLink.shortname))
					epubLicenseExpressionLink = new EpubLicenseExpressionLink(element);
			}
		});
	}

	public LicenseExpressionTypes getEpubLicenseExpressionTypeValue()
	{
		return (epubLicenseExpressionType == null) ? null : epubLicenseExpressionType.value;
	}

	public String getEpubLicenseExpressionTypeNameValue()
	{
		return (epubLicenseExpressionTypeName == null) ? null : epubLicenseExpressionTypeName.value;
	}

	public String getEpubLicenseExpressionLinkValue()
	{
		return (epubLicenseExpressionLink == null) ? null : epubLicenseExpressionLink.value;
	}

	public EpubLicenseExpressionStruct asStruct()
	{
		EpubLicenseExpressionStruct x = new EpubLicenseExpressionStruct();
		x.epubLicenseExpressionTypeName = getEpubLicenseExpressionTypeNameValue();
		x.epubLicenseExpressionLink = getEpubLicenseExpressionLinkValue();
		return x;
	}
}
