/*
 * ARX: Powerful Data Anonymization
 * Copyright 2012 - 2015 Florian Kohlmayer, Fabian Prasser
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

import java.util.Arrays;
import java.util.Collection;

import org.deidentifier.arx.ARXConfiguration;
import org.deidentifier.arx.criteria.DistinctLDiversity;
import org.deidentifier.arx.criteria.EntropyLDiversity;
import org.deidentifier.arx.criteria.RecursiveCLDiversity;
import org.deidentifier.arx.metric.Metric;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Test for data transformations.
 *
 * @author Fabian Prasser
 * @author Florian Kohlmayer
 */
@RunWith(Parameterized.class)
public class TestAnonymizationLDiversity extends AbstractAnonymizationTest {
    
    /**
     * 
     *
     * @return
     */
    @Parameters(name = "{index}:[{0}]")
    public static Collection<Object[]> cases() {
        return Arrays.asList(new Object[][] {
                                              /* 0 */{ new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new EntropyLDiversity("occupation", 5)), "occupation", TestFilePath("adult"), 228878.2039109517, new int[] { 1, 0, 1, 1, 2, 2, 2, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new EntropyLDiversity("occupation", 100)), "occupation", TestFilePath("adult"), 0.0d, null, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new EntropyLDiversity("occupation", 5)), "occupation", TestFilePath("adult"), 324620.5269918692, new int[] { 1, 1, 1, 1, 3, 2, 2, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new EntropyLDiversity("occupation", 100)), "occupation", TestFilePath("adult"), 0.0d, null, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new EntropyLDiversity("occupation", 5)), "occupation", TestFilePath("adult"), 228878.2039109517, new int[] { 1, 0, 1, 1, 2, 2, 2, 1 }, true) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new EntropyLDiversity("occupation", 100)), "occupation", TestFilePath("adult"), 0.0d, null, true) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createDiscernabilityMetric(true)).addCriterion(new DistinctLDiversity("Highest level of school completed", 5)), "Highest level of school completed", TestFilePath("atus"), 9.123049999E9, new int[] { 0, 3, 0, 0, 2, 0, 1, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createDiscernabilityMetric(true)).addCriterion(new DistinctLDiversity("Highest level of school completed", 100)), "Highest level of school completed", TestFilePath("atus"), 0.0d, null, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new RecursiveCLDiversity("Highest level of school completed", 4d, 5)), "Highest level of school completed", TestFilePath("atus"), 3536911.5162082445, new int[] { 0, 4, 0, 0, 2, 0, 1, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new RecursiveCLDiversity("Highest level of school completed", 4d, 100)), "Highest level of school completed", TestFilePath("atus"), 0.0d, null, false) },
                                              /* 10 */{ new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createDiscernabilityMetric(true)).addCriterion(new DistinctLDiversity("Highest level of school completed", 5)), "Highest level of school completed", TestFilePath("atus"), 2.0146560117E10, new int[] { 0, 3, 0, 2, 2, 2, 2, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createDiscernabilityMetric(true)).addCriterion(new DistinctLDiversity("Highest level of school completed", 100)), "Highest level of school completed", TestFilePath("atus"), 0.0d, null, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new RecursiveCLDiversity("Highest level of school completed", 4d, 5)), "Highest level of school completed", TestFilePath("atus"), 4912828.240033204, new int[] { 0, 4, 0, 2, 2, 2, 2, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new RecursiveCLDiversity("Highest level of school completed", 4d, 100)), "Highest level of school completed", TestFilePath("atus"), 0.0d, null, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createDiscernabilityMetric(true)).addCriterion(new DistinctLDiversity("Highest level of school completed", 5)), "Highest level of school completed", TestFilePath("atus"), 9.123049999E9, new int[] { 0, 3, 0, 0, 2, 0, 1, 0 }, true) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createDiscernabilityMetric(true)).addCriterion(new DistinctLDiversity("Highest level of school completed", 100)), "Highest level of school completed", TestFilePath("atus"), 0.0d, null, true) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new RecursiveCLDiversity("Highest level of school completed", 4d, 5)), "Highest level of school completed", TestFilePath("atus"), 3536911.5162082445, new int[] { 0, 4, 0, 0, 2, 0, 1, 2 }, true) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new RecursiveCLDiversity("Highest level of school completed", 4d, 100)), "Highest level of school completed", TestFilePath("atus"), 0.0d, null, true) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createDiscernabilityMetric(true)).addCriterion(new EntropyLDiversity("RAMNTALL", 5)), "RAMNTALL", TestFilePath("cup"), 2823649.0, new int[] { 4, 0, 0, 1, 1, 3, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createDiscernabilityMetric(true)).addCriterion(new EntropyLDiversity("RAMNTALL", 100)), "RAMNTALL", TestFilePath("cup"), 8.8290083E7, new int[] { 3, 4, 1, 2, 1, 2, 1 }, false) },
                                              /* 20 */{ new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DistinctLDiversity("RAMNTALL", 5)), "RAMNTALL", TestFilePath("cup"), 1244350.7034669477, new int[] { 2, 4, 0, 1, 0, 3, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DistinctLDiversity("RAMNTALL", 100)), "RAMNTALL", TestFilePath("cup"), 1552136.4930241706, new int[] { 3, 4, 1, 2, 0, 2, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createDiscernabilityMetric(true)).addCriterion(new EntropyLDiversity("RAMNTALL", 5)), "RAMNTALL", TestFilePath("cup"), 3.01506905E8, new int[] { 4, 4, 1, 1, 1, 4, 4 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createDiscernabilityMetric(true)).addCriterion(new EntropyLDiversity("RAMNTALL", 100)), "RAMNTALL", TestFilePath("cup"), 6.19637215E8, new int[] { 5, 4, 1, 0, 1, 4, 4 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DistinctLDiversity("RAMNTALL", 5)), "RAMNTALL", TestFilePath("cup"), 1961244.4822559545, new int[] { 4, 4, 1, 1, 1, 4, 4 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DistinctLDiversity("RAMNTALL", 100)), "RAMNTALL", TestFilePath("cup"), 2032837.6390798881, new int[] { 5, 4, 1, 0, 1, 4, 4 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createDiscernabilityMetric(true)).addCriterion(new EntropyLDiversity("RAMNTALL", 5)), "RAMNTALL", TestFilePath("cup"), 2823649.0, new int[] { 4, 0, 0, 1, 1, 3, 1 }, true) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createDiscernabilityMetric(true)).addCriterion(new EntropyLDiversity("RAMNTALL", 100)), "RAMNTALL", TestFilePath("cup"), 8.8290083E7, new int[] { 3, 4, 1, 2, 1, 2, 1 }, true) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DistinctLDiversity("RAMNTALL", 5)), "RAMNTALL", TestFilePath("cup"), 1244350.7034669477, new int[] { 2, 4, 0, 1, 0, 3, 1 }, true) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new DistinctLDiversity("RAMNTALL", 100)), "RAMNTALL", TestFilePath("cup"), 1552136.4930241706, new int[] { 3, 4, 1, 2, 0, 2, 1 }, true) },
                                              /* 30 */{ new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new RecursiveCLDiversity("istatenum", 4d, 5)), "istatenum", TestFilePath("fars"), 590389.0228300437, new int[] { 0, 2, 1, 1, 0, 2, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new RecursiveCLDiversity("istatenum", 4d, 100)), "istatenum", TestFilePath("fars"), 0.0d, null, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DistinctLDiversity("istatenum", 5)), "istatenum", TestFilePath("fars"), 629604.893355563, new int[] { 0, 2, 1, 1, 0, 2, 0 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DistinctLDiversity("istatenum", 100)), "istatenum", TestFilePath("fars"), 0.0d, null, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new RecursiveCLDiversity("istatenum", 4d, 5)), "istatenum", TestFilePath("fars"), 1201007.0880104562, new int[] { 0, 2, 3, 3, 1, 2, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new RecursiveCLDiversity("istatenum", 4d, 100)), "istatenum", TestFilePath("fars"), 0.0d, null, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DistinctLDiversity("istatenum", 5)), "istatenum", TestFilePath("fars"), 1201007.0880104562, new int[] { 0, 2, 3, 3, 1, 2, 2 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DistinctLDiversity("istatenum", 100)), "istatenum", TestFilePath("fars"), 0.0d, null, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new RecursiveCLDiversity("istatenum", 4d, 5)), "istatenum", TestFilePath("fars"), 590389.0228300437, new int[] { 0, 2, 1, 1, 0, 2, 0 }, true) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new RecursiveCLDiversity("istatenum", 4d, 100)), "istatenum", TestFilePath("fars"), 0.0d, null, true) },
                                              /* 40 */{ new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DistinctLDiversity("istatenum", 5)), "istatenum", TestFilePath("fars"), 629604.893355563, new int[] { 0, 2, 1, 1, 0, 2, 0 }, true) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, false)).addCriterion(new DistinctLDiversity("istatenum", 100)), "istatenum", TestFilePath("fars"), 0.0d, null, true) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createDiscernabilityMetric(true)).addCriterion(new RecursiveCLDiversity("EDUC", 4d, 5)), "EDUC", TestFilePath("ihis"), 3.53744964E8, new int[] { 0, 0, 0, 1, 3, 0, 0, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createDiscernabilityMetric(true)).addCriterion(new RecursiveCLDiversity("EDUC", 4d, 100)), "EDUC", TestFilePath("ihis"), 0.0d, null, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new EntropyLDiversity("EDUC", 5)), "EDUC", TestFilePath("ihis"), 8730993.835884217, new int[] { 0, 0, 0, 2, 3, 0, 0, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new EntropyLDiversity("EDUC", 100)), "EDUC", TestFilePath("ihis"), 0.0d, null, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createDiscernabilityMetric(true)).addCriterion(new RecursiveCLDiversity("EDUC", 4d, 5)), "EDUC", TestFilePath("ihis"), 9.85795222E8, new int[] { 0, 0, 0, 3, 3, 2, 0, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createDiscernabilityMetric(true)).addCriterion(new RecursiveCLDiversity("EDUC", 4d, 100)), "EDUC", TestFilePath("ihis"), 0.0d, null, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new EntropyLDiversity("EDUC", 5)), "EDUC", TestFilePath("ihis"), 1.2258628558792587E7, new int[] { 0, 0, 0, 3, 3, 2, 0, 1 }, false) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.0d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new EntropyLDiversity("EDUC", 100)), "EDUC", TestFilePath("ihis"), 0.0d, null, false) },
                                              /* 50 */{ new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createDiscernabilityMetric(true)).addCriterion(new RecursiveCLDiversity("EDUC", 4d, 5)), "EDUC", TestFilePath("ihis"), 3.53744964E8, new int[] { 0, 0, 0, 1, 3, 0, 0, 1 }, true) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createDiscernabilityMetric(true)).addCriterion(new RecursiveCLDiversity("EDUC", 4d, 100)), "EDUC", TestFilePath("ihis"), 0.0d, null, true) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new EntropyLDiversity("EDUC", 5)), "EDUC", TestFilePath("ihis"), 8730993.835884217, new int[] { 0, 0, 0, 2, 3, 0, 0, 1 }, true) },
                                              { new ARXAnonymizationTestCase(ARXConfiguration.create(0.04d, Metric.createPrecomputedEntropyMetric(0.1d, true)).addCriterion(new EntropyLDiversity("EDUC", 100)), "EDUC", TestFilePath("ihis"), 0.0d, null, true) },
                                              
        });
    }
    
    /**
     * 
     *
     * @param testCase
     */
    public TestAnonymizationLDiversity(final ARXAnonymizationTestCase testCase) {
        super(testCase);
    }
    
}
