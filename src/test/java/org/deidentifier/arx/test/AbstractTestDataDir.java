/*
 * ARX: Powerful Data Anonymization
 * Copyright 2012 - 2016 Florian Kohlmayer, Fabian Prasser
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

package org.deidentifier.arx.test;

import org.deidentifier.arx.Data;

import java.io.IOException;

/**
 * Test Data Directory Provider
 *
 * This abstract class provides all Unit test classes with the test data directory.
 * The directory can be passed as system property <b>test.data.dir</b>, either absolute,
 * or relative to the arx directory. If not specified, the default "../arx-data/data-junit/" is used.
 *
 * @author Sebastian Stammler (stammler@cbs.tu-darmstadt.de)
 */
public abstract class AbstractTestDataDir {
    /**
     * Constant string pointing to the data directory
     */
    protected static String TestDataDir = System.getProperty("test.data.dir", "../arx-data/data-junit/");

    protected static Data TestData(String s) throws IOException {
        return Data.create(TestDataDir + s + ".csv", ';');
    }

}
