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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.codelist.NameCodeTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixConferenceSponsorIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Conference sponsor identifier composite</h1><p>An optional and repeatable group of data elements which together
 * carry a coded identifier for a sponsor of a conference.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;ConferenceSponsorIdentifier&gt;</td></tr><tr><td>Short tag</td><td>&lt;conferencesponsoridentifier&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class ConferenceSponsorIdentifier
    implements OnixDataCompositeWithKey<JonixConferenceSponsorIdentifier, NameCodeTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ConferenceSponsorIdentifier";
    public static final String shortname = "conferencesponsoridentifier";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    public String sourcename;

    /////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final ConferenceSponsorIdentifier EMPTY = new ConferenceSponsorIdentifier();

    public ConferenceSponsorIdentifier() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ConferenceSponsorIdentifier(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
    }

    private void initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            if (name.equals(ConferenceSponsorIDType.refname) || name.equals(ConferenceSponsorIDType.shortname)) {
                conferenceSponsorIDType = new ConferenceSponsorIDType(e);
            } else if (name.equals(IDTypeName.refname) || name.equals(IDTypeName.shortname)) {
                idTypeName = new IDTypeName(e);
            } else if (name.equals(IDValue.refname) || name.equals(IDValue.shortname)) {
                idValue = new IDValue(e);
            }
        });
    }

    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private ConferenceSponsorIDType conferenceSponsorIDType = ConferenceSponsorIDType.EMPTY;

    /**
     * (this field is required)
     */
    public ConferenceSponsorIDType conferenceSponsorIDType() {
        initialize();
        return conferenceSponsorIDType;
    }

    private IDTypeName idTypeName = IDTypeName.EMPTY;

    /**
     * (this field is optional)
     */
    public IDTypeName idTypeName() {
        initialize();
        return idTypeName;
    }

    private IDValue idValue = IDValue.EMPTY;

    /**
     * (this field is required)
     */
    public IDValue idValue() {
        initialize();
        return idValue;
    }

    @Override
    public JonixConferenceSponsorIdentifier asStruct() {
        initialize();
        JonixConferenceSponsorIdentifier struct = new JonixConferenceSponsorIdentifier();
        struct.conferenceSponsorIDType = conferenceSponsorIDType.value;
        struct.idTypeName = idTypeName.value;
        struct.idValue = idValue.value;
        return struct;
    }

    @Override
    public NameCodeTypes structKey() {
        return conferenceSponsorIDType().value;
    }
}
