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
 * Enum that corresponds to ONIX's CodeList147
 * <p>
 * Unit of usage
 * 
 * @see http://www.editeur.org/14/code-lists/
 */
public enum UnitOfUsages
{
	/**
	 * Maximum number of copies that may be made of a permitted extract.
	 */
	Copies("01"), //

	/**
	 * Maximum number of characters in a permitted extract for a specified usage.
	 */
	Characters("02"), //

	/**
	 * Maximum number of words in a permitted extract for a specified usage.
	 */
	Words("03"), //

	/**
	 * Maximum number of pages in a permitted extract for a specified usage.
	 */
	Pages("04"), //

	/**
	 * Maximum percentage of total content in a permitted extract for a specified usage.
	 */
	Percentage("05"), //

	/**
	 * Maximum number of devices in ‘share group’.
	 */
	Devices("06"), //

	/**
	 * Maximum number of concurrent users. NB where the number of concurrent users is specifically not limited, set the number of concurrent
	 * users to zero.
	 */
	Concurrent_users("07"), //

	/**
	 * Maximum percentage of total content which may be used in a specified usage per time period; the time period being specified as
	 * another EpubUsageQuantity.
	 */
	Percentage_per_time_period("08"), //

	/**
	 * Maximum time period in days.
	 */
	Days("09"), //

	/**
	 * Maximum time period in weeks.
	 */
	Weeks("13"), //

	/**
	 * Maximum time period in months.
	 */
	Months("14"), //

	/**
	 * Maximum number of times a specified usage event may occur.
	 */
	Times("10"), //

	/**
	 * Maximum resolution of printed or copy/pasted extracts.
	 * <p>
	 * NOTE: Introduced in Onix3
	 */
	Dots_per_inch("21"), //

	/**
	 * Page number where allowed usage begins. <Quantity> should contain an absolute page number, counting the cover as page 1. (This type
	 * of page numbering should not be used where the e-publication has no fixed pagination). Use with (max number of) Pages, Percentage of
	 * content, or End page to specify pages allowed in Preview.
	 * <p>
	 * NOTE: Introduced in Onix3
	 */
	Allowed_usage_start_page("11"), //

	/**
	 * Page number at which allowed usage ends. <Quantity> should contain an absolute page number, counting the cover as page 1. (This type
	 * of page numbering should not be used where the e-publication has no fixed pagination). Use with Start page to specify pages allowed
	 * in a preview.
	 * <p>
	 * NOTE: Introduced in Onix3
	 */
	Allowed_usage_end_page("12"), //

	/**
	 * Page number where allowed usage begins. <Quantity> should contain an absolute page number, counting the cover as page 1. (This type
	 * of page numbering should not be used where the e-publication has no fixed pagination). Use with (max number of) Pages, Percentage of
	 * content, or End page to specify pages allowed in Preview.
	 * <p>
	 * NOTE: Deprecated in Onix3
	 */
	Allowed_usage_start_page_("11"), //

	/**
	 * Page number at which allowed usage ends. <Quantity> should contain an absolute page number, counting the cover as page 1. (This type
	 * of page numbering should not be used where the e-publication has no fixed pagination). Use with Start page to specify pages allowed
	 * in a preview.
	 * <p>
	 * NOTE: Deprecated in Onix3
	 */
	Allowed_usage_end_page_("12");

	public final String value;

	private UnitOfUsages(String value)
	{
		this.value = value;
	}

	private static Map<String, UnitOfUsages> map;

	private static Map<String, UnitOfUsages> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (UnitOfUsages e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static UnitOfUsages byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
