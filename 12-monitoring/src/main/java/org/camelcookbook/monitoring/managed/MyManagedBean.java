/*
 * Copyright (C) Scott Cranton, Jakub Korab, and Christian Posta
 * https://github.com/CamelCookbook
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.camelcookbook.monitoring.managed;

import org.apache.camel.api.management.ManagedAttribute;
import org.apache.camel.api.management.ManagedOperation;
import org.apache.camel.api.management.ManagedResource;

@ManagedResource(description = "My Managed Bean within Camel")
public class MyManagedBean {
    private int camelsSeenCount;

    public String doSomething(String body) {
        if (body.contains("Camel")) {
            camelsSeenCount++;
        }

        return "Managed " + body;
    }

    @ManagedAttribute(description = "How many Camels Have been Seen")
    public int getCamelsSeenCount() {
        return camelsSeenCount;
    }

    @ManagedOperation(description = "Set Camels Seen Count to Zero")
    public void resetCamelsSeenCount() {
        camelsSeenCount = 0;
    }
}
