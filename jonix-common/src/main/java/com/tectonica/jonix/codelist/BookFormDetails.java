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

import com.tectonica.jonix.OnixCodelist;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 8</b>
 * <p>
 * Description: Book form detail
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist8">ONIX
 *      Codelist 8 in Reference Guide</a>
 */
public enum BookFormDetails implements OnixCodelist
{
	/**
	 * DEPRECATED
	 */
	A_format_paperback("01", "A-format paperback"), //

	/**
	 * 'B' format paperback: UK 198 x 129 mm - DEPRECATED
	 */
	B_format_paperback("02", "B-format paperback"), //

	/**
	 * 'C' format paperback: UK 216 x 135 mm - DEPRECATED
	 */
	C_format_paperback("03", "C-format paperback"), //

	/**
	 * DEPRECATED
	 */
	Paper_over_boards("04", "Paper over boards"), //

	/**
	 * DEPRECATED
	 */
	Cloth("05", "Cloth"), //

	/**
	 * DEPRECATED
	 */
	With_dust_jacket("06", "With dust jacket"), //

	/**
	 * DEPRECATED
	 */
	Reinforced_binding("07", "Reinforced binding");

	public final String code;
	public final String description;

	private BookFormDetails(String code, String description)
	{
		this.code = code;
		this.description = description;
	}

	@Override
	public String getCode()
	{
		return code;
	}

	@Override
	public String getDescription()
	{
		return description;
	}

	public static BookFormDetails byCode(String code)
	{
		if (code == null || code.isEmpty())
			return null;
		for (BookFormDetails e : values())
			if (e.code.equals(code))
				return e;
		return null;
	}
}
