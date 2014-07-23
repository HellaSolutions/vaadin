/*
 * Copyright 2000-2014 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.tests.push;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.vaadin.tests.tb3.MultiBrowserTest;
import com.vaadin.tests.tb3.WebsocketTest;

public class RefreshCloseConnectionTest extends MultiBrowserTest {
    @Test
    public void testSessionRefresh() {
        openTestURL();

        Assert.assertEquals("1. Init", getLogRow(0));

        openTestURL();

        Assert.assertEquals("2. Refresh", getLogRow(1));
        Assert.assertEquals("3. Push", getLogRow(0));
    }

    @Override
    public List<DesiredCapabilities> getBrowsersToTest() {
        return WebsocketTest.getWebsocketBrowsers();
    }
}