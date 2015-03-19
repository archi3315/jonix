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
 * Enum that corresponds to ONIX's CodeList154
 * <p>
 * Content audience
 * 
 * @see http://www.editeur.org/14/code-lists/
 */
public enum ContentAudiences
{
	/**
	 * Any audience.
	 */
	Unrestricted("00"), //

	/**
	 * Distribution by agreement between the parties to the ONIX exchange (this value is provided to cover applications where ONIX content
	 * includes material which is not for general distribution).
	 */
	Restricted("01"), //

	/**
	 * Distributors, bookstores, publisher’s own staff etc.
	 */
	Booktrade("02"), //

	End_customers("03"), //

	Librarians("04"), //

	Teachers("05"), //

	Students("06"), //

	/**
	 * Press or other media.
	 */
	Press("07"), //

	/**
	 * Where a specially formatted description is required for this audience.
	 */
	Shopping_comparison_service("08");

	public final String value;

	private ContentAudiences(String value)
	{
		this.value = value;
	}

	private static Map<String, ContentAudiences> map;

	private static Map<String, ContentAudiences> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (ContentAudiences e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static ContentAudiences byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
