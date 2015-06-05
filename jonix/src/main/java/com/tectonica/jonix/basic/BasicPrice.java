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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.codelist.CurrencyCodeIso4217s;
import com.tectonica.jonix.codelist.PriceTypes;

@SuppressWarnings("serial")
public class BasicPrice implements Serializable
{
	public PriceTypes priceType;
	public Double priceAmount;
	public String priceAmountAsStr;
	public CurrencyCodeIso4217s currencyCode;

	public BasicPrice extractFrom(com.tectonica.jonix.onix2.Price p)
	{
		priceType = p.getPriceTypeCodeValue();
		priceAmount = JPU.convertStringToDoubleSafe(p.getPriceAmountValue());
		priceAmountAsStr = (priceAmount == null) ? "" : priceAmount.toString();
		currencyCode = p.getCurrencyCodeValue();
		return this;
	}

	public BasicPrice extractFrom(com.tectonica.jonix.onix3.Price p)
	{
		priceType = p.getPriceTypeValue();
		priceAmount = p.getPriceAmountValue();
		priceAmountAsStr = (priceAmount == null) ? "" : priceAmount.toString();
		currencyCode = p.getCurrencyCodeValue();
		return this;
	}
}