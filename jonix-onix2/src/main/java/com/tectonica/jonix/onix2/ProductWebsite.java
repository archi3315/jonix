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

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.codelist.WebsiteRoles;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class ProductWebsite
{
	public static final String refname = "ProductWebsite";
	public static final String shortname = "productwebsite";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public WebsiteRole websiteRole; // Optional
	public ProductWebsiteDescription productWebsiteDescription; // Optional
	public ProductWebsiteLink productWebsiteLink; // Required

	public static ProductWebsite fromDoc(org.w3c.dom.Element element)
	{
		final ProductWebsite x = new ProductWebsite();

		x.textformat = TextFormats.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = TextCaseFlags.byValue(DU.getAttribute(element, "textcase"));
		x.language = LanguageCodeIso6392Bs.byValue(DU.getAttribute(element, "language"));
		x.transliteration = TransliterationSchemes.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(WebsiteRole.refname) || name.equals(WebsiteRole.shortname))
					x.websiteRole = WebsiteRole.fromDoc(element);
				else if (name.equals(ProductWebsiteDescription.refname) || name.equals(ProductWebsiteDescription.shortname))
					x.productWebsiteDescription = ProductWebsiteDescription.fromDoc(element);
				else if (name.equals(ProductWebsiteLink.refname) || name.equals(ProductWebsiteLink.shortname))
					x.productWebsiteLink = ProductWebsiteLink.fromDoc(element);
			}
		});

		return x;
	}

	public WebsiteRoles getWebsiteRoleValue()
	{
		return (websiteRole == null) ? null : websiteRole.value;
	}

	public String getProductWebsiteDescriptionValue()
	{
		return (productWebsiteDescription == null) ? null : productWebsiteDescription.value;
	}

	public String getProductWebsiteLinkValue()
	{
		return (productWebsiteLink == null) ? null : productWebsiteLink.value;
	}
}