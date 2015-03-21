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

package com.tectonica.jonix.composite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.tectonica.jonix.codelist.SubjectSchemeIdentifiers;

@SuppressWarnings("serial")
public class Subject implements Serializable
{
	public final SubjectSchemeIdentifiers subjectSchemeIdentifier;
	public final String subjectCode;
	public final String subjectHeadingText;

	public Subject(SubjectSchemeIdentifiers subjectSchemeIdentifier, String subjectCode, String subjectHeadingText)
	{
		this.subjectSchemeIdentifier = subjectSchemeIdentifier;
		this.subjectCode = subjectCode;
		this.subjectHeadingText = subjectHeadingText;
	}

	@Override
	public String toString()
	{
		String subjectSchemeIdentifierStr = (subjectSchemeIdentifier == null) ? null : subjectSchemeIdentifier.name();
		return String.format(getClass().getSimpleName() + " [%s]: %s | %s", subjectSchemeIdentifierStr, subjectCode, subjectHeadingText);
	}

	public static List<Subject> listFrom(com.tectonica.jonix.onix2.Product product)
	{
		if (product.subjects != null)
		{
			List<Subject> result = new ArrayList<>();
			for (com.tectonica.jonix.onix2.Subject i : product.subjects)
				result.add(new Subject(i.getSubjectSchemeIdentifierValue(), i.getSubjectCodeValue(), i.getSubjectHeadingTextValue()));
			return result;
		}
		return Collections.emptyList();
	}
}