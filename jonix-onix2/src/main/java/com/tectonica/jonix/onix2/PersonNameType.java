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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.PersonOrganizationNameTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Person name type</h1><p>An ONIX code indicating the type of the person name sent in an occurrence of the
 * &lt;Name&gt; composite. Mandatory in each occurrence of the composite, and non-repeating.</p><table border='1'
 * cellpadding='3'><tr><td>Format</td><td>Fixed-length, two numeric digits</td></tr><tr><td>Codelist</td><td>List
 * 18</td></tr><tr><td>Reference name</td><td>&lt;PersonNameType&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;b250&gt;</td></tr><tr><td>Example</td><td>&lt;PersonNameType&gt;01&lt;/PersonNameType&gt;&#160;&#160;&#160;&#160;Pseudonym</td></tr></table>
 */
public class PersonNameType implements OnixElement<PersonOrganizationNameTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PersonNameType";
    public static final String shortname = "b250";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    public TextFormats textformat;

    public TextCaseFlags textcase;

    public LanguageCodes language;

    public TransliterationSchemes transliteration;

    /**
     * (type: DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    public String sourcename;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    public PersonOrganizationNameTypes value;

    /**
     * Internal API, use the {@link #value} field instead
     */
    @Override
    public PersonOrganizationNameTypes _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final PersonNameType EMPTY = new PersonNameType();

    public PersonNameType() {
        exists = false;
    }

    public PersonNameType(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = LanguageCodes.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = PersonOrganizationNameTypes.byCode(JPU.getContentAsString(element));
    }

    @Override
    public boolean exists() {
        return exists;
    }
}
