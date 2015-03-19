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

public class ContentItem
{
	public static final String refname = "ContentItem";
	public static final String shortname = "contentitem";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public LevelSequenceNumber levelSequenceNumber; // Optional
	public TextItem textItem; // Required
	public List<Website> websites; // ZeroOrMore
	public ComponentTypeName componentTypeName; // Required
	public ComponentNumber componentNumber; // Optional
	public DistinctiveTitle distinctiveTitle; // Optional
	public List<Title> titles; // ZeroOrMore
	public List<WorkIdentifier> workIdentifiers; // ZeroOrMore
	public List<Contributor> contributors; // ZeroOrMore
	public ContributorStatement contributorStatement; // Optional
	public List<Subject> subjects; // ZeroOrMore
	public List<PersonAsSubject> personAsSubjects; // ZeroOrMore
	public List<CorporateBodyAsSubject> corporateBodyAsSubjects; // ZeroOrMore
	public List<PlaceAsSubject> placeAsSubjects; // ZeroOrMore
	public List<OtherText> otherTexts; // ZeroOrMore
	public List<MediaFile> mediaFiles; // ZeroOrMore

	public static ContentItem fromDoc(org.w3c.dom.Element element)
	{
		final ContentItem x = new ContentItem();

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
				if (name.equals(LevelSequenceNumber.refname) || name.equals(LevelSequenceNumber.shortname))
					x.levelSequenceNumber = LevelSequenceNumber.fromDoc(element);
				else if (name.equals(TextItem.refname) || name.equals(TextItem.shortname))
					x.textItem = TextItem.fromDoc(element);
				else if (name.equals(Website.refname) || name.equals(Website.shortname))
					x.websites = DU.addToList(x.websites, Website.fromDoc(element));
				else if (name.equals(ComponentTypeName.refname) || name.equals(ComponentTypeName.shortname))
					x.componentTypeName = ComponentTypeName.fromDoc(element);
				else if (name.equals(ComponentNumber.refname) || name.equals(ComponentNumber.shortname))
					x.componentNumber = ComponentNumber.fromDoc(element);
				else if (name.equals(DistinctiveTitle.refname) || name.equals(DistinctiveTitle.shortname))
					x.distinctiveTitle = DistinctiveTitle.fromDoc(element);
				else if (name.equals(Title.refname) || name.equals(Title.shortname))
					x.titles = DU.addToList(x.titles, Title.fromDoc(element));
				else if (name.equals(WorkIdentifier.refname) || name.equals(WorkIdentifier.shortname))
					x.workIdentifiers = DU.addToList(x.workIdentifiers, WorkIdentifier.fromDoc(element));
				else if (name.equals(Contributor.refname) || name.equals(Contributor.shortname))
					x.contributors = DU.addToList(x.contributors, Contributor.fromDoc(element));
				else if (name.equals(ContributorStatement.refname) || name.equals(ContributorStatement.shortname))
					x.contributorStatement = ContributorStatement.fromDoc(element);
				else if (name.equals(Subject.refname) || name.equals(Subject.shortname))
					x.subjects = DU.addToList(x.subjects, Subject.fromDoc(element));
				else if (name.equals(PersonAsSubject.refname) || name.equals(PersonAsSubject.shortname))
					x.personAsSubjects = DU.addToList(x.personAsSubjects, PersonAsSubject.fromDoc(element));
				else if (name.equals(CorporateBodyAsSubject.refname) || name.equals(CorporateBodyAsSubject.shortname))
					x.corporateBodyAsSubjects = DU.addToList(x.corporateBodyAsSubjects, CorporateBodyAsSubject.fromDoc(element));
				else if (name.equals(PlaceAsSubject.refname) || name.equals(PlaceAsSubject.shortname))
					x.placeAsSubjects = DU.addToList(x.placeAsSubjects, PlaceAsSubject.fromDoc(element));
				else if (name.equals(OtherText.refname) || name.equals(OtherText.shortname))
					x.otherTexts = DU.addToList(x.otherTexts, OtherText.fromDoc(element));
				else if (name.equals(MediaFile.refname) || name.equals(MediaFile.shortname))
					x.mediaFiles = DU.addToList(x.mediaFiles, MediaFile.fromDoc(element));
			}
		});

		return x;
	}

	public String getLevelSequenceNumberValue()
	{
		return (levelSequenceNumber == null) ? null : levelSequenceNumber.value;
	}

	public String getComponentTypeNameValue()
	{
		return (componentTypeName == null) ? null : componentTypeName.value;
	}

	public String getComponentNumberValue()
	{
		return (componentNumber == null) ? null : componentNumber.value;
	}

	public String getDistinctiveTitleValue()
	{
		return (distinctiveTitle == null) ? null : distinctiveTitle.value;
	}

	public String getContributorStatementValue()
	{
		return (contributorStatement == null) ? null : contributorStatement.value;
	}
}