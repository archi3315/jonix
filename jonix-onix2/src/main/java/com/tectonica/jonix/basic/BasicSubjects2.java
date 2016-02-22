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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tectonica.jonix.basic.BasicSubject;
import com.tectonica.jonix.basic.BasicSubjects;
import com.tectonica.jonix.codelist.SubjectSchemeIdentifiers;
import com.tectonica.jonix.onix2.Product;
import com.tectonica.jonix.onix2.Subject;

/**
 * ONIX2 concrete implementation for {@link BasicSubjects}
 * 
 * @author Zach Melamed
 */
public class BasicSubjects2 extends BasicSubjects
{
	private static final long serialVersionUID = 1L;

	private transient final Product product;

	public BasicSubjects2(Product product)
	{
		this.product = product;
	}

	@Override
	protected Map<SubjectSchemeIdentifiers, List<BasicSubject>> initialize()
	{
		Map<SubjectSchemeIdentifiers, List<BasicSubject>> map = new HashMap<>();
		String bisacMainSubject = product.getBASICMainSubjectValue();
		if (bisacMainSubject != null)
			addKV(map, new BasicSubject2(SubjectSchemeIdentifiers.BISAC_Subject_Heading, bisacMainSubject, null), false);

		String bicMainSubject = product.getBICMainSubjectValue();
		if (bicMainSubject != null)
			addKV(map, new BasicSubject2(SubjectSchemeIdentifiers.BIC_subject_category, bicMainSubject, null), false);

		if (product.subjects != null)
		{
			for (Subject subject : product.subjects)
				addKV(map, new BasicSubject2(subject), false);
		}
		return map;
	}
}
