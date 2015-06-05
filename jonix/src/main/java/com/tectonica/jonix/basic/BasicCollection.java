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
import java.util.List;

import com.tectonica.jonix.struct.JonixCollectionIdentifier;
import com.tectonica.jonix.struct.JonixSeriesIdentifier;

@SuppressWarnings("serial")
public class BasicCollection implements Serializable
{
	public String mainTitle;
	public List<JonixCollectionIdentifier> seriesIdentifiers;
	public List<BasicTitle> titles;
	public List<BasicContributor> contributors;

	public BasicCollection extractFrom(com.tectonica.jonix.onix2.Series c)
	{
		this.mainTitle = c.getTitleOfSeriesValue();
		this.seriesIdentifiers = sidsToCids(c.findSeriesIdentifiers(null));
		this.titles = new BasicTitles().extractFrom(c);
		this.contributors = new BasicContributors().extractFrom(c);

		return this;
	}

	public BasicCollection extractFrom(com.tectonica.jonix.onix3.Collection c)
	{
		this.titles = new BasicTitles().extractFrom(c);
		this.mainTitle = titles.get(0).titleText;
		this.seriesIdentifiers = c.findCollectionIdentifiers(null);
		this.contributors = new BasicContributors().extractFrom(c);

		return this;
	}

	private List<JonixCollectionIdentifier> sidsToCids(List<JonixSeriesIdentifier> sids)
	{
		if (sids == null)
			return null;

		List<JonixCollectionIdentifier> result = new ArrayList<>();
		for (JonixSeriesIdentifier sid : sids)
		{
			JonixCollectionIdentifier cid = new JonixCollectionIdentifier();
			cid.collectionIDType = sid.seriesIDType;
			cid.idTypeName = sid.idTypeName;
			cid.idValue = sid.idValue;
			result.add(cid);
		}
		return result;
	}
}