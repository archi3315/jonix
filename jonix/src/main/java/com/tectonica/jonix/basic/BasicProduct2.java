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

package com.tectonica.jonix.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.JonixColumn;
import com.tectonica.jonix.codelist.ContributorRoles;
import com.tectonica.jonix.codelist.CountryCodeIso31661s;
import com.tectonica.jonix.codelist.EditionTypes;
import com.tectonica.jonix.codelist.EpublicationTypes;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.LanguageRoles;
import com.tectonica.jonix.codelist.NotificationOrUpdateTypes;
import com.tectonica.jonix.codelist.PriceTypes;
import com.tectonica.jonix.codelist.ProductForms;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.SalesRightsTypes;
import com.tectonica.jonix.codelist.SubjectSchemeIdentifiers;
import com.tectonica.jonix.codelist.TextTypes;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.composite.Contributor;
import com.tectonica.jonix.composite.Imprint;
import com.tectonica.jonix.composite.OtherText;
import com.tectonica.jonix.composite.Price;
import com.tectonica.jonix.composite.Publisher;
import com.tectonica.jonix.composite.SalesRights;
import com.tectonica.jonix.composite.Series;
import com.tectonica.jonix.composite.Subject;
import com.tectonica.jonix.composite.SupplyDetail;
import com.tectonica.jonix.composite.Title;
import com.tectonica.jonix.onix2.CityOfPublication;
import com.tectonica.jonix.struct.JonixAudience;
import com.tectonica.jonix.struct.JonixLanguage;
import com.tectonica.jonix.struct.JonixProductIdentifier;

@SuppressWarnings("serial")
public class BasicProduct2 implements Serializable
{
	public final String recordReference;
	public final Integer editionNumber;
	public final String cityOfPublication;
	public final String publicationDate;
	public final String numberOfPages;

	public final NotificationOrUpdateTypes notificationType;
	public final ProductForms productForm;
	public final EpublicationTypes epubType;
	public final EditionTypes editionType;
	public final CountryCodeIso31661s countryOfPublication;

//	public final List<ProductIdentifier> productIdentifiers;
//	public final List<Title> titles;
	public final List<Title> titles;
	public final List<Contributor> contributors;
	public final List<Series> seriess;
//	public final List<Language> languages;
	public final Map<SubjectSchemeIdentifiers, List<Subject>> subjects;
	public final List<JonixAudience> audiences;
	public final List<OtherText> otherTexts;
	public final List<Publisher> publishers;
	public final List<Imprint> imprints;
	public final List<SupplyDetail> supplyDetails;
	public final List<SalesRights> salesRightss;

	public final com.tectonica.jonix.onix2.Product product;

	public BasicProduct2(com.tectonica.jonix.onix2.Product product)
	{
		this.product = product;

		// singles
		recordReference = product.getRecordReferenceValue();
		editionNumber = JPU.convertStringToInteger(product.getEditionNumberValue());
		publicationDate = product.getPublicationDateValue();
		numberOfPages = product.getNumberOfPagesValue();
		notificationType = product.getNotificationTypeValue();
		productForm = product.getProductFormValue();
		epubType = product.getEpubTypeValue();
		countryOfPublication = product.getCountryOfPublicationValue();

		// retrieve first values
		cityOfPublication = findCityOfPublication(LanguageCodeIso6392Bs.English);
		editionType = (product.editionTypeCodes == null) ? null : product.editionTypeCodes.get(0).value;

		// composites
//		productIdentifiers = ProductIdentifier.listFrom(product);
//		titles = Title.listFrom(product);
		titles = Title.listFrom(product);
		contributors = Contributor.listFrom(product); // TODO: use intf
		seriess = Series.listFrom(product); // onix2-only
//		languages = Language.listFrom(product);
		subjects = Subject.listFrom(product); // TODO: use struct
		audiences = product.findAudiences(null);
		otherTexts = OtherText.listFrom(product); // TODO: use struct - although not complete
		publishers = Publisher.listFrom(product); // TODO: use intf
		imprints = Imprint.listFrom(product); // non-struct
		supplyDetails = SupplyDetail.listFrom(product); // TODO: use intf
		salesRightss = SalesRights.listFrom(product); // non-struct
	}

	public String getLabel()
	{
		return (titles.size() > 0) ? titles.get(0).titleText : recordReference;
	}

	public static JonixColumn[] getDefaultColumns()
	{
		return BasicColumn.all;
	}

	public static JonixColumn getDefaultIdColumn()
	{
		return BasicColumn.ISBN13;
	}

	// LOOKUP CONVENIENCE SERVICES

	public JonixProductIdentifier findProductId(ProductIdentifierTypes requestedType)
	{
		return product.findProductIdentifier(requestedType);
	}

	public Title findTitle(TitleTypes requestedType)
	{
		for (Title title : titles)
		{
			if (title.titleType == requestedType)
				return title;
		}
		return null;
	}

	public List<Contributor> findContributors(ContributorRoles requestedRole)
	{
		List<Contributor> matches = new ArrayList<Contributor>();
		for (Contributor contributor : contributors)
		{
			if (contributor.contributorRoles.contains(requestedRole))
				matches.add(contributor);
		}
		return matches;
	}

	public JonixLanguage findLanguage(LanguageRoles requestedType)
	{
		return product.findLanguage(requestedType);
	}

	public List<Subject> findSubjects(SubjectSchemeIdentifiers requestedScheme)
	{
		List<Subject> list = subjects.get(requestedScheme);
		if (list == null)
			return Collections.emptyList();
		return list;
	}

	public OtherText findOtherText(TextTypes requestedType)
	{
		// we don't use product.findOtherText() because we need the 'textFormat' attribute, not just the value
		for (OtherText otherText : otherTexts)
		{
			if (otherText.textType == requestedType)
				return otherText;
		}
		return null;
	}

	public List<Price> findPrices(Set<PriceTypes> requestedTypes)
	{
		List<Price> matches = new ArrayList<Price>();
		for (SupplyDetail supplyDetail : supplyDetails)
		{
			for (Price price : supplyDetail.prices)
			{
				if (requestedTypes.contains(price.priceType))
					matches.add(price);
			}
		}
		return matches;
	}

	public List<SalesRights> findSalesRightss(Set<SalesRightsTypes> requestedTypes)
	{
//		return product.findSalesRightss(requestedTypes);
		List<SalesRights> matches = new ArrayList<SalesRights>();
		for (SalesRights salesRights : salesRightss)
		{
			if (requestedTypes.contains(salesRights.salesRightsType))
				matches.add(salesRights);
		}
		return matches;
	}

	public String findCityOfPublication(LanguageCodeIso6392Bs preferredLanguage)
	{
		if (product.cityOfPublications != null)
		{
			for (CityOfPublication cop : product.cityOfPublications)
			{
				if (cop.language == null || cop.language == preferredLanguage)
					return cop.value;
			}
			return product.cityOfPublications.get(0).value; // return whatever language we have
		}
		return null;
	}
}
