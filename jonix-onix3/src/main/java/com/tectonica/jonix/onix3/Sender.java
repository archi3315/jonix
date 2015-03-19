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

package com.tectonica.jonix.onix3;

import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.RecordSourceTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Sender
{
	public static final String refname = "Sender";
	public static final String shortname = "sender";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public List<SenderIdentifier> senderIdentifiers; // OneOrMore
	public SenderName senderName; // Optional
	public ContactName contactName; // Optional
	public EmailAddress emailAddress; // Optional

	public static Sender fromDoc(org.w3c.dom.Element element)
	{
		final Sender x = new Sender();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(SenderIdentifier.refname) || name.equals(SenderIdentifier.shortname))
					x.senderIdentifiers = DU.addToList(x.senderIdentifiers, SenderIdentifier.fromDoc(element));
				else if (name.equals(SenderName.refname) || name.equals(SenderName.shortname))
					x.senderName = SenderName.fromDoc(element);
				else if (name.equals(ContactName.refname) || name.equals(ContactName.shortname))
					x.contactName = ContactName.fromDoc(element);
				else if (name.equals(EmailAddress.refname) || name.equals(EmailAddress.shortname))
					x.emailAddress = EmailAddress.fromDoc(element);
			}
		});

		return x;
	}

	public String getSenderNameValue()
	{
		return (senderName == null) ? null : senderName.value;
	}

	public String getContactNameValue()
	{
		return (contactName == null) ? null : contactName.value;
	}

	public String getEmailAddressValue()
	{
		return (emailAddress == null) ? null : emailAddress.value;
	}
}