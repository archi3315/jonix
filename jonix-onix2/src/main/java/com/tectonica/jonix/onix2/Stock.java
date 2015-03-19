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

import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Stock
{
	public static final String refname = "Stock";
	public static final String shortname = "stock";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public LocationIdentifier locationIdentifier; // Optional
	public LocationName locationName; // Optional
	public StockQuantityCoded stockQuantityCoded; // Required
	public OnHand onHand; // Optional
	public OnOrder onOrder; // Optional
	public CBO cbo; // Optional
	public List<OnOrderDetail> onOrderDetails; // ZeroOrMore

	public static Stock fromDoc(org.w3c.dom.Element element)
	{
		final Stock x = new Stock();

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
				if (name.equals(LocationIdentifier.refname) || name.equals(LocationIdentifier.shortname))
					x.locationIdentifier = LocationIdentifier.fromDoc(element);
				else if (name.equals(LocationName.refname) || name.equals(LocationName.shortname))
					x.locationName = LocationName.fromDoc(element);
				else if (name.equals(StockQuantityCoded.refname) || name.equals(StockQuantityCoded.shortname))
					x.stockQuantityCoded = StockQuantityCoded.fromDoc(element);
				else if (name.equals(OnHand.refname) || name.equals(OnHand.shortname))
					x.onHand = OnHand.fromDoc(element);
				else if (name.equals(OnOrder.refname) || name.equals(OnOrder.shortname))
					x.onOrder = OnOrder.fromDoc(element);
				else if (name.equals(CBO.refname) || name.equals(CBO.shortname))
					x.cbo = CBO.fromDoc(element);
				else if (name.equals(OnOrderDetail.refname) || name.equals(OnOrderDetail.shortname))
					x.onOrderDetails = DU.addToList(x.onOrderDetails, OnOrderDetail.fromDoc(element));
			}
		});

		return x;
	}

	public String getLocationNameValue()
	{
		return (locationName == null) ? null : locationName.value;
	}

	public String getOnHandValue()
	{
		return (onHand == null) ? null : onHand.value;
	}

	public String getOnOrderValue()
	{
		return (onOrder == null) ? null : onOrder.value;
	}

	public String getCBOValue()
	{
		return (cbo == null) ? null : cbo.value;
	}
}