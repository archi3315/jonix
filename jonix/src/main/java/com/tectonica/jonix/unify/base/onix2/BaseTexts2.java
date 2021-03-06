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

package com.tectonica.jonix.unify.base.onix2;

import com.tectonica.jonix.onix2.OtherText;
import com.tectonica.jonix.onix2.Product;
import com.tectonica.jonix.unify.base.BaseText;
import com.tectonica.jonix.unify.base.BaseTexts;

import java.util.ArrayList;
import java.util.List;

/**
 * ONIX2 concrete implementation for {@link BaseTexts}
 *
 * @author Zach Melamed
 */
public class BaseTexts2 extends BaseTexts {
    private static final long serialVersionUID = 1L;

    private final transient Product product;

    public BaseTexts2(Product product) {
        this.product = product;
    }

    @Override
    protected List<BaseText> initialize() {
        List<BaseText> list = new ArrayList<>();
        for (OtherText otherText : product.otherTexts()) {
            list.add(new BaseText2(otherText));
        }
        return list;
    }
}
