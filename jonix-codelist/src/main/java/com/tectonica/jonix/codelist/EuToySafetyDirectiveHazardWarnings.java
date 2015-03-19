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

package com.tectonica.jonix.codelist;

import java.util.Map;
import java.util.HashMap;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Enum that corresponds to ONIX's CodeList184
 * <p>
 * EU Toy Safety Directive hazard warning
 * 
 * @see http://www.editeur.org/14/code-lists/
 */
public enum EuToySafetyDirectiveHazardWarnings
{
	/**
	 * Use to provide positive indication that no warnings are applicable.
	 */
	No_warning("00"), //

	Carries_CE_logo("01"), //

	/**
	 * Use to specify age (in years, or years and months). Provide specific wording in <ProductFormFeatureDescription>.
	 */
	Carries_minimum_age_warning("02"), //

	/**
	 * Carries logo, and must be accompanied by the default warning ‘Not suitable for children under 36 months’ (or its approved equivalent
	 * in a language other than English, as appropriate), unless specific wording is provided in <ProductFormFeatureDescription>. If
	 * specific alternative wording is carried in <ProductFormFeatureDescription>, this must be used in place of the default text.
	 */
	Carries_EU_Toy_Safety_Directive_Unsuitable_for_children_ages_0_3_warning_logo("03"), //

	/**
	 * Exact text of warning must be included in <ProductFormFeatureDescription>.
	 */
	Carries_EU_Toy_Safety_Directive_hazard_warning("04"), //

	/**
	 * Exact text (not in itself a warning) must be included in <ProductFormFeatureDescription>. May be used either without any warning, or
	 * as text additional to a warning. Note that if no warnings apply, code 00 can provide positive indication of this. Example use:
	 * “Suitable for all ages”.
	 */
	Carries_other_text_associated_with_toy_safety("05"), //

	/**
	 * Material Safety Data Sheet (a document required by the EU Toy Safety Directive) available online, typically as a PDF file or similar.
	 * <ProductFormFeatureDescription> must carry the URL of the document.
	 */
	Material_Safety_Data_Sheet_available("06"), //

	/**
	 * Declaration of Conformity (the document that backs up the CE mark) available online, typically as a PDF file or similar.
	 * <ProductFormFeatureDescription> must carry the URL of the document.
	 */
	Declaration_of_Conformity_available("07");

	public final String value;

	private EuToySafetyDirectiveHazardWarnings(String value)
	{
		this.value = value;
	}

	private static Map<String, EuToySafetyDirectiveHazardWarnings> map;

	private static Map<String, EuToySafetyDirectiveHazardWarnings> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (EuToySafetyDirectiveHazardWarnings e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static EuToySafetyDirectiveHazardWarnings byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
